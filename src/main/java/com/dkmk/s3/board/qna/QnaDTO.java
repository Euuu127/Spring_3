package com.dkmk.s3.board.qna;

import java.sql.Date;

import com.dkmk.s3.board.BoardDTO;

public class QnaDTO extends BoardDTO{ //상속!
	
	private long ref;
	private long step;
	private long depth;
	
	public long getRef() {
		return ref;
	}
	public void setRef(long ref) {
		this.ref = ref;
	}
	public long getStep() {
		return step;
	}
	public void setStep(long step) {
		this.step = step;
	}
	public long getDepth() {
		return depth;
	}
	public void setDepth(long depth) {
		this.depth = depth;
	}
	
	

}
