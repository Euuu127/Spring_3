package com.dkmk.s3.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dkmk.s3.member.MemberDTO;

@Controller
@RequestMapping("/account/**")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("accountInsert")
	public String setInsert(AccountDTO accountDTO, HttpSession httpSession)throws Exception{
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		accountDTO.setId(memberDTO.getId());
		int result = accountService.setInsert(accountDTO);
		return "redirect:./accountList";
		
	}
	
	@RequestMapping("accountList")	//계좌정보라서 일정한 시간 지나거나 Web browser를 종료하면 destroy되는 세션
	public void getList(HttpSession httpSession, Model model)throws Exception{
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(memberDTO.getId());  //꺼내서집어넣는 이과정을 서비스에서 해도 돼
		List<AccountDTO> ar = accountService.getList(accountDTO);
		model.addAttribute("list", ar);
		
		
	}

}
