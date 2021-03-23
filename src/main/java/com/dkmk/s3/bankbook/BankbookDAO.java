package com.dkmk.s3.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO {
	@Autowired 						// <- 그래서 하는 게 이거
	private SqlSession sqlSession; //bankbookdao는 sqlsession에 의존적

	//final = 상수란 뜻! 더이상 바뀌지 않아, 구분하기 위해 대문자로 써
	private final String NAMESPACE= "com.dkmk.s3.bankbook.BankBookDAO";

	public int setWrite(BankBookDTO bankBookDTO)throws Exception{
		//호출하고 싶은 메서드 호출하면 돼 insert, delete, select ...
		int result = sqlSession.insert(NAMESPACE+".setWrite", bankBookDTO); 
		return result;

	}


	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception{
		//long num = 1L;
		bankBookDTO = sqlSession.selectOne(NAMESPACE+".getSelect", bankBookDTO);

		return bankBookDTO;

	}	


	//getList
	//bankbook table의 모든 데이트 조회 후 리턴
	public List<BankBookDTO> getList()throws Exception{
		return sqlSession.selectList(NAMESPACE+".getList");

	}
	
	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+".setDelete", bankBookDTO);
		
	}
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.update(NAMESPACE+".setUpdate", bankBookDTO);
		
	}

}
