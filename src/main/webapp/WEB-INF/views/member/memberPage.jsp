<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member MyPage</h1>
	<h3> ID : ${member.id} 님</h3>
	<h3> NAME : ${member.name}</h3>
	<h3> PHONE : ${member.phone}</h3>
	<h3> EMAIL : ${member.email}</h3>
	
	<a href="./memberUpdate">회원정보수정</a>
	<a href="./memberDelete">탈퇴</a>
	<a href="">계좌관리</a>

</body>
</html>