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
	    	  field : 'check',
	          checkbox : true
	    } ,{
	    	
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
	    url:'myPublishList',
	    onCheck: function (row) {
	    	var row = $("#publishListTable").bootstrapTable('getSelections');
	    	var rows = $("#publishListTable").bootstrapTable('getAllSelections');
	    	console.log(row[0]);
	    	if("untrade"==row[0].tradingStatus)
	    		for(var i = 0; i < row.length; i++){
		    		
		    		if("traded"==row[i].tradingStatus){
		    			$("#remove").attr("disabled",true);
		    			alert("存在“已交易”的标的");
		    			return;
		    		}else{
		    			
		    			$("#remove").attr("disabled",false);
		    		}
		    		
		    	}
	    	else {
	    		alert("请选择“未交易”的");
	    		
	    	}
			
	    },
	    onCheckAll: function(row){
	    	var row = $("#publishListTable").bootstrapTable('getAllSelections');
	    	for(var i = 0; i < row.length; i++){
	    		
	    		if("traded"==row[i].tradingStatus){
	    			$("#remove").attr("disabled",true);
	    			alert("存在“已交易”的标的");
	    			return;
	    		}else{
	    			
	    			$("#remove").attr("disabled",false);
	    		}
	    		
	    	}
	    },
	    onUncheck: function(row) {
	    	var rows = $("#publishListTable").bootstrapTable('getAllSelections');
	    	if(rows.length == 0){
	    		$("#remove").attr("disabled",true);
	    	}
	    },
	    onUncheckAll: function(row) {
	    	$("#remove").attr("disabled",true);
	    }
	    
	});
	
}


/**
 * 删除未交易的Object==Publish
 */
function deletePublish() {
	var publishsTemp = new Array();
	var publishs = new Array();
	publishsTemp = $("#publishListTable").bootstrapTable('getAllSelections');
	for (var i = 0;i < publishsTemp.length; i++){
		var publish ={"id":publishsTemp[i].id};
		publishs.push(publish);
	}
	console.log(publishs);
	
	$.ajax({
		 headers: {
             'Accept': 'application/json',
             'Content-Type': 'application/json'
         },
		url: "deletePublishs",
		type: "POST",
		dataType: "json",
		data:JSON.stringify(publishs),
		success: function(msg){
			console.log(msg);
			if(msg == true){
				$('#publishListTable').bootstrapTable('refresh');
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


function initTradeList(){
	$('#tradeListTable').bootstrapTable({
	    columns: [{
	        field: 'id',
	        visible: false
	    },{
	    	
	        field: 'tradeNum',
	        title: '交易编号'
	    },{
	        field: 'object.electQuantity',
	        title: '电量(万度)'
	    }, {
	        field: 'object.price',
	        title: '单价(元/万度)',
	       
	    }, {
	        field: 'bUser.companyName',
	        title: '购电公司',
	       
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
	    url:'myTradeList'
	    
	});
	
}
function timeFormatter(value){
	var date = new Date(value);
	return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
}


