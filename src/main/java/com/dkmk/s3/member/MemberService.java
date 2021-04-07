package com.dkmk.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int memberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
	
	public int memberDelete(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberDelete(memberDTO);
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
												//파일에 대한 정보 avator에 있으
							//문자				2진데이터
	public int memberJoin(MemberDTO memberDTO, MultipartFile avator)throws Exception{
		//avator.getBytes(); 여기에 2진데이터 들어있는 거임
		return 0;
		// return memberDAO.memberJoin(memberDTO); 
	}
	


}
