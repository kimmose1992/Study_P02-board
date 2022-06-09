package com.gdgs.slyouth.cm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gdgs.slyouth.cm.handler.CmGlobalHandler;

/**
 * @title	: 공통 WebMvcConfigurer 구현 클래스	  
 * @author	: mosekim
 * @create	: 2021.07.06
 */
@Configuration
public class CmWebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CmGlobalHandler())
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/images/**")
				.excludePathPatterns("/cm/uploadSummernoteImageFile")
				.excludePathPatterns("/cm/viewImage/");
	}
}
