package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;

public interface BoardService {
	// 인터페이스는 단독으로 사용할 수 없는 객체다
	// 여기서 선언한 메서드는 무조건 추상메서드로 사용된다.(실행문 없이 끝난다 -> ;)
	// 인터페이스를 사용하려면구현 클래스를 만들고 실행문을 넣게된다.
	// 인터페이스를 사용하는 이유는 조장이 메서드명을 강제로 셋팅하기 위함이다.
	
	public void register(BoardVO board); //조장이 만든 메서드명 (시그니처)
	// 게시판 등록용 메서드
	
	public BoardVO get(Long bno);
	// 게시글 자세히 보기 (번호를 넣으면 객체가 나와야한다.)
	
	public boolean modify(BoardVO board);
	// 게시글 수정하기 (객체가 들어가서 수정이 됐는지 T/F 값으로 출력)
	
	public boolean remove(Long bno);
	// 게시글 삭제하기 (번호가 들어가서 삭제 됐는지 T/F 값으로 출력)
	
	public List<BoardVO> getList();
	// 이 메서드가 호출되면 리스트타입으로 BoardVO객체들이 넘어온다.
	// List : 동적리스트 / <> 제네릭 : 강제로 객체 타입을 정함.
}
