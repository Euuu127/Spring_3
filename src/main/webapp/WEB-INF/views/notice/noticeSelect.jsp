<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="UTF-8"><meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Select Notice</title>
</head>
<body>
	<div class="container">
		<h2>Notice Select</h2>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Title</th>
					<th>Writer</th>
					<th>Contents</th>
					<th>Hit</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td>${dto.title}</td>
						<td>${dto.writer}</td>
						<td>${dto.contents}</td>
						<td>${dto.reghit}</td>
						<td>${dto.date}</td>
					</tr>
				
			</tbody>
		</table>
	
	<c:catch>
	<c:if test="${member.id eq 'admin'}">
	<a href="./noticeUpdate?noticeTitle=${dto.title}">수정하기</a>
	<a href="./noticeDelete?noticeTitle=${dto.title}">삭제하기</a>
	</c:if>
	</c:catch>
</body>
</html>