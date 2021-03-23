package com.dkmk.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dkmk.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest{
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void setWriteTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("bam");
		memberDTO.setPw("bam1");
		memberDTO.setName("bumgyu");
		memberDTO.setPhone("01011111111");
		memberDTO.setEmail("bk@naver.com");
		int result = memberDAO.memberJoin(memberDTO);
		
		assertEquals(1, result);
	}

}
