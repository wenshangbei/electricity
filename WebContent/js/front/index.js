$(function(){
	getCurrentUserInfo();
	 showSum();
	 getObjectList();
})


/**
 * 标的发布计算
 */
function showSum(){
	
	$("#price").keyup(function(){
		var price = $("#price").val();
		var elecQuantity = $("#elecQuantity").val();

		$("#sum").val(sum(price, elecQuantity));
	});
	
	$("#elecQuantity").keyup(function(){
		var price = $("#price").val();
		var elecQuantity = $("#elecQuantity").val();

		$("#sum").val(sum(price, elecQuantity));
	});
}

/**
 * 发布标的
 */
function publishObject() {
	var price = $("#price").val();
	var elecQuantity = $("#elecQuantity").val();
	$.ajax({
		
		url: "publishObject",
		type: "post",
		data:{
			"price": price,
			"electQuantity": elecQuantity
		
		}
			
		,
		success:function(msg){
			
			alert("发布成功");
			$.ajax({
				
				url: "getObjectList",
				async: false,
				type: "post",
				success:function(msg){
					initObjects(msg)
				}
			});
		}
	})
}

function getObjectList(){
	$.ajax({
		
		url: "getObjectList",
		async: false,
		type: "post",
		success:function(msg){
			initObjects(msg)
		}
	});
}

/**
 * 显示列表
 */
function initObjects(objectList){
	if($("#objectList").children() != null){
		$("#objectList").children().remove();
	}
	for(var i = 0;i < objectList.length; i++){
		var sum = objectList[i].electQuantity*objectList[i].price;
		$("#objectList").append(
			' <div class="col-md-3"> '+
				'<div class="subject subject-zp">'+
					'<div class="subject-header">'+
						'<span>售电：'+objectList[i].objectNum+'</span>'+
					'</div>'+
					'<div class="subject-content-1">'+
						'<span>'+objectList[i].electQuantity+'（万度）</span><br>'+
						'<span>单价： '+objectList[i].price+'元/度 </span><br>'+
						'<span>售电公司 ：'+objectList[i].user.companyName+'</span>'+
					'</div>'+
					'<div class="subject-content-2">'+
						'<span>当前总价 ： '+sum+'元</span><br>'+
						'<span>发布时间 ： '+ timeFormatter(objectList[i].createTime)+'</span> '+
					'</div>'+
					'<div class="subject-footer">'+
						'<span class="span-button" onclick="toPage('+objectList[i].id+')">购买</span>'+
						'<span class="span-button">收藏</span>'+
					'</div> '+
				'</div>'+
			' </div>');
		
	}
}



function timeFormatter(value){
	var date = new Date(value);
	return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
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

function toPage(id){
	window.location.href="buyDetail?id="+id;
}

function sum(a,b){
	return a*b;
}