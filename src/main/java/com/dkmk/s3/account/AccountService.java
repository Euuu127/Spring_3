package com.dkmk.s3.account;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	public int setInsert(AccountDTO accountDTO)throws Exception{
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		System.out.println(time);
		//return accountDAO.setInsert(accountDTO);
		
		String t = time+"";
		t = String.valueOf(time);
		
		String result = t.substring(0, 4)+"-";
		result = result + t.substring(4, 8)+"-";
		result = result + t.substring(8);
		System.out.println(result);
		
		//SimpleDateFormat
		SimpleDateFormat sd = new SimpleDateFormat("ddyyyyMM-HHmmss-S");
		String r = sd.format(ca.getTime());
		System.out.println(r);
		
		String name = UUID.randomUUID().toString();
		System.out.println(name);
		
		accountDTO.setAccountNumber(r);
		return accountDAO.setInsert(accountDTO);
	}
	
	public List<AccountDTO> getList(AccountDTO accountDTO)throws Exception{
		return accountDAO.getList(accountDTO);
	}
	
}
