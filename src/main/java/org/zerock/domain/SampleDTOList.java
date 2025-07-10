package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	
	private List<SampleDTO> list; // dto 객체를 가지고있는 리스트
	
	public SampleDTOList() {
		list = new ArrayList<SampleDTO>();
	}// 생성자
	// new SampleDTOList() -> 리스트에 dto를 가지고있는 객체 생성됨.
	

}
