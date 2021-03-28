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

	<div class="container mt-2">
		<h2 class="mt-4">Notice Insert Page</h2>

		<form action="./noticeInsert" method="post">
		Title <input type="text" name="title"  value="${notice.noticeTitle}"><br>
		Writer <input type="text" name="writer" readonly="readonly" value="${member.id}"><br>
		Contents <input type="text" name="contents" value="${notice.noticeContents}"><br>
		<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>