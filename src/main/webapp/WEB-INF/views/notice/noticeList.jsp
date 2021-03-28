<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<c:import url="../template/bootStrap.jsp"></c:import>
<title>NOTICE</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h2>Notice List</h2>
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
				<c:forEach items="${list}" var="dto">
					<tr>
						<td><a href="./noticeSelect?noticeNum=${dto.noticeNum}">${dto.noticeTitle}</a></td>
						<td>${dto.noticeWriter}</td>
						<td>${dto.noticeContents}</td>
						<td>${dto.noticeHit}</td>
						<td>${dto.noticeDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:catch>
	<c:if test="${member.id eq 'admin'}">
		<a href="./noticeInsert?noticeTitle=${dto.noticeTitle}">새글쓰기</a> <!-- con에 써둔거 -->
		
	</c:if>
	</c:catch>
	
	</div>
	
	
</body>
</html>