package com.basic.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
	1. 설정 클래스의 역할
	2. 컴포넌트 스캐닝
	3. 부트가 제공하는 Auto Configuration 활성화
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		//SpringApplication.run(Application.class, args);
		SpringApplication application = new SpringApplication(Application.class);
		application.setWebApplicationType(WebApplicationType.SERVLET); //웹어플리케이션 타입 지정
		application.run(args);
	}


}
