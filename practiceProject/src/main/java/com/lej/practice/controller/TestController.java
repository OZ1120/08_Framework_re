package com.lej.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 요청,응답 제어할 컨트롤러 역할 
			// + Bean 등록 (객체 생성후 스프링이 관리, 개발자가 관리하지 않는다)
public class TestController {
	
	// 기존 Servlet : 클래스 단위로 하나의 요청만 처리 가능
	
	// Spring : 메서드 단위로 요청 처리 가능 ( 한개의 메서드 안에 여러 클래스 사용 가능)
	
	// @RequestMapping("요청주소")
	// - 요청 주소를 처리할 메서드를 매핑하는 어노테이션
	// 요청 주소에 / 쓰지말기를 권장
	
	// 1) 메서드에 작성 :
	// 	- 요청 주소와 메서드를 매핑
	// 	- GET/POST 가리지 않고 매핑(속성을 통해서 지정가능)
	
	// 2) 클래스에 작성
	// 	- 공통 주소를 매핑
	//	ex) /todo/insert, /todo/select, /todo/update
	// @RequestMapping("todo") 
	// public class 클래스명{
	// 	 @ReuquestMapping("insert")  // /todo/insert 매핑
	//	 public String 메서드명(){}
	// 	 @ReuquestMapping("update")  // /todo/update 매핑
	//	 public String 메서드명(){}
	// }
	
	
	/* ************************************************* */
	// Spring Boot Controller에서
	// 특수한 경우를 제외하고
	// 매핑 주소 제일 앞에 "/"를 작성하지 않는다!!!!!!
	// 쓰지마. 그냥 쓰지마.
	/* ***************************************************/
	
	@RequestMapping("test")
	public String testMethod() {
		System.out.println("/test 요청 받음");

		/* Controller 메서드의 반환형이 String 인 이유
		 * - 메서드에서 반환되는 문자열이
		 * 	 forward할 html파일의 경로가 되기때문
		 * : return에다 경로 적으면 된다아
		 * */
		/* Thymeleaf : JSP대신 사용하는 템플릿 엔진
		 * 
		 * classpath; == src/main/resources
		 * 접두사 : classpath:/templates/
		 * 접미사 :.html
		 */
		
		// 프로젝트안 세부 경로
		// src/main/resources/templates/test.html 라고 적어야 되는데
		// Thymeleaf 사용(JSP 대신 사용하는 템플릿 엔진) -> build.gradle에 있다
		// 얘가 접두사랑 접미사 제공 -> 자동 완성?정도로 보믄 될듯
		// 그래서 걍 다 지우고 test만 쓰면 된다
		return "test";
		/* 접두사, 접미사, forward 설정은 View Resolver 객체가 담당 */
	}

}
