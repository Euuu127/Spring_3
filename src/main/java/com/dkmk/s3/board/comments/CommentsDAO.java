package com.dkmk.s3.board.comments;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dkmk.s3.util.Pager;

@Repository
public class CommentsDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.dkmk.s3.board.comments.CommentsDAO.";
	
	public List<CommentsDTO> getList(CommentsDTO commentsDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", commentsDTO);
	}
	
	

}