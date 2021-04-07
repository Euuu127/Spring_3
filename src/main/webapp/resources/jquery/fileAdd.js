/**
 * 
 */

let count = 0;

$("#add").click(function(){
	if(count<5) { //5개 넘어가면 안되니까 물어보는겨
	let contents = $("#sample").html();
	$("#files").append(contents);
	count++;
	}else{
		alert("최대 5개만 가능");
	}
});