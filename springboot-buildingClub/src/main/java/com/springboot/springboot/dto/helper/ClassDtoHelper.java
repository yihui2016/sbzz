package com.springboot.springboot.dto.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.springboot.dao.model.ClassRecord;
import com.springboot.springboot.dao.model.ClassRecordDetail;
import com.springboot.springboot.dto.ClassRecordDTO;
import com.springboot.springboot.dto.ClassRecordDetailDTO;

@Component
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

	public ClassRecordDTO toDto(ClassRecord model, ClassRecordDTO dto) {
		if (model == null) {
			return null;
		}
		dto.setAfterStatus(model.getAfterStatus());
		dto.setBodyStatus(model.getBodyStatus());
		dto.setBriefInfo(model.getBriefInfo());
		dto.setCoachCheck(model.getCoachCheck());
		dto.setCreationTime(model.getCreationTime());
		dto.setCreatorId(model.getCreatorId());
		dto.setEatStatus(model.getEatStatus());
		dto.setEndTime(model.getEndTime());
		dto.setId(model.getId());
		dto.setReview(model.getReview());
		dto.setSleepStatus(model.getSleepStatus());
		dto.setStartTime(model.getStartTime());
		dto.setTarget(model.getTarget());
		dto.setUserCheck(model.getUserCheck());
		dto.setUserId(model.getUserId());
		return dto;
	}
	
	public ClassRecordDTO toDto(ClassRecord model) {
		ClassRecordDTO dto = new ClassRecordDTO();
		return toDto(model, dto);
	}

	public List<ClassRecordDTO> toDtos(List<ClassRecord> models) {
		List<ClassRecordDTO> dtos = new ArrayList<>();
		if (models == null || models.isEmpty()) {
			return dtos;
		}
		for (ClassRecord record : models) {
			dtos.add(toDto(record));
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

	public ClassRecordDetailDTO toDetailDto(ClassRecordDetail model) {
		if (model == null) {
			return null;
		}
		ClassRecordDetailDTO dto = new ClassRecordDetailDTO();
		dto.setId(model.getId());
		dto.setClassRecordId(model.getClassRecordId());
		dto.setExtraInfo(model.getExtraInfo());
		dto.setName(model.getName());
		dto.setRound(model.getRound());
		dto.setStrength(model.getStrength());
		dto.setTimes(model.getTimes());
		return dto;
	}

	public List<ClassRecordDetailDTO> toDetailDtos(List<ClassRecordDetail> models) {
		List<ClassRecordDetailDTO> dtos = new ArrayList<>();
		if (models == null || models.isEmpty()) {
			return dtos;
		}
		for (ClassRecordDetail detail : models) {
			dtos.add(toDetailDto(detail));
		}
		return dtos;
	}
}
