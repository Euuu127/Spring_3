package com.dkmk.s3.bankbook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dkmk.s3.MyAbstractTest;
							//테스트가 돌아가게 하기 위해 만들어둔 클래스 상속(?
public class BankBookDAOTest extends MyAbstractTest {
	
	@Autowired //주입시켜주쉐이~
	private BankBookDAO bankBookDAO;
	@Test
	public void setWriteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("Test");
		bankBookDTO.setBookRate(0.12);
		bankBookDTO.setBookSale("Y");
		int result = bankBookDAO.setWrite(bankBookDTO);
		
	
		assertEquals(1, result);
		
		
	}
	
	
}
