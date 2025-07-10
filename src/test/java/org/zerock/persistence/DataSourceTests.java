package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.sample.SampleTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) // 메서드단위로 테스트용 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 테스트시 사용될 코드
@Log4j2 // Log4j가 취약해서 Log4j2로 교체함.
public class DataSourceTests {

	@Setter(onMethod_ = @Autowired) // 세터 자동생성 setDataSource(DataSource)
	private DataSource dataSource;

	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testMyBatis() {

		try (SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection(); // 마이바티스
		) {
			log.info(session);
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testConnection() {

		try (Connection con = dataSource.getConnection()) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
			// import org.junit.internal.runners.statements.Fail;
		}

	}

}
