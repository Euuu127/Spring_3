package com.dkmk.s3;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dkmk.s3.member.MemberDTO;

public class ConnectionTest extends MyAbstractTest {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private SqlSession sqlSession;
	
	
	@Test
	public void connectionTest() throws Exception {
		assertNotNull(sqlSession);
		
		
	}
	

}