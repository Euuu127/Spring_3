package com.dkmk.s3.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.dkmk.s3.notice.NoticeDAO.";
	
	//글리스트
	public List<NoticeDTO> getList()throws Exception {		
		return sqlSession.selectList(NAMESPACE+"getList"); 
	}
	
	//셀렉트
	public NoticeDTO getSelect(NoticeDTO noticeDTO)throws Exception{
		noticeDTO= sqlSession.selectOne(NAMESPACE+"getSelect", noticeDTO);
		return noticeDTO;
	}
	
	//글쓰기
	public int setInsert(NoticeDTO noticeDTO)throws Exception{
		int result= sqlSession.insert(NAMESPACE+"setInsert", noticeDTO);
		return result;
	}
	
	//수정
	public int setUpdate(NoticeDTO noticeDTO)throws Exception{
		int result=sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);
		return result;
	}
	
	//삭제
	public int setDelete(NoticeDTO noticeDTO)throws Exception{
		int result=sqlSession.delete(NAMESPACE+"setDelete", noticeDTO);
		return result;
	}
	
//	//조회수
//	public int setHitUpdate(NoticeDTO noticeDTO)throws Exception{
//		int result=sqlSession.update(NAMESPACE+"setHitUpdate", noticeDTO);
//		return result;
//	}
//	
	

}
