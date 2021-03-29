package com.dkmk.s3.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.dkmk.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//글목록
//	@RequestMapping("noticeList")
//	public void getList(Model model)throws Exception{
//		 List<NoticeDTO> ar = noticeService.getList();
//		 model.addAttribute("list", ar);
//	}
	
//	@RequestMapping("noticeList")
//	public ModelAndView getList(@RequestParam(defaultValue = "1") long curPage)throws Exception{
//		 ModelAndView mv= new ModelAndView();
//		 List<NoticeDTO> ar = noticeService.getList(curPage);
//		 mv.addObject("list", ar);
//		 mv.setViewName("notice/noticeList");
//		 return mv;
//	}
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		
		List<NoticeDTO> ar = noticeService.getList(pager);
		
		//List<NoticeDTO> ar = noticeService.getList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("notice/noticeList");
		mv.addObject("pager", pager);
		return mv;
	}
	
	
	//하나골라
	@RequestMapping("noticeSelect")
	public ModelAndView getSelect(NoticeDTO noticeDTO)throws Exception{
		ModelAndView mv= new ModelAndView();
		noticeDTO = noticeService.getSelect(noticeDTO);
		mv.addObject("dto", noticeDTO);
		mv.setViewName("notice/noticeSelect");
		return mv;
	}
	
	//글싸
	@RequestMapping("noticeInsert")
	public void setInsert()throws Exception{}
	
	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public String setInsert(NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.setInsert(noticeDTO);
		return "redirect:./noticeList";
	}
	
	//글수정
	@RequestMapping("noticeUpdate")
	public void setUpdate()throws Exception{}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:./noticeList";
	}
	
	//글삭제
	@RequestMapping(value = "noticeDelete")
	public String setDelete(NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.setDelete(noticeDTO);
		return "redirect:./noticeList";
	}	
		
	
	

	
}
