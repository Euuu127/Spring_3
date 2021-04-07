package com.dkmk.s3.util;

import java.io.File;

import javax.servlet.http.HttpSession;

public class FileManager {
	
	public void makePath(HttpSession session)throws Exception {

		//	1. 저장할 폴더 지정 resources/upload/member
		//	2. os에서 인식할 수 있는 실제 경로 찾기
		//	jsp : application - server : ServletContext 	
			String path = session.getServletContext().getRealPath("resources/upload/member");
			System.out.println(path);
			
		//	3. 실제 경로에 폴더가 없으면 파일 저장시 에러 발생
			File file = new File(path); //폴더의 경로를 담고 있는 객체 = file

			if(!file.exists()) {
				file.mkdirs();
			}		
		
	}

}
