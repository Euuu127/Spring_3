<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>

</head>
<body>
	<h1>BankBook Select</h1>

	<h3>Name : ${dto.bookName}</h3>
	<h3>Number : ${dto.bookNumber}</h3>
									<!-- ?뒤에 있는 걸 가져가세요 -->
	<a href="../account/accountInsert?bookNumber=${dto.bookNumber}">계좌개설</a> 
	
	<c:catch>
	<c:if test="${member.id eq 'admin'}">
		<a href="./bankbookDelete?bookNumber=${dto.bookNumber}">DELETE</a>
		<a href="./bankbookUpdate?bookNumber=${dto.bookNumber}">UPDATE</a>
	</c:if>
	</c:catch>
	
	
	<%-- 	<c:if test="${not empty member and member.id eq 'admin'}">
		<a href="./bankbookDelete?bookNumber=${dto.bookNumber}">DELETE</a>
		<a href="./bankbookUpdate?bookNumber=${dto.bookNumber}">UPDATE</a>
	</c:if> --%>
</body>
</html>