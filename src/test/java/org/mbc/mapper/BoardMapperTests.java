package org.mbc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mbc.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {
	// board에서 사용하는 DB 테스트용
	
	@Setter(onMethod_ =@Autowired)
	private BoardMapper mapper; // 인터페이스로 만든 객체를 세터로 연결
	
	@Test // import org.junit.Test; 메서드 단위로 테스트 가능.
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board)); 
		// 인터페이스,메서드,for문   결과 객체
		// 						 board -> log.info(board)에서 ->는 인터페이스에서 사용하는 람다식
		// 								  log.info 콘솔에 출력(board.toString)
	}
	
	//-----------------------------------------------------------------------------------
	
	@Test // import org.junit.Test; 메서드 단위로 테스트 가능.
	public void testGetListXML() {
		
		mapper.getList2().forEach(board -> log.info(board)); 
		// 인터페이스,메서드,for문   결과 객체
		// 						 board -> log.info(board)에서 ->는 인터페이스에서 사용하는 람다식
		// 								  log.info 콘솔에 출력(board.toString)
	}

	//-----------------------------------------------------------------------------------
	
	@Test // import org.junit.Test; 메서드 단위로 테스트 가능.
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("제발 오류 없어라");
		board.setContent("이번엔 누구냐?");
		board.setWriter("콧고몽");
		
		mapper.insert(board);
		
		log.info(board);
		}

	//-----------------------------------------------------------------------------------
	
	@Test // import org.junit.Test; 메서드 단위로 테스트 가능.
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("이번엔 제발 번호 나와라!!!");
		board.setContent("내 게시물에 번호는?");
		board.setWriter("콧고몽");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
		log.info("내가 만든 게시물의 번호는 : " + board.getBno());
		}

	//-----------------------------------------------------------------------------------
	
	@Test // import org.junit.Test; 메서드 단위로 테스트 가능.
	public void testRead() {
		
		BoardVO board = mapper.read(1L); // 1번 게시물을 read 메서드로 보내고 객체로 받는다.
		
		log.info(board);
		}

	//-----------------------------------------------------------------------------------
	
	@Test // import org.junit.Test; 메서드 단위로 테스트 가능.
	public void testDelete() {
		
		int count = mapper.delete(3L); // 1번 게시물을 read 메서드로 보내고 객체로 받는다.
		
		log.info("삭제된 갯수 출력 : " + count + "건");
		}

	//-----------------------------------------------------------------------------------
	
	@Test // import org.junit.Test; 메서드 단위로 테스트 가능.
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("박희진");
		
		int count = mapper.update(board);
		log.info("수정된 갯수 : " + count + "건");
		log.info("수정된 객체 출력 :" + board);
		}
}
