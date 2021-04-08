<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	.r1 {
		color: red;
	}
	.r2{
		color: blue;
	} 

</style>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container mt-2">
		<h2 class="mt-4">Member Join Page</h2>

		<form id="frm" action="./memberJoin" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="id">ID</label> <input type="text" class="form-control"
					id="id" name="id">
				<h4 id="idResult"></h4>
				<!-- id는 6글자 이상 -->
			</div>
			<div class="form-group">
				<label for="pw">Password</label> <input type="password"
					class="form-control" id="pw" name="pw1">
				<h4 id="pwResult"></h4>
				<!-- PW 8글자 이상 -->
			</div>
			<div class="form-group">
				<label for="pw">Password</label> <input type="password"
					class="form-control" id="pw2" name="pw">
				<!-- id는 중복되면 안되니까 / pw 두개는 일치-->
			</div>
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control etc" id="name" name="name">
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="text"
					class="form-control etc" id="email" name="email"> We'll never
				share your email with anyone else.
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> <input type="text"
					class="form-control etc" id="phone" name="phone">
			</div>
			<div class="form-group">
				<label for="avator">avator</label> <input type="file"
					class="form-control etc" id="avator" name="avator">
			</div>
			<input type="submit" class="btn btn-primary" id="btn" value="JOIN">
			
		</form>
			
	</div>
<!-- 	<script type="text/javascript" src="../resources/js/memberJoin.js"></script> -->
</body>
</html>