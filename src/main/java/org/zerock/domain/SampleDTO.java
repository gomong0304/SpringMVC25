package org.zerock.domain;

import lombok.Data;

@Data //lombok이 DTO를 관리한다.
public class SampleDTO {

	// 자바빈즈 규약
	// 1.필드는 PRIVATE
	// 2.생성자는 기본생성자 필수
	// 3.게터/세터를 사용
	// lombok을 이용하면 자동으로 생성된다.
	
	private String name;
	private int age;
	
}
