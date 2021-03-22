package com.dkmk.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public BankBookService() {
		//결합도가 높다, 강하다
		bankBookDAO = new BankBookDAO();
	}
	
	
	
	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		//결합도가 낮다, 느슨한다..
		this.bankBookDAO = bankBookDAO;
	}



	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.getSelect(bankBookDTO);
	}
	
	public List<BankBookDTO> getList()throws Exception{
		return bankBookDAO.getList();
	}

}