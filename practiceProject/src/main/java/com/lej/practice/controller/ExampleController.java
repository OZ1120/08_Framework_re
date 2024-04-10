package com.lej.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller // 요청 응답 제어, Bean 객체 등록 == 스프링이 관리한다, 개발자가 안한다
public class ExampleController {

	/* 요청 주소 매핑(연결)하는 방법
	 * 
	 * 1) @RequestMapping("주소")
	 * 
	 * 2) @GetMapping("주소")  : GET (조회)방식 요청 매핑
	 * 
	 *	  @PostMapping("주소") : POST(삽입) 방식 요청 매핑
	 *
	 *	  @PutMapping("주소")  : PUT(수정) 방식 요청 매핑
	 *							(form,js,a태그 요청 불가)
	 *	  @DeleteMapping("주소") : DELETE (삭제) 방식 요청 매핑
	 *							(form,js,a태그 요청 불가)
	 */
	
	
	@GetMapping("example") // example GET 방식 요청. /는 자동 추가!
	public String exampleMethod() {
		
		// forward 하려는 html 파일 경로 접두사,접미사 빼고 작성!
		return "example";
	}
	
}


//
