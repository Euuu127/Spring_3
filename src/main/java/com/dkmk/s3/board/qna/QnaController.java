package com.dkmk.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dkmk.s3.board.BoardDTO;
import com.dkmk.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv= new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	public ModelAndView setInset()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "qna");
		
		return mv;
	}

}
