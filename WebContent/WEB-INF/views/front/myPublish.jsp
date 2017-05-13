<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/front/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/front/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/front/common.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-awesome.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-table.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-change.css">	<!-- 将默认字体从宋体换成微软雅黑（个人比较喜欢微软雅黑，移动端和桌面端显示效果比较接近） -->	
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/front/myPublish.js">
</script>
</head>
<body>

<nav class="navbar navbar-default top-bar">

   <div class="top-bar-image">
        <img src="${pageContext.request.contextPath }/imgs/logo.png" class="logo" alt="">
        <div class="user-option" id="userInfo" >
            <span><a href="${pageContext.request.contextPath }/login.jsp">登陆</a></span>
            <span><a href="${pageContext.request.contextPath }/register.jsp">注册</a></span>
        </div>
    </div>

    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav " id="my-nav">
                <li ><a href="index">首页<span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="myPublish">我的发布</a></li>
                <li><a href="participant">参与标的</a></li>
                 <li><a href="finance">财务管理</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="publish-sequence">
    <h3>我发布的记录</h3>
	<div id="toolbar">
      <button id="remove" class="btn btn-danger" disabled  data-toggle="modal" data-target="#myModal">
          <i class="glyphicon glyphicon-remove"></i> 删除
      </button>
     </div>
	<table id="publishListTable"
		data-show-refresh="true"
		data-toolbar="#toolbar"
        data-search="true"
        data-show-toggle="true"
        data-show-export="true"
		data-show-pagination-switch="true"
		data-show-footer="false",
		    >
		
		
	</table>
</div>
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
						是否删除该标的？
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<button  type="button" class="btn btn-primary" data-dismiss="modal" onClick="deletePublish()">
							确定
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>

<hr>

<div class="publish-sequence">
 <h3>我发布的交易记录</h3>   
<table id="tradeListTable"
		data-show-refresh="true"
        data-search="true"
        data-show-toggle="true"
        data-show-export="true"
		data-show-pagination-switch="true"
		data-show-footer="false",
		    >
		
		
	</table>
    
</div>

</body>
</html>