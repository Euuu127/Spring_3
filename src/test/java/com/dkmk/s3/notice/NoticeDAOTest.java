package com.dkmk.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dkmk.s3.MyAbstractTest;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void getListTest()throws Exception{
		List<NoticeDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void getSelectTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(1L);
		noticeDTO =noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	@Test //지금 6으로 
	public void setInsertTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeTitle("Dunk Shot");
		noticeDTO.setNoticeWriter("admin");
		noticeDTO.setNoticeContents("주문을 외워보자 야발라바히야 야발라바히야");
		int result = noticeDAO.setInsert(noticeDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void setUpdateTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(2);
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		noticeDTO.setNoticeContents("난 앞으로 찔러 좌우 Bruce Lee");
		int result = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void setDeleteTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNoticeNum(5); //2번은 안지워지는 이유... 시퀀스라?
		int result = noticeDAO.setDelete(noticeDTO);
		
		assertEquals(1, result);
	}

}
