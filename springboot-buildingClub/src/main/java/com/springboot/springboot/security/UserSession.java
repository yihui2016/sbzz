package com.springboot.springboot.security;

import java.lang.annotation.*;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@AuthenticationPrincipal
public @interface UserSession {
	/**
	 * 项目启动 自动加载配置文件 SecurityConfig 添加authenticate 指向 tokenAuthenticationProvider
	 * 在controller方法参数加上这个注解 由于有 @AuthenticationPrincipal 进而触发 SecurityConfig
	 * 
	 * 
	 * 
	 */
}