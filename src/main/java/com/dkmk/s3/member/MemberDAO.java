package com.dkmk.s3.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.jdbc.driver.DBConversion;

@Repository 
public class MemberDAO {
	@Autowired 						
	private SqlSession sqlSession;
	
	private final String NAMESPACE= "com.dkmk.s3.member.MemberDAO";
	
	public int setFileInsert(MemberFileDTO memberFileDTO)throws Exception{
		int result = sqlSession.insert(NAMESPACE+".setFileInsert", memberFileDTO);
		return result;
	}
			
	public int memberUpdate(MemberDTO memberDTO)throws Exception{
		//id를 제외하고 나머지 수정
		return sqlSession.update(NAMESPACE+".memberUpdate", memberDTO);
	}
	
	public int memberDelete(MemberDTO memberDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+".memberDelete", memberDTO);
	}
	
	//memberJoin 데이터를 받아서 DB에 insert 하는 메서드
	public int memberJoin(MemberDTO memberDTO)throws Exception{

		int result = sqlSession.insert(NAMESPACE+".memberJoin", memberDTO); 
		return result;
		
	}
	
	
	//login - id pw를 받아서 조회
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
	
		
		memberDTO = sqlSession.selectOne(NAMESPACE+".memberLogin", memberDTO);

		return memberDTO;

	}

}