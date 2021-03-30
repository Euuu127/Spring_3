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
	//	List<NoticeDTO> ar = noticeDAO.getList();
	//	assertNotEquals(0, ar.size());;
		
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
		for(int i=0;i<120;i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNoticeTitle("test Title"+i);
			noticeDTO.setNoticeWriter("test Writer"+i);
			noticeDTO.setNoticeContents("test con"+i);
			int result = noticeDAO.setInsert(noticeDTO);
			if(i%10==0) {
				Thread.sleep(500);

			}
		}
		//assertEquals(1, result);
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
