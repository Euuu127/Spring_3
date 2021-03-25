<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Account List Page</h1>
	
	<table>
		<thead>
			<tr>
				<td>Account Number</td>
				<td>Account Balance</td>
				<td>Account Date</td>
				<td>ID</td>
				<td>BookNumber</td>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.accountNumber}</td>		
				<td>${dto.accountBalance}</td>	
				<td>${dto.accountDate}</td>	
				<td>${dto.bookNumber}</td>		
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>