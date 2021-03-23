package com.dkmk.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dkmk.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest{
	@Autowired
	private MemberDAO memberDAO;
	
	@Test //쪼인, 완, •̀.̫•́✧
	public void memberJoinTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("bam");
		memberDTO.setPw("bam1");
		memberDTO.setName("bumgyu");
		memberDTO.setPhone("01011111111");
		memberDTO.setEmail("bk@naver.com");
		int result = memberDAO.memberJoin(memberDTO);
		
		assertEquals(1, result);
	}
	
	public void memberUpdateTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("bam");

		memberDTO = memberDAO.memberLogin(memberDTO);
		
		memberDTO.setId("BUMgyu");
	
		int result = memberDAO.memberUpdate(memberDTO);
		assertEquals(1, result);
	}

}
