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
			<c:if test="${pager.pre}">
				<li class="page-item"><a class="page-link"
					href="./noticeList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">

				<li class="page-item"><a class="page-link"
					href="./noticeList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			</c:forEach>

			<c:if test="${pager.next}">
				<li class="page-item"><a class="page-link"
					href="./noticeList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
			</c:if>
		</ul>

		<div class="input-group mt-3 mb-3">
			<form action="./noticeList" class="form-inline">
				<div class="input-group-prepend">
					<select class="form-control" name="kind" id="sel1">
						<option>Title</option>
						<option>Contents</option>
						<option>Writer</option>
					</select>
				</div>
				<input type="text" class="form-control" name="search"
					placeholder="Username">
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">Search</button>
				</div>
			</form>
		</div>
	<a href="./noticeInsert" class="btn btn-primary" role="button">Write</a>
	</div>

</body>
</html>