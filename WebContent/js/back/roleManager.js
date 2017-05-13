$(function(){
	initRoleList();
	editUser();
})

/**
 * 角色列表
 */
function initRoleList() {
	$('#roleListTable').bootstrapTable({
	    columns: [{
	        field: 'id',
	        visible: false
	    },{
	    	  field : 'check',
	          checkbox : true
	    } ,{
	    	
	        field: 'roleName',
	        title: '角色名'
	    }, {
	        field: 'permissions',
	        formatter: function(value,row,index){
	        	if(row.permissions != null && row.permissions.length > 0){
	        		var name = "";
	        		for(var i = 0; i <row.permissions.length; i ++ )
	        		{
	        			if(i == 0){
	        				name = row.permissions[i].name;
	        			}else{
	        				
	        				name = name +","+row.permissions[i].name;
	        			}
	        		}
	        		return name;
	        	}else {
	        		return "";
	        	}
	        },
	        title: '权限'
	    }],
	    url : "roleList",
	    onCheck: function (row) {
	    	$("#remove").attr("disabled",false);
	    	var rows = $("#roleListTable").bootstrapTable('getAllSelections');
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
	    	var rows = $("#roleListTable").bootstrapTable('getAllSelections');
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
 * 删除角色
 */
function deleteRole() {
	var rolesTemp = new Array();
	var roles = new Array();
	rolesTemp = $("#roleListTable").bootstrapTable('getAllSelections');
	for (var i = 0;i < rolesTemp.length; i++){
		var role ={"id":rolesTemp[i].id};
		roles.push(role);
	}
	console.log(roles);
	
	$.ajax({
		 headers: {
             'Accept': 'application/json',
             'Content-Type': 'application/json'
         },
		url: "deleteRoles",
		type: "POST",
		dataType: "json",
		data:JSON.stringify(roles),
		success: function(msg){
			console.log(msg);
			if(msg == true){
				$('#roleListTable').bootstrapTable('refresh');
			}
		}
	});
	
	
	
}


/**
 * 修改用户信息界面信息
 */
function editUser(){
	$('#editModal').on('show.bs.modal', function (e) {
		var tempPermissions = new Array();
		$.ajax({
			
			url: "getPermissions",
			async: false,
			type: "post",
			success:function(msg){
				tempPermissions = msg;
			}
		});
		
		var input = $("#permissionsRow").children();
		if(input.length != tempPermissions.length){
			$("#permissionsRow").children().remove();
			for(var i = 0; i < tempPermissions.length; i++){
				
				$("#permissionsRow").append('<label class="checkbox-inline"><input type="checkbox" name="permissions" id='+tempPermissions[i].name+'Check value='+tempPermissions[i].name+' > '+tempPermissions[i].name+'</label> ');
			}
		}
		var rolesTemp = $("#roleListTable").bootstrapTable('getAllSelections');
		var roleName = rolesTemp[0].roleName;
		var id = rolesTemp[0].id;
		var permissions = rolesTemp[0].permissions;
		
		for(var i = 0; i < permissions.length; i++){
			for(var j = 0; j < tempPermissions.length; j++){
				
				if(tempPermissions[j].name == permissions[i].name){
					$("#"+tempPermissions[j].name+"Check").attr("checked",true);
				}
			}
			
		}
		
		$("#idModel").val(id);
		$("#roleNameModel").val(roleName);
	
		});
	
		$('#editModal').on('hidden.bs.modal', function (e) {
				
				$("#permissionsRow").children().remove();	
			});
	
}

/**
 * 提交修改后的信息
 */
function commitEdit(){
	var id = $("#idModel").val();
	var roleName = $("#roleNameModel").val();

	var permissions = new Array();
	var tempPermissions = new Array();
	$.ajax({
		
		url: "getPermissions",
		async: false,
		type: "post",
		success:function(msg){
			tempPermissions = msg;
		}
	});
	var permissionsInpput = $('input[name="permissions"]:checked').each(function(){
		
		for(var i = 0; i < tempPermissions.length; i++){
			if(tempPermissions[i].name == $(this).val()){
				permissions.push(tempPermissions[i])
			}
		}
		
	});
	
	
	$.ajax({
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		url: "updateRole",
		dataType:"json",
		type: "post",
		data:
			JSON.stringify(
			{"id": id,
			"roleName": roleName,
			"permissions": permissions
		})
		,
		success:function(msg){
			
			alert("已经修改");
			$('#roleListTable').bootstrapTable('refresh');
		}
	});
}
