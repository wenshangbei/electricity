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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/front/finance.js">
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
                <li><a href="myPublish">我的发布</a></li>
                <li><a href="participant">参与标的</a></li>
                 <li  class="active"><a href="finance">财务管理</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="publish-sequence">
   
     <div class="financial-info">
        <p>可用余额：${balance }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 冻结：${frezenAssets }</p>
        <p>总金额：${balance+ frezenAssets}</p>
    </div>
		 <button  class="btn btn-danger"   data-toggle="modal" data-target="#recharge">
          <i class="glyphicon"></i> 充值
      </button>
      
      
      <div class="modal fade" id="recharge" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							快速充值，比你想的要快
						</h4>
					</div>
					<div class="modal-body">
					
						<form class="form-horizontal">
							
	           				
	           				<div class="form-group">
				                <label  class="col-sm-3 control-label">金额（元）</label>
				                <div class="col-sm-8">
				                    <input type="text" class="form-control" id="sum"  >
				                </div>
	           				</div>
	           			</form>
	           			
	           			
				                
				                
	           				
					</div>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<button  type="button" class="btn btn-primary" data-dismiss="modal" onClick="recharge()">
							充值
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
    
</div>

</body>
</html>