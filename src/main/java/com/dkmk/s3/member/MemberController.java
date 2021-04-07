package com.dkmk.s3.member;

import java.net.Authenticator.RequestorType;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberUpdate")
	public void memberUpdate()throws Exception{
	
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(MemberDTO memberDTO, HttpSession session)throws Exception{
		int result = memberService.memberUpdate(memberDTO);
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		return "redirect:../";		
	}
	
	@RequestMapping(value = "memberDelete")
	public String memberDelete(HttpSession session)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member"); 
								//object타입으로 나오니까 dto로 형변환
		int result = memberService.memberDelete(memberDTO); 
		//db에서 삭제는 되지만 session에 남아있음
		//session에서 자동 로그아웃 시켜주자
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping("memberPage")
	public void memberPage()throws Exception{
		
	}
	
	@RequestMapping("memberLogout")
	public String memeberLogout(HttpSession session)throws Exception{
		session.invalidate(); //세션의 유지시간을 0으로 만들겠다
		return "redirect:../";
	}
	
	@RequestMapping("memberLogin")
	public void memberLogin()throws Exception{
		
	}
	
	@RequestMapping(value = "memberLogin",method = RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		memberDTO = memberService.memberLogin(memberDTO);
		System.out.println(memberDTO);
		session.setAttribute("member", memberDTO);
		return "redirect:../";
		
	}
	
	@RequestMapping("memberJoinCheck")
	public void memberJoinCheck()throws Exception{
	
	}
	
	@RequestMapping("memberJoin")
	public void memberJoin()throws Exception{}
	
	@RequestMapping(value="memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO, MultipartFile avator, Model model)throws Exception{
		int result = memberService.memberJoin(memberDTO, avator);
	
		System.out.println(avator.getName()); //파라미터명
		System.out.println(avator.getOriginalFilename()); //upload할 때 파일명
		System.out.println(avator.getSize()); //파일의 크기 (byte)
		System.out.println(avator.isEmpty()); //파일의 존재 유무 있음F 없음T
		
		String message = "회원가입 실패";
		String path = "./memberJoin";
		if(result>0) {
			message="회원가입 성공";
			path = "../";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		return "common/commonResult";
	}

}
