<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var script=document.createElement("script");
var pathName = window.document.location.pathname;
var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
script.src= projectName + "/js/back/roleManager.js";
document.body.appendChild(script);
</script>
</head>
<body>
	<div class="col-md-14 right-content ">
	 <div id="toolbar">
        <button id="remove" class="btn btn-danger" disabled  data-toggle="modal" data-target="#myModal">
            <i class="glyphicon glyphicon-remove"></i> 删除
        </button>
        <button id="edit" class="btn btn-danger" disabled data-toggle="modal" data-target="#editModal">
            <i class="glyphicon glyphicon-edit"></i> 修改
        </button>
    </div>
		<table id="roleListTable"
		data-show-refresh="true"
		data-toolbar="#toolbar"
        data-search="true"
        data-show-toggle="true"
        data-show-export="true"
		data-show-pagination-switch="true"
		data-show-footer="false",
		    >
		
		
	</table>
	
			<!-- 删除模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							删除
						</h4>
					</div>
					<div class="modal-body">
						是否删除该角色？
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<button  type="button" class="btn btn-primary" data-dismiss="modal" onClick="deleteRole()">
							确定
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		
			<!-- 修改模态框（Modal） -->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							修改
						</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
	                    <div class="form-group">
	                    	<div class="row">
	                    		
	                    		<div class="col-sm-2 col-sm-offset-1 text-right">角色名：</div>
		                        <div class="col-sm-3 ">
		                        	<input type="hidden" id = "idModel"/>
		                            <input type="text" class="form-control" id="roleNameModel" placeholder="角色名">
		                        </div>
		                        
		                        
	                    	</div>
	                    	
	                    </div>
	                   
	                     <div class="form-group">
	                        <div class="row">
	                    		<div class="col-sm-2 col-sm-offset-1 text-right">权限：</div>
	                    	</div>
	                    	
	                    	 <div class="row">
	                    		<div class="col-sm-offset-2" id = "permissionsRow">
									
								</div>
	                    	</div>
	                    			
	                    
	                    </div>


                </form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<button  type="button" class="btn btn-primary" data-dismiss="modal" onClick="commitEdit()">
							确定
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
       
    </div>
</body>
</html>