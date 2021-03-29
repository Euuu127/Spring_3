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
					<th>Num</th>
					<th>Title</th>
					<th>Writer</th>
					<th>Hit</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.noticeNum}</td>
						<td><a href="./noticeSelect?noticeNum=${dto.noticeNum}">${dto.noticeTitle}</a></td>
						<td>${dto.noticeWriter}</td>
						<td>${dto.noticeHit}</td>
						<td>${dto.noticeDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>

<div class="container">
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
   
   <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
   
    <li class="page-item"><a class="page-link" href="./noticeList?curPage=${i}">${i}</a></li>
   </c:forEach>
   
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</div>

</body>
</html>