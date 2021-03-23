package com.dkmk.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dkmk.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest{
	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void memberJoinTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("hc");
		memberDTO.setPw("hc1");
		memberDTO.setName("haechan");
		memberDTO.setPhone("01011111111");
		memberDTO.setEmail("hc@naver.com");
		int result = memberDAO.memberJoin(memberDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void memberLoginTest()throws Exception{
		MemberDTO memberDTO = memberDAO.memberLogin();
		assertNotNull(memberDTO);
	}
	
	

}
