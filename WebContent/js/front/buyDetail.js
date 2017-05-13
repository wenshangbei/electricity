$(function(){
	getCurrentUserInfo();
})
function getCurrentUserInfo(){
	$.ajax({
		url: "getCurrentUserInfo",
		type:"post",
		success:function(msg){
			$("#userInfo").children().remove();
			$("#userInfo").append(
					'<span>'+
					'您好，<a href="#">'+msg.username+'</a>'+
					'</span>');
		}
	});
}
function check(checkbox){
	if(checkbox.checked == true){
		$("#commit").attr("disabled",false);
	}else{
		$("#commit").attr("disabled",true);
	}
}

function createTrade(id){
	$.ajax({
			
			url: "createTrade",
			type: "post",
			data:{
				"objectId": id,
			
			}
				
			,
			success:function(msg){
				if('true' == msg){
					alert("成功");
					window.location.href="index";
				}else{
					if('false' != msg){
						alert("不能购买自己发布的标的！！！");
					}else{
						
						alert("失败");
					}
				}
			}
		})
	}
