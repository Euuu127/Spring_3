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
	public List<NoticeDTO> getList()throws Exception {		//여기 ()안에 noticedto 받아와야되나?
		return sqlSession.selectList(NAMESPACE+"getList"); //, noticedto 해야되나 ... 일단 없이 ㄱ
	}
	
	
	

}
