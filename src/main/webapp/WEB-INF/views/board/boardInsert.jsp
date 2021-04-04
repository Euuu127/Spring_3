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
<title>title</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container mt-2">
		<h2 class="mt-4">${board} Insert Page</h2>

		<form id="frm" action="./${board}Insert" method="post">
			Title <input type="text" class="form-control" id="title" name="title" value="${notice.title}"><br>
			Writer <input type="text" class="form-control" id="writer" name="writer" readonly="readonly"
				value="${member.id}"><br>
			<div class="form-group">
				<label for="contents">Contents:</label>
				<textarea class="form-control" rows="5" id="contents" name="contents"></textarea>
			</div>
			
			<input type="button" id="btn" value="WRITE" class="btn btn-primary" onclick="insertCheck()">
		</form>
	</div>
<script type="text/javascript" src="../resources/js/insertWrite.js"></script>
</body>
</html>