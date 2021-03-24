package com.dkmk.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkmk.s3.member.MemberDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	
	public int memberJoin(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberJoin(memberDTO);
	}

}
