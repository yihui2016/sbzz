package com.springboot.springboot.dto.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.springboot.dao.model.BodyParam;
import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.BodyParamDTO;
import com.springboot.springboot.dto.UserInfoDTO;

@Component
public class UserDtoHelper {

	public User toModel(UserInfoDTO dto) {
		if (dto == null) {
			return null;
		}
		User model = new User();
		model.setAge(dto.getAge());
		model.setHeight(dto.getHeight());
		model.setImguri(dto.getImgUri());
		model.setJob(dto.getJob());
		model.setName(dto.getName());
		model.setPassword(dto.getPassword());
		model.setPhone(dto.getPhone());
		model.setRole(dto.getRole());
		model.setTarget(dto.getTarget());
		model.setPid(dto.getPid());
		model.setSex(dto.getSex());
		model.setNo(dto.getNo());
		return model;
	}

	public UserInfoDTO toDto(User model) {
		if (model == null) {
			return null;
		}
		UserInfoDTO dto = new UserInfoDTO();
		dto.setId(model.getId());
		dto.setCreationTime(model.getCreationTime());
		dto.setAge(model.getAge());
		dto.setHeight(model.getHeight());
		dto.setImgUri(model.getImguri());
		dto.setJob(model.getJob());
		dto.setName(model.getName());
		dto.setPassword(model.getPassword());
		dto.setPhone(model.getPhone());
		dto.setRole(model.getRole());
		dto.setTarget(model.getTarget());
		dto.setPid(model.getPid());
		dto.setPid(model.getPid());
		dto.setSex(model.getSex());
		dto.setNo(model.getNo());
		return dto;
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

	
	public BodyParam toBodyParamModel(BodyParamDTO dto) {
		if (dto == null) {
			return null;
		}
		BodyParam model = new BodyParam();
		model.setCreationTime(dto.getCreationTime());
		model.setCreatorId(dto.getCreatorId());
		model.setUserId(dto.getUserId());
		model.setId(dto.getId());
		model.setBust(dto.getBust());
		model.setExtraInfo(dto.getExtraInfo());
		model.setHipline(dto.getHipline());
		model.setImguri(dto.getImgUri());
		model.setLeftArm(dto.getLeftArm());
		model.setLeftThigh(dto.getLeftThigh());
		model.setRightArm(dto.getRightArm());
		model.setRightThigh(dto.getRightThigh());
		model.setWaistline(dto.getWaistline());
		model.setWeight(dto.getWeight());
		return model;
	}
	
	public BodyParamDTO toBodyParamDto(BodyParam model) {
		if (model == null) {
			return null;
		}
		BodyParamDTO dto = new BodyParamDTO();
		dto.setCreationTime(model.getCreationTime());
		dto.setCreatorId(model.getCreatorId());
		dto.setUserId(model.getUserId());
		dto.setId(model.getId());
		dto.setBust(model.getBust());
		dto.setExtraInfo(model.getExtraInfo());
		dto.setHipline(model.getHipline());
		dto.setImgUri(model.getImguri());
		dto.setLeftArm(model.getLeftArm());
		dto.setLeftThigh(model.getLeftThigh());
		dto.setRightArm(model.getRightArm());
		dto.setRightThigh(model.getRightThigh());
		dto.setWaistline(model.getWaistline());
		dto.setWeight(model.getWeight());
		return dto;
	}
	
	public List<BodyParamDTO> toBodyParamDtos(List<BodyParam> models) {
		List<BodyParamDTO> dtos = new ArrayList<>();
		if (models == null || models.isEmpty()) {
			return dtos;
		}
		for (BodyParam user : models) {
			dtos.add(toBodyParamDto(user));
		}
		return dtos;
	}
}
