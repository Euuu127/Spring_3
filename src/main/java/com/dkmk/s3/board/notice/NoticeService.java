package com.dkmk.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dkmk.s3.board.BoardDTO;
import com.dkmk.s3.board.BoardFileDTO;
import com.dkmk.s3.board.BoardService;
import com.dkmk.s3.board.qna.QnaDTO;
import com.dkmk.s3.util.FileManager;
import com.dkmk.s3.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private HttpSession session;
	
	public boolean setSummerFileDelete(String fileName)throws Exception{
		boolean result = fileManager.delete("notice", fileName, session);
		return result;
	}
	
	public String setSummerFileUpload(MultipartFile file)throws Exception{
		
		String fileName = fileManager.save("notice", file, session);
		return fileName;
	}
	
	public int setFileDelete(BoardFileDTO boardFileDTO)throws Exception{
		//fileName을 print
		//1. 조회
		boardFileDTO = noticeDAO.getFileSelect(boardFileDTO);
		//2. table 삭제
		int result = noticeDAO.setFileDelete(boardFileDTO);
		//3. HDD 삭제
		if(result > 0) {
			fileManager.delete("notice", boardFileDTO.getFileName(), session);
		}
		return result;
	}
	
	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelect(boardDTO);
	}



	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		long num =noticeDAO.getNum();
		
		boardDTO.setNum(num);
		
		int result = noticeDAO.setInsert(boardDTO);
		
		//글번호 찾기
		
		for(MultipartFile mf : files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName= fileManager.save("notice", mf, session);
			
			boardFileDTO.setNum(num);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(mf.getOriginalFilename());
			
			noticeDAO.setFileInsert(boardFileDTO);
		}
		
		return result;//noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files)throws Exception{
		for(MultipartFile multipartFile:files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			//1 File 들을 HDD에 저장
			String fileName = fileManager.save("notice", multipartFile, session);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			//2 DB에 insert
			noticeDAO.setFileInsert(boardFileDTO);
		}
		
		return noticeDAO.setUpdate(boardDTO);
	}



	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}



	public List<BoardDTO> getList(Pager pager)throws Exception{
		// ---- startRow, lastRow ----
		pager.makeRow();

		// ---- 페이징 계산 -------------
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		
		return noticeDAO.getList(pager);
	}



}
