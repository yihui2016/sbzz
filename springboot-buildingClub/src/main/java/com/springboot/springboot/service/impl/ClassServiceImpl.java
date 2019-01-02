package com.springboot.springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springboot.constant.ErrorCodeEnum;
import com.springboot.springboot.dao.mapper.ClassRecordDetailMapper;
import com.springboot.springboot.dao.mapper.ClassRecordMapper;
import com.springboot.springboot.dao.model.ClassRecord;
import com.springboot.springboot.dao.model.ClassRecordDetail;
import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.ClassRecordDTO;
import com.springboot.springboot.dto.ClassRecordDetailDTO;
import com.springboot.springboot.dto.ClassRecordWithDetailDTO;
import com.springboot.springboot.dto.ListPagesDTO;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;
import com.springboot.springboot.dto.UserInfoDTO;
import com.springboot.springboot.dto.helper.ClassDtoHelper;
import com.springboot.springboot.service.ClassService;
import com.springboot.springboot.util.CommonUtil;

@Service(value = "classService")
public class ClassServiceImpl implements ClassService {
	private static final Logger logger = LoggerFactory.getLogger(ClassServiceImpl.class);

	@Resource
	ClassRecordMapper classRecordMapper;
	@Resource
	ClassRecordDetailMapper classRecordDetailMapper;
	@Autowired
	ClassDtoHelper helper;

	@Override
	public ResponseDTO<String> createClass(String userId, ClassRecordWithDetailDTO data, SessionDTO session) {
		List<ClassRecord> records = classRecordMapper.selectByUserIdAndStartTimeAndEndTime(userId, data.getStartTime(),
				data.getEndTime());
		// 判断用户是否在时间区间内已有课程
		if (records != null && !records.isEmpty()) {
			// 新添加的课程与原有课程有时间冲突
			return new ResponseDTO<>(ErrorCodeEnum.RESOURCE_EXISTED);
		}

		// 课程记录
		ClassRecord model = helper.toModel(data);
		String classId = CommonUtil.getGenerateUUID();
		model.setId(classId);
		model.setUserId(userId);
		model.setCreationTime(System.currentTimeMillis());
		model.setCreatorId(session.getUserId());
		model.setDeleteFlag(false);
		model.setUserCheck(null);
		model.setCoachCheck(null);
		classRecordMapper.insert(model);

		// 具体条目
		List<ClassRecordDetailDTO> details = data.getDetails();
		for (ClassRecordDetailDTO dto : details) {
			ClassRecordDetail detail = helper.toDetailModel(dto);
			detail.setClassRecordId(classId);
			detail.setId(CommonUtil.getGenerateUUID());
			classRecordDetailMapper.insert(detail);
		}

		return new ResponseDTO<>(classId);
	}

	@Override
	public ListPagesDTO<ClassRecordDTO> listClassRecords(SessionDTO session, String userId, Integer offset,
			Integer limit) {
		List<ClassRecord> users = classRecordMapper.selectByUserId(userId, offset, limit);
		long count = classRecordMapper.countByUserId(userId);

		List<ClassRecordDTO> data = helper.toDtos(users);
		ListPagesDTO<ClassRecordDTO> r = new ListPagesDTO<>(data, count, offset, limit);
		return r;
	}

	@Override
	public ResponseDTO<ClassRecordWithDetailDTO> getClassRecord(SessionDTO session, String id) {
		ClassRecord record = classRecordMapper.selectByPrimaryKey(id);
		if (record == null) {
			return new ResponseDTO<>(ErrorCodeEnum.NOT_FOUND);
		}
		ClassRecordWithDetailDTO r = new ClassRecordWithDetailDTO();
		helper.toDto(record, r);

		List<ClassRecordDetail> details = classRecordDetailMapper.selectByClassRecordId(r.getId());
		List<ClassRecordDetailDTO> detailDtos = helper.toDetailDtos(details);
		r.setDetails(detailDtos);
		return new ResponseDTO<>(r);
	}

}
