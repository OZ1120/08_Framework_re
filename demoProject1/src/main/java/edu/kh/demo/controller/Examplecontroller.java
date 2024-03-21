package edu.kh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Examplecontroller {
	
	@GetMapping("example")
	public String exampleMethod() {
		
		return "example";
		// src/main/reources/template/example.html 이지만
		// 싸악다 지우고 example만 남기면 view resolver가 알아서 해줌
	}

}// 읁

// 1. 객체 만들어주기 : 어노테이션 Controller

/* 요청 주소 매핑하는 방법
 * 1)@RequestMapping("주소")
 * 2) @GetMapping("주소") : get방식 매핑
 * 	  @PostMapping : post방식 매핑
*	  @PutMapping("주소")  : PUT(수정) 방식 요청 매핑
*		수정하는 매핑			(form,js,a태그 요청 불가) 비동기 만 가능
*	  @DeleteMapping("주소") : DELETE (삭제) 방식 요청 매핑
*		삭제방식 매핑         (form,js,a태그 요청 불가)
 */






