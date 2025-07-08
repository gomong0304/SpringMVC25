package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component					// org.springframework.stereotype.Component;
@ToString					// lombok.ToString;
@Getter						// lombok.Getter;
@RequiredArgsConstructor	// @NonNull만 생성자로 넣음
//@AllArgsConstructor		// 모든 필드값을 이용해서 생성자 주입


public class SampleHotel {
	// 묵시적 자동 주입 : 
	// 스프링의 의존성(dependencies) 주입은 생성자 주입과 세터 주입을 자주 사용한다.
	// 생성자 주입은 lombok이 알아서 파라미터를 만들어줌
	// 생성자 주입의 경우 객체 생성 시 의존성 주입이 필요하므로 좀더 엄격하게 의존성 주입을 체크함.
	// 세터 주입은 값을 저장 시 자동으로 생성해줌. @Setter(onMethod_ =@Autowired)

	@NonNull
	private Chef chef; // 필드
	
	
	private Restaurant restaurant;
	
	
	private String name;
	
	/*
	 * public SampleHotel(Chef chef) { this.chef = chef; }// 커스텀 생성자 -> 기본생성자 없음.
	 */
	
}
