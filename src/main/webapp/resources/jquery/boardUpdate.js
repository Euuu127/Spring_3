/**
 * 
 */

$(".fileDelete").click(function(){
	let check=confirm();
	
	if(check){
			let fileNum = $(this).attr("title");
			let obj = $(this);
			$.ajax({
				url:"./fileDelete",
				type: "GET",
				data: {fileNum:fileNum},
				success:function(result){
					if(result>0){
						alert("삭제 성공");
						$(obj).parent().remove();
					}else{
						alert("삭제 실패");
					}
				}
			});
	}
});
