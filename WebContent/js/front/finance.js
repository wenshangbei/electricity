$(function(){
	getCurrentUserInfo();	
})


function recharge(){
	var sum = $("#sum").val();
	$.ajax({
		url:'recharge',
		type:'post',
		data:{'sum': sum},
		success: function(msg){
			if("true" == msg){
				alert("充值成功")
				location.reload();
			}
		}
	});
}

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
