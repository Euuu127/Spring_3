package com.dkmk.s3.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BankbookDAO {

	public int setWrite(BankbookDTO bankbookDTO)throws Exception{
		//1. 로그인 정보 
		String user="mark02";
		String password="mark127";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. 클래스 로딩
		Class.forName(driver);

		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql ="insert into bankbook values(bank_seq.nextval,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankbookDTO.getBookName());
		st.setDouble(2, bankbookDTO.getBookRate());
		st.setString(3, bankbookDTO.getBookSale());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;

	}


	public BankbookDTO getSelect(BankbookDTO bankbookDTO)throws Exception{
		//1. 로그인 정보 
		String user="mark02";
		String password="mark127";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. 클래스 로딩
		Class.forName(driver);

		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);

		String sql =" select * from bankbook where booknumber = ?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setLong(1, bankbookDTO.getBookNumber());

		ResultSet rs = st.executeQuery();

		

		if(rs.next()) {
			bankbookDTO = new BankbookDTO();
			bankbookDTO.setBookNumber(rs.getLong("bookNumber"));
			bankbookDTO.setBookName(rs.getString("bookName"));
			bankbookDTO.setBookRate(rs.getDouble("bookRate"));
			bankbookDTO.setBookSale(rs.getString("bookSale"));

		} else {
			bankbookDTO=null;
		}

		rs.close();
		st.close();
		con.close();

		return bankbookDTO;

	}	


	//getList
	//bankbook table의 모든 데이트 조회 후 리턴
	public List<BankbookDTO> getList()throws Exception{
		ArrayList<BankbookDTO> ar = new ArrayList<BankbookDTO>();

		//1. 로그인 정보 
		String user="mark02";
		String password="mark127";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. 클래스 로딩
		Class.forName(driver);

		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);

		String sql ="select * from bankbook";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();
		System.out.println("executeQuery----------");
		while(rs.next()) {
			System.out.println("count");
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setBookNumber(rs.getLong("bookNumber"));
			bankbookDTO.setBookName(rs.getString("bookName"));
			bankbookDTO.setBookRate(rs.getDouble("bookRate"));
			bankbookDTO.setBookSale(rs.getString("bookSale"));
			ar.add(bankbookDTO);
		}

		rs.close();
		st.close();
		con.close();

		return ar;
	}

}
