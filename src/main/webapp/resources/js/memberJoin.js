/**
 * 
 */

let id = document.getElementById("id");
let pw = document.getElementById("pw");
let pw2 = document.getElementById("pw2");
let btn = document.getElementById("btn");
let etc = document.getElementsByClassName("etc");

let idCheckResult = false; //id 체크 결과
let pwCheckResult = false; //pw 체크 결과
let pwEqualResult = false; //pw 같은지 체크 결과
let etcResult = true; 	  //name, email, phone 체크


btn.addEventListener("click", function(){
	for(let e of etc){
		if(e.value =="") {
			etcResult = false;
			break;
		}
	}
	
	//조건이 만족하면 서버로 보내고 /url주소로파라미터보내야.. = submit이벤트 강제발생
	if(idCheckResult && pwCheckResult && pwEqualResult && etcResult) {
		let frm = document.getElementById("frm");
		frm.submit(); //강제실행
	} else {
		alert("필수항목을 입력하세요")
	}
	
});

//*************  ID 체크  ************ */
/*id.addEventListener("blur", function(){
	let dm = "6글자 미만입니다";
	let c = "r1"
	if(id.value.length>5){
		dm = "6글자 이상입니다";
		c="r2";
		idCheckResult = true;
		
	}else{id.value="";}
	let idResult = document.getElementById("idResult"); //쓰고 버릴거라 여기서 선언
	idResult.innerHTML=dm;
	idResult.setAttribute("class",c);
	
});*/

//*************  ID 중복확인  ************ */
$("#id").blur(function(){
	let id = $("#id").val();
	$.get("./memberIdCheck?id="+id, function(result){
		alert(result=='0');
	});
});

//*************  PW 체크  ************ */
pw.addEventListener("blur", function(){
	let dm = "8글자 미만입니다";
	let c = "r1"
	if(pw.value.length>7){
		dm = "8글자 이상입니다";
		c="r2";
		pwCheckResult = true;
	}
	let pwResult = document.getElementById("pwResult");
	pwResult.innerHTML=dm;
	pwResult.setAttribute("class", c);
});

//***********  PW 체인지  ********** */
pw.addEventListener("change",function(){
	alert('pw change');
	if(pw.value != pw2.value){
		pw2.value="";
		}
});

pw2.addEventListener("blur", function(){
	if(pw.value != pw2.value){
		pw2.value="";
	} else{
		pwEqualResult=true;
	}
	
});