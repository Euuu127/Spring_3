<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container mt-2">
		<h2 class="mt-4">Member Join Page</h2>

		<form action="./memberJoin" method="post">
			<div class="form-group">
				<label for="id">ID</label> <input type="text" class="form-control"
					id="id" name="id">
			</div>
			<div class="form-group">
				<label for="pw">Password</label> <input type="password"
					class="form-control" id="pw" name="pw">
			</div>
			<div class="form-group">
				<label for="pw">Password</label> <input type="password"
					class="form-control" id="pw2" name="pw">
				<!-- id는 중복되면 안되니까 -->
			</div>
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name">
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="text"
					class="form-control" id="email" name="email"> We'll never
				share your email with anyone else.
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> <input type="text"
					class="form-control" id="phone" name="phone">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="button" class="btn btn-primary" value="JOIN">Submit</button>
		</form>
	</div>
</body>
</html>