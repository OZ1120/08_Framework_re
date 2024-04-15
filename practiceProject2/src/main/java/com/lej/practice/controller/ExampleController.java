package com.lej.practice.controller;

// 예제용 응답 제어 컨트롤러
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller // 요청,응답 제어 역할 명시 +Bean 등록 : 스프링이 만들고 관리하는 객체
@RequestMapping("example") // /example로 시작하는 주소 해당 컨트롤러에 매핑
@Slf4j // lombok 라이브러리 제공 ,로그객체 자동생성
public class ExampleController {
	/* Model
	 * - Spring에서 데이터 전달 역할을 하는 객체
	 * - org.springframwork.ui 패키지
	 * - 기본 scope : request :: request scope 기본 범위
	 * - @SessionAttributes 와 함께 사용 시 session scope변환 
	 * 
	 * [기본 사용 법]
	 * Model.addAttribute("key",value);

	 * (참고)
	 * - Model과 비슷한 ModelAndView도 존재 :: 요즘안쓴대
	 * - ModelAndView : 데이터 전달 + forward할 파일 경로 지정
	 */
	
	
	@GetMapping("ex1")
	public String ex1(HttpServletRequest req,Model model) {
		// Servlet/JSP 내장 객체 범위(scope)
		// page < request < session < application\
		// 해당페이지 < 요청 받은곳/위임된곳<브라우저 만료시까지 < 서버가 켜지고 꺼질때까지
		// request scope(한번만쓰고 없어짐) 가장 많이씀

		req.setAttribute("test1", "HttpServletRequest로 전달한 값");
		model.addAttribute("test2","Model로 전달한 값");
		
		
		return "example/ex1"; // templates/example/ex1.html 요청위임
	}
	

	
	
	
}
