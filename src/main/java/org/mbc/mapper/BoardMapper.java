package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	// interface는 class와 다르게 메서드가 추상화처럼 되어있다.
	// 추상메서드는 시그니처만 있으면 중괄호안에 {실행문이 없다.} 그래서 ;로 끝낸다.
	
	@Select("SELECT * FROM tbl_board WHERE bno>0") // bno > 0 pk로 선언되어있어서 인덱싱으로 빠른 추출이 가능하다.
	public List<BoardVO> getList(); // 추상메서드

	// 위에 @Select처럼 어노테이션으로 간단한 쿼리문은 가능하나 복잡한 쿼리문은 버그가 생기거나 안돌아감.
	// 그래서 xml를 이용하여 sql문 처리를 진행한다.
	// xml을 이용하려면 src/main/resources/org/mbc/mapper 폴더를 각각 생성하고
	// 인터페이스와 이름이 같은 xml 파일을 생성한다.
	// 이것이 마이바티스 사용법이다.
	public List<BoardVO> getList2();
	// xml을 이용한 쿼리 처리 메퍼용 메서드
	// getList2()가 호출이 되면 root-context의 마이바티스가 반응하고 xml을 찾아서 db를 다녀온다.
	
	
	// C : insert 데이터를 삽입하는 쿼리문
	// 1. insert 처리후에 결과 int로 받는 방법
	// 2. pk를 먼저 생성 한 후에 insert가 되는 방법
	
	public void insert(BoardVO board); // xml에서 쿼리 작성
	// C-1
	
	public void insertSelectKey(BoardVO board); // xml에서 쿼리 작성
	// C-2
	
	public BoardVO read(Long bno); // xml에서 쿼리 작성
	// 번호가 들어가면 객체로 나온다. (R)
	
	public int delete(Long bno); // xml에서 쿼리 작성
	// 번호가 들어가면 삭제후 몇개가 삭제 됐는지 리턴한다. (D)
	
	public int update(BoardVO board); // xml에서 쿼리 작성
	// 번호가 들어가면 필드 수정후 몇개가 수정됐는지 리턴한다. (U)
}
