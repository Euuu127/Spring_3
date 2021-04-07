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


$("#del").click(function(){
	$("#files").empty();
});

//$("#inputGroupFileAddon04").click(function(){ 얘가 아니라 부모한테 거는거야! 부모->자식 이벤트 보내주려고(위임)
//이벤트 전달(위임)
$("#files").on("click",".delete",function(){
	//클릭당한자기자식  선택한부모의부모
	$(this).parent().remove();
	count--;
});