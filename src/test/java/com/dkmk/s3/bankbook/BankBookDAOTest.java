package com.dkmk.s3.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dkmk.s3.MyAbstractTest;
							
public class BankBookDAOTest extends MyAbstractTest {
	
	@Autowired 
	private BankBookDAO bankbookDAO;
	
	//@Test
	public void setUpdateTest()throws Exception{
		BankBookDTO bankbookDTO = new BankBookDTO();
		bankbookDTO.setBookNumber(5);

		bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
		
		bankbookDTO.setBookName("nct");
	
		int result = bankbookDAO.setUpdate(bankbookDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void setDeleteTest() throws Exception{
		BankBookDTO bankbookDTO = new BankBookDTO();
		bankbookDTO.setBookNumber(25);
		int result = bankbookDAO.setDelete(bankbookDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void getListTest()throws Exception{
		List<BankBookDTO> ar = bankbookDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void getSelectTest()throws Exception{
		BankBookDTO bankbookDTO = bankbookDAO.getSelect(null);
		assertNotNull(bankbookDTO);
	}
	
	@Test
	public void setWriteTest() throws Exception {
		
		for(int i=0;i<200;i++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("BookName"+i);
			bankBookDTO.setBookRate(0.12);
			bankBookDTO.setBookSale("Y");
			int result = bankbookDAO.setWrite(bankBookDTO);
			if(i%10 ==0) {
				Thread.sleep(500);
			}
		}
		//assertEquals(1, result);
		System.out.println("종료");
	}
	
	
	
}
