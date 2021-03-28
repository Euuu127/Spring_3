package com.dkmk.s3.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.dkmk.s3.notice.NoticeDAO";
	
	//글리스트
	public List<NoticeDTO> getList()throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	
	

}
