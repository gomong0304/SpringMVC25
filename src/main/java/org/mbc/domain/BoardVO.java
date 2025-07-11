package org.mbc.domain;

import java.util.Date;

import lombok.Data;

@Data // import lombok.Data; (생성자, 게터/세터, toString, 등...알아서 만들어줌 대신 자바 빈즈 규약에 맞출 것)
public class BoardVO {
	// 객체용으로 VO는 읽기전용 속성이 강하게 만드는 객체(Getter 위주로 세팅)
	// DTO는 게터/세터 모두 가지고 활용하는 객체
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate; // import java.util.Date;
	private Date updateDate;
	
}
