package com.dkmk.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkmk.s3.board.BoardDTO;
import com.dkmk.s3.board.BoardService;
import com.dkmk.s3.util.Pager_backup;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public int setReply(QnaDTO qnaDTO)throws Exception{
		//부모글의 ref steop depth 조회
		BoardDTO boardDTO = qnaDAO.getSelect(qnaDTO);
		QnaDTO parentDto = (QnaDTO)boardDTO;
		System.out.println(parentDto.getRef());
		System.out.println(parentDto.getStep());
		System.out.println(parentDto.getDepth());
		
		qnaDTO.setRef(parentDto.getRef());
		qnaDTO.setStep(parentDto.getStep()+1);
		qnaDTO.setDepth(parentDto.getDepth()+1);
		
		int result = qnaDAO.setReplyUpdate(parentDto);
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}
	
	@Override
	public List<BoardDTO> getList(Pager_backup pager) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		int result =qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
