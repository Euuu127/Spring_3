package com.dkmk.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.dkmk.s3.board.BoardDTO;
import com.dkmk.s3.util.Pager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception {
		int result = noticeService.setUpdate(boardDTO);
		
		if(result>0) {
			//성공하면 리스트로 이동
			mv.setViewName("redirect:./noticeList");
		}else {
			//실패하면 수정실패, 리스트로 이동
			mv.addObject("msg", "수정실패");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/commonResult");
		}

		return mv;
	}
	
	@GetMapping("noticeUpdate") //폼으로 이동하는 메서드
	public ModelAndView setUpdate(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		
		mv.addObject("dto", boardDTO); //dto란 이름으로 조회된 결과 넣기
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	

	@PostMapping(value = "noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		ModelAndView mv= new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		
		String message = "삭제실패";
		String path = "./noticeList";
		
		if(result > 0) { //0보다 크면 삭제 성공
			message = "삭제성공";
		}
		mv.addObject("msg",message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult"); //위치 알려줌
		return mv;
	}	
		
	@GetMapping("noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping("noticeInsert")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		return mv;
	}
	
	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public String setInsert(BoardDTO boardDTO, Model model)throws Exception{
		int result = noticeService.setInsert(boardDTO);
		
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", "./noticeList");
		
		return "common/commonResult";
	}
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		
		List<BoardDTO> ar = noticeService.getList(pager);
		
		//List<NoticeDTO> ar = noticeService.getList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		mv.addObject("board", "notice");
		mv.addObject("pager", pager);
		return mv;
	}
	

	

	
	

	
}
