/**
 * 
 */

let check = document.getElementsByClassName("check");
let all = document.getElementById("all");

all.addEventListener("click", function(){
	for(let ch of check){
		ch.checked=all.checked;
	}
});

for(let ch of check){
	ch.addEventListener("click",function(){
		
		let result = true;
		for(let c of check){
			if(!c.checked){
				result=false;
				break;
			}
		}
		all.checked=result;
		
		
	});
}


/*
function check(){
	let check = document.getElementsByClassName("check"); //변수명과 ()이름이 같을 필요 X
	alert("check");
	let result = true;
	
	for(ch of check){
		if(!ch.checked){
			result=false; //돌다가 false 넣어주기
			break;
		}
	}
	console.log(result);
	all.checked=result;
	
}
*/