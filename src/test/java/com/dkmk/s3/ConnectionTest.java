package com.dkmk.s3;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ConnectionTest extends MyAbstractTest {
	
	@Autowired
	private DataSource dataSource;
	@Autowired //여기서 에러뜨면 뒤에서 해봣자 소용없으
	private SqlSession sqlSession;
	
	@Test
	public void connectionTest() throws Exception {
		assertNotNull(sqlSession);
	}
	
	

}