package com.dkmk.s3.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Repository("/comments/**")
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;
	
	@GetMapping("commentsList")
	public void getList(CommentsDTO commentsDTO)throws Exception{
		System.out.println(commentsDTO.getNum());
		List<CommentsDTO> ar = commentsService.getList(commentsDTO);
	}
	
	

}
