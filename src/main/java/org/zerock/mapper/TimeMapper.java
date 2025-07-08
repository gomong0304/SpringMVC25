package org.zerock.mapper; // 요 패키지가 마이바티스에서 관리가 되야함 ->root-context로 이동->밑에 네임스페이스

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	// 인터페이스는 추상메서드를 사용한다.
	// 추상메서드 : 메서드명만 존재하고 실행문이 없다.
	// 사용하려면 class에 implements와 뒤에 인터페이스명을 사용한다.
	
	@Select("SELECT sysdate FROM dual") // 주의사항!! ; 없이 넣음. dual->가상테이블 sysdate->현재 날짜
	public String getTime(); 
	// 인터페이스에 선언된 메서드는 추상메서드로 밑에 {실행문}이 따로 없다.
	// 관례 : sql 쿼리문은 대문자로 쓰는게 관례임.
	
	public String getTime2(); // 추상메서드로 실행문이 없음
	// 이 메서드가 호출되면 마이바티스에서 xml을 찾음
}
