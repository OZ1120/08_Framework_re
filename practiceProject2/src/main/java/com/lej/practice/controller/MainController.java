package com.lej.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//Controller : 요청에 따라 알맞은 서비스 호출 :: 어떤 서비스 가져올까?
//				+ 서비스 결과에 따라 어떤 응답을 할지 제어 
//					:: redirect하니 forward하니? redirect는 어떤걸로?
// 어노테이션 : 컴파일러가 보는 주석 -> 명령 줄테니 확인하고 일해라

@Controller // 요청,응답 제어/Bean 등록 : 스프링이 만들어서 관리하는 객체 등록
public class MainController {
	

	// "/" 주소 요청 시 해당 메서드와 매핑
	// - 메인 페이지 지정 시에는 "/" 작성 가능 ::다른곳에서는 / 제외하고 작성
	@RequestMapping("/")
	public String mainPage() {

		// forward : 요청 위임 - 할일 넘기기 왜? 화면 만드는게 html이 더 쉬워서

		// thymeleaf : Spring Boot에서 사용하는 템플릿 엔진
		//			Spring Boot 말고 다른곳에서도 설정하면 사용가능
		
		// thymeleaf를 이용한 html 파일로 forward 시
		// 사용되는 접두사, 접미사가 존재 :: spring 안에 내장되어있음 
		
		// 접두사 : classpath:/templates/
		// 접미사 : .html
		// :: View Resolver가 forward 해줌
		return "common/main";
		// :: :"classpath:/templates/common/main.html"
	}
	
	// 타임리프 예제 1
}
