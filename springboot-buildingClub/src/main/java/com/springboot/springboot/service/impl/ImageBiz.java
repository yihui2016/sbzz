package com.springboot.springboot.service.impl;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.springboot.springboot.constant.Constant;
import com.springboot.springboot.constant.ErrorCodeEnum;
import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;
import com.springboot.springboot.util.CommonUtil;

@Component
public class ImageBiz {
	
	private static final Base64.Decoder decoder = Base64.getDecoder();
	private static final String PATH = "C:\\SportAPI\\SportAPI\\img\\";

	public ResponseDTO<String> postUserImage(String imgUri) {
		if(CommonUtil.isNullOrEmpty(imgUri) || !imgUri.contains("data:image")){
			return new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG);
		}
		
		String suffix = imgUri.substring(imgUri.indexOf("/") + 1, imgUri.indexOf(";"));
		String imgFilePath = System.currentTimeMillis() + "." + suffix;
		imgUri = imgUri.substring(imgUri.indexOf(",") + 1);
		try {
			byte[] bytes = decoder.decode(imgUri);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(PATH + imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return new ResponseDTO<>(imgFilePath);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseDTO<>(ErrorCodeEnum.ERROR);
		}
	}
}
