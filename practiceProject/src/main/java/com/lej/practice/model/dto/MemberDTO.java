package com.lej.practice.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Lombok 라이브러리 이용

//Lombok : 자주 사용하는 코드를 컴파일 시 자동완성 해주는 라이브러리
//-> DTO(기본생성자, getter/setter, toString), Log
// 어노테이션만 써두면 알아서 자동 완성된다

@NoArgsConstructor // 기본 생성자 // 전달인자가 없는 컨스트럭터 == 기본 생성자
@Getter //  getter  자동 완성
@Setter // setter 자동 완성
@ToString //toString 오버 라이딩
public class MemberDTO {
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;

}
