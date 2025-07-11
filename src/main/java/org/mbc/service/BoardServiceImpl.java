package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service 			// 이 클래스는 서비스 계층임을 명시한다.
@AllArgsConstructor // 생성자 자동 주입 (new BoardServiceImpl(mapper)의 생성자)
@Log4j2				// 로깅 처리용
public class BoardServiceImpl implements BoardService {
	// 조원이 실행문을 생성하는 용도로 활용 필수 : implements BoardService (구현 클래스)
	
	private BoardMapper mapper; // db 쿼리용 객체(CRUD)

	@Override // 첫번째 (C)
	public void register(BoardVO board) {
		// 객체가 넘어오면 메퍼를 이용해서 DB에 등록하겠다.
		
		log.info("BoardServiceImpl.register 메서드 실행....");
		
		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력테스트........");
		mapper.getList2();	
	}
	
	//-------------------------------------------------------------------------

	@Override // 세번째 (R_하나보기)
	public BoardVO get(Long bno) {
		// 게시물의 번호가 들어가면 메퍼의 select문이 동작해야함
		
		log.info("BoardServiceImpl.getList 메서드 실행....");
		return mapper.read(bno);
	}

	//-------------------------------------------------------------------------
	
	@Override // 네번째 (U)
	public boolean modify(BoardVO board) {
		// 프론트에서 객체가 넘어오면 매퍼를 통해서 UPDATE 쿼리가 실행된다.
		log.info("BoardServiceImpl.modify 메서드 실행....");
		return mapper.update(board) == 1;
	}

	//-------------------------------------------------------------------------
	
	@Override // 다섯번째 (D)
	public boolean remove(Long bno) {
		// 프론트에서 번호가 넘어오면 매퍼를 통해서 delete 쿼리가 실행된다.
		log.info("BoardServiceImpl.remove 메서드 실행....");
		return mapper.delete(bno) == 1;
	}

	//-------------------------------------------------------------------------
	
	@Override // 두번째 (R_전체보기)
	public List<BoardVO> getList() {
		// getList() 메서드가 호출이 되면 BoardMapper의 getList2()를 호출한다. 
		
		log.info("BoardServiceImpl.getList 메서드 실행....");
		return mapper.getList2();
	}
	
}
