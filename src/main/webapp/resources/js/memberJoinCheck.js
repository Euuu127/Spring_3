/**
 * 
 */

function check(){
	alert("check");
	document.getElementsByClassName("check"); //변수명과 ()이름이 같을 필요 없으
	const all = document.getElementById("all");
	
	let result = true;
	
	for(ch of check){
		if(!ch.checked){
			result = false; //돌다가 false 넣어주기 ~
			break;
		}
	}
	
	all.checked=result;
	
}