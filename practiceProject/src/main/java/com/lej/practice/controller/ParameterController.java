package com.lej.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("param") // param으로 시작하는 요청을 현재 컨트롤러로 매핑
@Controller // 요청응답 제어 명시, bean 등록 == 스프링이 만들고 관리하는 객체 등록
@Slf4j // log를 이용한 메시지 출력 시 사용(Lombok 제공)
public class ParameterController {
	
	// 서버로 파라미터 제출하기 - 페이지 forward
	@GetMapping("main")
	public String paramMain() {
		return "param/param-main";
	}
	
	/* 1. HttpServletRequest.getParamener("key") 이용 */
	
	// HttpServletRequest :
	// - 요청 클라이언트 정보, 제출된 파라미터 등을 저장한 객체
	// - 클라이언트 요청 시 생성
	
	/* Spring의 Controller 메서드 작성 시
	 * 매개 변수에 원하는 객체를 작성하면
	 * 존재하는 객체를 바인딩 또는 없으면 생성해서 바인딩
	 * 
	 * --> ArgumentResolver(전달 인자 해결사)
	 * https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-methods/arguments.html
	 * ServerHttpRequest 의 자식이 HttpServletRequest
	 * */
	
	
	@PostMapping("test1") // /param/test1 의 POST방식 매핑
	public String test1(HttpServletRequest req) {
		
		// @Slf4j // log를 이용한 메시지 출력 시 사용(Lombok 제공)
		// 얘 써놔서 밑에꺼 자동으로 사용 가능, 필드 안써도 log 사용가능하다
		// private LoggerFactory log;
		
		String inputName = req.getParameter("inputName");
		String inputAddress = req.getParameter("inputAddress");
		// 형변환 , 데이터파싱
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));

		// 41번줄 참조
		// debug : 코드 오류 해결
		// -> 코드 오류는 없는데 정상 수행이 안될 때
		//  -> 값이 잘못된 경우-> 값 추적
		// application.properties 에 로그레벨 지정 해야함.
		// return 제대로 안되이쓰면 나온다
		// 제대로 써있으면 안나온다
		log.debug("inputName : " + inputName);
		log.debug("inputAddress : " + inputAddress);
		log.debug("inputAge : " + inputAge);

		/* Spring에서 Redirect(재요청) 하는 방법	
		 * 
		 *  -Controller 메서드 반환값에
		 *  "redirect : 요청주소"; 작성
		 *  */
		
		return "redirect:/param/main";
	}


	/* 2. @RequestParam 어노테이션 - 낱개(한 개, 단 수)개 파라미터 얻어오기
	 * 
	 * - request객체를 이용한 파라미터 전달 어노테이션 
	 * - 매개 변수 앞에 해당 어노테이션을 작성하면, 매개변수에 값이 주입됨.
	 * - 주입되는 데이터는 매개 변수의 타입이 맞게 형변환/파싱이 자동으로 수행됨!
	 * 
	 * [기본 작성법]
	 * @RequestParam("key") 자료형 매개변수명
	 * 요청할때 넘어온 key를 매개변수명에 저장해라
	 * 
	 * [속성 추가 작성법]
	 * @RequestParam(value="name", required="false", defaultValue="1") 
	 * 
	 * value : 전달 받은 input 태그의 name 속성값
	 * 
	 * required : 입력된 name 속성값 파라미터 필수 여부 지정(기본값 true) 
	 * 	-> required = true인 파라미터가 존재하지 않는다면 400 Bad Request 에러 발생 
	 * 	-> required = true인 파라미터가 null인 경우에도 400 Bad Request
	 * 
	 * defaultValue : 파라미터 중 일치하는 name 속성 값이 없을 경우에 대입할 값 지정. 
	 * 	-> required = false인 경우 사용 --필수가 아닐때만 사용가능
	 */
	
	
	// 400 Bad Request (잘못된 요청)
	// - 파라미터 불충분 상황
	
	@PostMapping("test2")
	public String paramTest2(
			@RequestParam("title")String title,
			@RequestParam("writer")String writer,
			@RequestParam("price")int price,
			@RequestParam(value="publisher", required=false, defaultValue="교보문고")String publisher
			) {
		log.debug("title : "+ title);
		log.debug("writer : "+ writer);
		log.debug("price : "+ price);
		log.debug("publisher : "+ publisher);
		
		return "redirect:/param/main";
	}

}
