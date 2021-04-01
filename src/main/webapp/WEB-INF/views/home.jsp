<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<c:import url="./template/bootStrap.jsp"></c:import>
<link rel="stylesheet" href="./resources/css/test.css">
<title>Home</title>
<!-- 스크립트 태그의 위치는 상관 X -->
</head>
<body>

	<c:import url="./template/header.jsp"></c:import>

	<button onclick="go()">BUTTON</button>
	<button id="btn">CLICK</button>
	<button id="btn2">CLICK2</button>

	<h1>v5</h1>

	<script type="text/javascript">
	let btn = document.getElementById("btn");
	let btn2 = document.getElementById("btn2");
	
	//btn2.addEventListener('click',go);
	btn2.addEventListener('click',function(){
		alert("btn2");
		go();
	});
	
	//btn.onclick=go();
	btn.onclick=function(){
		alert("익명함수");
		go();
	}
	
	function go() {
		alert("hello");
	}
		
	/* 	function go() {
			alert("hello");
			let s = sum(f1);
			alert(s);
		}

		function sum(num1, num2=1) { //누가 num2값 보내주면 그거쓰고 안오면 2쓰세요(기본값)
			return num1()+num2;
		}
		
		let f1 = function() { //호출하기 위해 let 변수에 담는거
			alert('익명함수');
			return 3;
		} */
	</script>


</body>
</html>