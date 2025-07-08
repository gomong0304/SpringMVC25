package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
	@Setter(onMethod_ = @Autowired)
	private Chef chef; // 원래 써먹으려면 Chef chef=new Chef(); 이렇게 써서 사용했는데 생략할수 있음

}
