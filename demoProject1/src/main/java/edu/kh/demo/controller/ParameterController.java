package edu.kh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("param") // param으로 시작하는 요청 전부 현재 컨트롤러로 매핑
@Slf4j // log를 이용한 메시지 출력 시 사용(Lombok 제공)
public class ParameterController {
	
	@GetMapping("main")
	public String paramMain() {
		return "param/param-main";
	}
	
	@PostMapping("test1")
	public String paramTest1(HttpServletRequest req) {
		String inputName    = req.getParameter("inputName");
		String inputAddress = req.getParameter("inputAddress");
		int inputAge = Integer.parseInt( req.getParameter("inputAge") );

		log.debug("inputName : " + inputName);
		log.debug("inputAddress : " + inputAddress);
		log.debug("inputAge : " + inputAge);
		
		return "redirect:/param/main";
	}
	
	@PostMapping("test2")
	public String paramTest2(
			@RequestParam("title") String title,
			@RequestParam("writer") String writer,
			@RequestParam("price") int price,
			@RequestParam(value="publisher", required=false,
					defaultValue = "교보문고") String publisher
			) {

		log.debug("title : "+ title);
		log.debug("writer : "+ writer);
		log.debug("price : "+ price);
		log.debug("publisher : "+ publisher);
		
		return "redirect:/param/main";
	}
	
	

}//







/* Spring의 Controller 메서드 작성 시
 * 매개 변수에 원하는 객체를 작성하면
 * 존재하는 객체를 바인딩 또는 없으면 생성해서 바인딩(묶거나 연결)
 * 
 * --> ArgumentResolver(전달 인자 해결사)
 * https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-methods/arguments.html
 * */
