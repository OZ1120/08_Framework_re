package edu.kh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller // 요청/응답제어 어노테이션 (Bean등록)
public class TestController {
	          // 매핑 주소 앞에 / 안씀!
	@RequestMapping("test") // /test 요청시 처리할 메서드 매핑
	public String testMethod() {
		System.out.println("/test 요청 받음");
		
		return "test";
	}

}// 읁




//Java 객체 : new 연산자에 의해 Heap 영역에
//클래스에 작성된 내용대로 생성된 것

//instance : 개발자가 만들고 관리하는 객체- 내가 만들어서 내가 관리하고~
//Bean(콩) : 스프링이 만들고 관리하는 객체 - 스프링이 다 관리함. 내가 할거 없이
//		@Controller 해두면 Bean 등록 해줌


	/* Controller 메서드의 반환형이 String 인 이유
	 * - 메서드에서 반환되는 문자열이
	 * 	 forwad할 html파일의 경로가 되기때문
	 * */
// 

/* Thymeleaf : JSP대신 사용하는 템플릿 엔진
 * 
 * classpath; == src/main/resources
 * 접두사 : classpath:/templates/
 * 접미사 :.html
 * src/main/resources/templates/test.html -- 원 경로
 * 접두사 접미사 다떼면 test만 남는다
 * 
 */
/* 접두사, 접미사, forward 설정은 View Resolver 객체가 담당 */
// View resolver에서 요청주소 받아서 전체 주소 보내줌
