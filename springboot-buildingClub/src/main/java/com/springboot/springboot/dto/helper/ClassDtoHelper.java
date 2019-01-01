package com.springboot.springboot.dto.helper;

import java.util.ArrayList;
import java.util.List;

import com.springboot.springboot.dao.model.ClassRecord;
import com.springboot.springboot.dao.model.ClassRecordDetail;
import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.ClassRecordDTO;
import com.springboot.springboot.dto.ClassRecordDetailDTO;
import com.springboot.springboot.dto.UserInfoDTO;

public class ClassDtoHelper {

	public ClassRecord toModel(ClassRecordDTO dto) {
		if (dto == null) {
			return null;
		}
		ClassRecord model = new ClassRecord();
		model.setAfterStatus(dto.getAfterStatus());
		model.setBodyStatus(dto.getBodyStatus());
		model.setBriefInfo(dto.getBriefInfo());
		model.setCoachCheck(dto.getCoachCheck());
		model.setCreationTime(dto.getCreationTime());
		model.setCreatorId(dto.getCreatorId());
		model.setEatStatus(dto.getEatStatus());
		model.setEndTime(dto.getEndTime());
		model.setId(dto.getId());
		model.setReview(dto.getReview());
		model.setSleepStatus(dto.getSleepStatus());
		model.setStartTime(dto.getStartTime());
		model.setTarget(dto.getTarget());
		model.setUserCheck(dto.getUserCheck());
		model.setUserId(dto.getUserId());
		return model;
	}

	public UserInfoDTO toDto(User model) {
		return null;
	}

	public List<UserInfoDTO> toDtos(List<User> models) {
		List<UserInfoDTO> dtos = new ArrayList<>();
		if (models == null || models.isEmpty()) {
			return dtos;
		}
		for (User user : models) {
			dtos.add(toDto(user));
		}
		return dtos;
	}

	public ClassRecordDetail toDetailModel(ClassRecordDetailDTO dto) {
		if (dto == null) {
			return null;
		}
		ClassRecordDetail model = new ClassRecordDetail();
		model.setId(dto.getId());
		model.setClassRecordId(dto.getClassRecordId());
		model.setExtraInfo(dto.getExtraInfo());
		model.setName(dto.getName());
		model.setRound(dto.getRound());
		model.setStrength(dto.getStrength());
		model.setTimes(dto.getTimes());
		return model;
	
	}
}
