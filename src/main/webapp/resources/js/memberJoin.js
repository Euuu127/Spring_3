/**
 * 
 */

let id = document.getElementById("id");
let pw = document.getElementById("pw");
let pw2 = document.getElementById("pw2");

id.addEventListener("blur", function(){
	let dm = "6글자 미만입니다";
	let c = "r1"
	if(id.value.length>5){
		dm = "6글자 이상입니다";
		c="r2";
	}
	let idResult = document.getElementById("idResult"); //쓰고 버릴거라 여기서 선언
	idResult.innerHTML=dm;
	idResult.setAttribute("class",c);
})



pw.addEventListener("blur", function(){
	let dm = "8글자 미만입니다";
	let c = "r1"
	if(pw.value.length>7){
		dm = "8글자 이상입니다";
		c="r2";
	}
	let pwResult = document.getElementById("pwResult");
	pwResult.innerHTML=dm;
	pwResult.setAttribute("class", c);
})

pw2.addEventListener("blur", function(){
	if(pw.value != pw2.value){
		pw2.value="";
	}
	
})