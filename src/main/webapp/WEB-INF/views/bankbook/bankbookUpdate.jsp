<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Update Form</h1>
	
	<form action="./bankbookUpdate" method="post">
		<!-- Number <input type="text" readonly="readonly" name="bookNumber" value="${dto.bookNumber}"><br> -->
		<input type="hidden" name="bookNumber" value="${dto.bookNumber}"><br>
		Name <input type="text" name="bookName" value="${dto.bookName}"><br>
		Rate <input type="text" name="bookRate" value="${dto.bookRate}"><br>
		Sale <input type="text" name="bookSale" value="${dto.bookSale}"><br>
		<button>update</button>
	</form>

</body>
</html>