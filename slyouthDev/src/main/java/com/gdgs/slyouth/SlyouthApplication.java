package com.gdgs.slyouth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SlyouthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlyouthApplication.class, args);
	}

	// 파일 업로드 경로
	@Bean(name="uploadPath")
	public String uploadPath() {
	    return "/var/lib/slyouth/upload/";
	}
}
