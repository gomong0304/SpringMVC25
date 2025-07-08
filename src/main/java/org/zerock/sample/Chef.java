package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링이 의존성 처리해줘~ 알아서 해줘~
@Data	   // import lombok.Data; dto 처리용 (게터/세터, toString, eq..등을 자동화 시켜줌)
public class Chef {

	private String name;
	private int age;
	
}


