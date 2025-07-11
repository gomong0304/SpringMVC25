package org.mbc.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {
	
	@Setter(onMethod_ =@Autowired )
	private BoardService service; // 인터페이스를 필드로 선언함
	// 인터페이스에 연결된 구현 클래스가 자동으로 연동된다.
	
	@Test // 처음에 테스트진행
	public void testExist() {
		log.info("===============================");
		log.info(service); 		// 인터페이스를 호출해보자.
		assertNotNull(service); // 빈객체가 아님을 테스트한다.
		log.info("===============================");
		// org.mbc.service.BoardServiceImpl@3c78e551
		// 인터페이스를 호출했는데 구현클래스가 호출됨을 확인한다.
		// 구현클래스에 구현메서드를 실행문에 작성하면 동작하겠구나!!
	}
	
	//------------------------------------------------------------------

	@Test // 첫번째 (C)
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("서비스에서 만든 제목");
		board.setContent("서비스에서 만든 내용");
		board.setWriter("서비스님");
		
		service.register(board);
		
		log.info("===============================");
		log.info("생성된 게시물의 번호 : " + board.getBno());
		log.info("===============================");
	}
	
	//------------------------------------------------------------------
	
	@Test // 두번째 (R_전체보기)
	public void testGetList() {
		
		log.info("===============================");
		service.getList().forEach(board -> log.info(board));
		log.info("===============================");
	}
	
	//------------------------------------------------------------------

	@Test // 세번째 (R_하나보기)
	public void testGet() {
		
		log.info("===============================");
		log.info(service.get(8L));
		log.info("===============================");
	}
	
	//------------------------------------------------------------------

		@Test // 네번째 (U)
		public void testUpdate() {
			
			log.info("===============================");
			BoardVO board = service.get(1L); // 1번 게시물 가져와!
			
			if (board == null) {
				log.info("찾는 게시물이 없습니다.");
				return;
			}
			
			board.setTitle("서비스에서 수정된 제목");
			log.info("수정된 결과 출력 : " + service.modify(board));
			log.info("===============================");
		}
	
	//------------------------------------------------------------------

	@Test // 다섯번째 (D)
	public void testDelete() {
		
		log.info("===============================");
		log.info("삭제된 결과 : " + service.remove(2L));
		log.info("===============================");
	}
	
	//------------------------------------------------------------------
}
