$(function(){
	initUserList();
	editUser();
});

/**
 * 用户列表
 */
function initUserList() {
	$('#userListTable').bootstrapTable({
	    columns: [{
	        field: 'id',
	        visible: false
	    },{
	    	  field : 'check',
	          checkbox : true
	    } ,{
	    	
	        field: 'username',
	        title: '用户名'
	    },{
	        field: 'realName',
	        title: '姓名'
	    }, {
	        field: 'gender',
	        title: '性别',
	        formatter: function(value,row,index){
	        	if(value == "male")
	        		return "男";
	        	else
	        		return "女";
	        }
	    }, {
	        field: 'phoneNum',
	        title: '手机号码'
	    
	    }, {
	        field: 'email',
	        title: '邮箱'
	    }, {
	        field: 'roles',
	        formatter: function(value,row,index){
	        	if(row.roles != null && row.roles.length > 0){
	        		var name = "";
	        		for(var i = 0; i <row.roles.length; i ++ )
	        		{
	        			if(i == 0){
	        				name = row.roles[i].roleName;
	        			}else{
	        				
	        				name = name +","+row.roles[i].roleName;
	        			}
	        		}
	        		return name;
	        	}else {
	        		return "";
	        	}
	        },
	        title: '角色'
	    }],
	    url : "userList",
	    onCheck: function (row) {
	    	$("#remove").attr("disabled",false);
	    	var rows = $("#userListTable").bootstrapTable('getAllSelections');
	    	if(rows.length == 1){
	    		$("#edit").attr("disabled",false);
	    		
	    	}else{
	    		$("#edit").attr("disabled",true);
	    	}
	       
	    },
	    onCheckAll: function(row){
	    	$("#remove").attr("disabled",false);
	    	$("#edit").attr("disabled",true);
	    },
	    onUncheck: function(row) {
	    	var rows = $("#userListTable").bootstrapTable('getAllSelections');
	    	if(rows.length == 0){
	    		$("#remove").attr("disabled",true);
	    	}
	    	if(rows.length == 1){
	    		$("#edit").attr("disabled",false);
	    		
	    	}else{
	    		$("#edit").attr("disabled",true);
	    	}
	    },
	    onUncheckAll: function(row) {
	    	$("#remove").attr("disabled",true);
	    	$("#edit").attr("disabled",true);
	    }
	    ,
	    
	    pagination: true
	   
	    
	});
	
	
}

/**
 * 删除用户
 */
function deleteUser() {
	var usersTemp = new Array();
	var users = new Array();
	usersTemp = $("#userListTable").bootstrapTable('getAllSelections');
	for (var i = 0;i < usersTemp.length; i++){
		var user ={"id":usersTemp[i].id};
		users.push(user);
	}
	console.log(users);
	
	$.ajax({
		 headers: {
             'Accept': 'application/json',
             'Content-Type': 'application/json'
         },
		url: "deleteUsers",
		type: "POST",
		dataType: "json",
		data:JSON.stringify(users),
		success: function(msg){
			console.log(msg);
			if(msg == true){
				$('#userListTable').bootstrapTable('refresh');
			}
		}
	});
}

/**
 * 修改用户信息界面信息
 */
function editUser(){
	$('#editModal').on('show.bs.modal', function (e) {
		var tempRoles = new Array();
		$.ajax({
			
			url: "getRoles",
			async: false,
			type: "post",
			success:function(msg){
				tempRoles = msg;
			}
		});
		var input = $("#rolesRow").children();
		if(input.length != tempRoles.length){
			$("#rolesRow").children().remove();	
			console.log(input);
			for(var i = 0; i < tempRoles.length; i++){
				
				$("#rolesRow").append('<label class="checkbox-inline"><input type="checkbox" name="roles" id='+tempRoles[i].roleName+'Check value='+tempRoles[i].roleName+' > '+tempRoles[i].roleName+'</label> ');
			}
		}
		
		var usersTemp = $("#userListTable").bootstrapTable('getAllSelections');
		var realName = usersTemp[0].realName;
		var gender = usersTemp[0].gender;
		var email = usersTemp[0].email;
		var phoneNum = usersTemp[0].phoneNum;
		var roles = usersTemp[0].roles;
		var id = usersTemp[0].id;
		
		
		
		for(var i = 0; i < roles.length; i++){
			for(var j = 0; j < tempRoles.length; j++){
				
				if(tempRoles[j].roleName == roles[i].roleName){
					$("#"+tempRoles[j].roleName+"Check").attr("checked",true);
				}
			}
			
		}
		
	
		if("female" == gender) {
			
			$("#femaleRadio").attr("checked",true);
		}
		//var abc =$('input:radio[name="sex"]:checked').val();
		//console.log(abc);
		
		$("#idModel").val(id);
		$("#realNameModel").val(realName);
		$("#emailModel").val(email);
		$("#phoneNumModel").val(phoneNum);
	});
	
	$('#editModal').on('hidden.bs.modal', function (e) {
		
		$("#rolesRow").children().remove();	
	});
	
}

/**
 * 提交修改后的信息
 */
function commitEdit(){
	var id = $("#idModel").val();
	var realName = $("#realNameModel").val();
	var email = $("#emailModel").val();
	var phoneNum = $("#phoneNumModel").val();
	var gender = $('input:radio[name="sex"]:checked').val();
	var roles = new Array();
	var tempRoles = new Array();
	$.ajax({
		
		url: "getRoles",
		async: false,
		type: "post",
		success:function(msg){
			tempRoles = msg;
		}
	});
	var rolesInpput = $('input[name="roles"]:checked').each(function(){
		
		console.log("roles"+roles);
		for(var i = 0; i < tempRoles.length; i++){
			console.log(tempRoles[i].roleName+" "+$(this).val());
			if(tempRoles[i].roleName == $(this).val()){
				console.log(roles.length);
				roles.push(tempRoles[i])
			}
		}
		
	});
	
	console.log(roles);
	
	$.ajax({
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		url: "updateUser",
		dataType:"json",
		type: "post",
		data:
			JSON.stringify(
			{"id": id,
			"realName": realName,
			"email": email,
			"phoneNum":phoneNum,
			"gender": gender,
			"roles": roles
		})
		,
		success:function(msg){
			
			alert("已经修改");
			$('#userListTable').bootstrapTable('refresh');
		}
	});
}


