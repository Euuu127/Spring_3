/**
 * 
 */



function go() {
	alert("Button CLICK!");
	console.log("print log");
	//30 - 리터럴
	//변수 선언 : 데이터타입 변수명;
	var num = 30;
	console.log(num);
	//mark - 문자열, 문자 타입은 없음, 앞뒤로 '' or ""
	var name = "mark";
	console.log(name);
	
	num = name;
	
	var num=1;
	console.log(num);
	
	const n1 = 'ty'; //const는 상수! 한번 값 집어넣으면 더 넣지마
	console.log(n1);
/*	n1 = "ty track";
	console.log(n1);*/
	
	let n2 = 'ty';
	console.log(n2);
	n2 = "tytrack";
	console.log(n2);
	
}

function go2() {
	console.log("go2 start");
	var c1 = window.document.getElementById("c1");
	console.log(c1);
	window.alert(c1);
	var c2 = c1.innerHTML //객체니까 호출할 수 있어~
	console.log(c2);

	var name = window.prompt("깜쮝이 이름 입력해");
	console.log(name);
	
	
	c1.innerText = name;
	c1.innerHTML='<input type="text">';
	
	
}