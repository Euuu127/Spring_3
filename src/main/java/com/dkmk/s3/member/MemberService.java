package com.dkmk.s3.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dkmk.s3.util.FileManager;



@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired //주입~
	private FileManager fileManager;
	
	public int memberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
	
	public int memberDelete(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberDelete(memberDTO);
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
		memberDTO = memberDAO.memberLogin(memberDTO);
//		MemberFileDTO memberFileDTO = memberDAO.memberLoginFile(memberDTO);
//		memberDTO.setMemberFileDTO(memberFileDTO);
		return memberDTO;
	}
												//파일에 대한 정보 avator에 있으
							//문자				2진데이터
	public int memberJoin(MemberDTO memberDTO, MultipartFile avator, HttpSession session)throws Exception{
		String fileName=fileManager.save("member", avator, session);
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setOriginName(avator.getOriginalFilename());
		memberFileDTO.setFileName(fileName);
		
		int result = memberDAO.memberJoin(memberDTO);
		result=memberDAO.setFileInsert(memberFileDTO);

		return result;
		// return memberDAO.memberJoin(memberDTO); 
	}
	


}
