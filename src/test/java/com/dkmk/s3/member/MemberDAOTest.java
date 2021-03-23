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
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("mark");
		memberDTO.setPw("pw1");
		memberDTO = memberDAO.memberLogin(memberDTO);
		assertNotNull(memberDTO);
	}
	//@Test
	public void memberUpdateTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("bam");

		memberDTO = memberDAO.memberLogin(memberDTO);
		
		memberDTO.setPw("pw");
		memberDTO.setName("ggyu");
		memberDTO.setPhone("01011112222");
		memberDTO.setEmail("gg@naver.com");

		int result = memberDAO.memberUpdate(memberDTO);
		assertEquals(1, result);
		
	}
	@Test
	public void memberDeleteTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("bam");
		int result = memberDAO.memberDelete(memberDTO);
		
		assertEquals(1, result);
	}
	
	

}
