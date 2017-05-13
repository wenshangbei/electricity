$(function(){
	initMyPublish();
	getCurrentUserInfo();initTradeList();
})


function initMyPublish(){
	$('#publishListTable').bootstrapTable({
	    columns: [{
	        field: 'id',
	        visible: false
	    },{
	    	
	        field: 'objectNum',
	        title: '发布编号'
	    },{
	        field: 'electQuantity',
	        title: '电量(万度)'
	    }, {
	        field: 'price',
	        title: '单价(元/万度)',
	       
	    }, {
	        field: 'createTime',
	        title: '发布时间',
	        formatter: function(value,row,index){
	        	return timeFormatter(value);
	        }
	    
	    }, {
	        field: 'tradingStatus',
	        title: '交易状态',
	        formatter: function(value,row,index){
	        	if("untrade"==value)
	        	return "未交易";
	        	if("traded"==value)
		        	return "已交易";
	        }
	    }],
	    url:'partiPublishList',
	   
	    
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


function initTradeList(){
	$('#tradeListTable').bootstrapTable({
	    columns: [{
	        field: 'id',
	        visible: false
	    },{
	    	  field : 'check',
	          checkbox : true
	    } ,{
	    	
	        field: 'tradeNum',
	        title: '交易编号'
	    },{
	        field: 'object.electQuantity',
	        title: '电量(万度)'
	    }, {
	        field: 'object.price',
	        title: '单价(元/万度)',
	       
	    }, {
	        field: 'aUser.companyName',
	        title: '售电电公司',
	       
	    }, {
	        field: 'createTime',
	        title: '交易时间',
	        formatter: function(value,row,index){
	        	return timeFormatter(value);
	        }
	    
	    }, {
	        field: 'tradeStatus',
	        title: '交易状态',
	        formatter: function(value,row,index){
	        	if("unEnd"==value)
	        	return "未结束";
	        	if("end"==value)
		        	return "已结束";
	        }
	    }],
	    url:'patiTradeList',
	    onCheck: function (row) {
	    	var rows = $("#tradeListTable").bootstrapTable('getAllSelections');
	    	if(rows.length == 1){
	    		$("#finish").attr("disabled",false);
	    		
	    	}else{
	    		$("#finish").attr("disabled",true);
	    	}
	       
	    },
	    onCheckAll: function(row){
	    	$("#finish").attr("disabled",true);
	    },
	    onUncheck: function(row) {
	    	var rows = $("#tradeListTable").bootstrapTable('getAllSelections');
	    	if(rows.length == 0){
	    	}
	    	if(rows.length == 1){
	    		$("#finish").attr("disabled",false);
	    		
	    	}else{
	    		$("#finish").attr("disabled",true);
	    	}
	    },
	    onUncheckAll: function(row) {
	    	$("#finish").attr("disabled",true);
	    }
	    
	});
	
}

/**
 * 完成的Object==Publish
 */
function finshTrade() {
	var rows = $("#tradeListTable").bootstrapTable('getAllSelections');
	var tradeId = rows[0].id;
	console.log(tradeId);
	$.ajax({
		url: "finishTrade",
		type: "POST",
		data:{
			"tradeId":tradeId},
		
		success: function(msg){
			if("not enough" == msg){
				
				alert("余额不足，请充值");
			}
			if(msg == 'true'){
				$('#tradeListTable').bootstrapTable('refresh');
			}
		}
	});
}
function timeFormatter(value){
	var date = new Date(value);
	return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
}


