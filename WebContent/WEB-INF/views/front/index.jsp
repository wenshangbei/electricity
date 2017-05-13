<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
     <link rel="stylesheet" href="${pageContext.request.contextPath }/css/front/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/front/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/front/common.css">
    <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/front/index.js"></script>
    <title>首页</title>

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
                <li class="active"><a href="index">首页<span class="sr-only">(current)</span></a></li>
                <li><a href="myPublish">我的发布</a></li>
                <li><a href="participant">参与标的</a></li>
                 <li><a href="finance">财务管理</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="row">

    <div class="col-md-9" style="margin-left: 24px;">
        <div id="carousel-example-generic" class="carousel slide my-carousel" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="${pageContext.request.contextPath }/imgs/banner1.jpg" alt="...">
                    <div class="carousel-caption">
                    </div>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath }/imgs/banner2.jpg" alt="..." style="width: 100%">
                    <div class="carousel-caption">
                    </div>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath }/imgs/banner3.jpg" alt="..." style="width: 100%">
                    <div class="carousel-caption">
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

    </div>


    <div class="col-md-2">

        <span class="add-subject" data-toggle="modal" data-target="#addModal">标的发布
            <span class="glyphicon glyphicon-plus"></span>
        </span>
        
        

        <div class="list-group">
            <a href="" type="button" class="list-group-item">平台使用说明</a>
            <a href="" type="button" class="list-group-item">竞拍交易规则</a>
            <a href="" type="button" class="list-group-item">挂牌交易规则</a>
            <a href="" type="button" class="list-group-item">招标交易规则</a>
        </div>
    </div>

</div>

<div class="search-form">


    <div class="subject-category pull-left">

        <span>进行中</span>

    </div>

    <form class="form-inline pull-right">
        <div class="form-group">
            <input type="text" class="form-control" id="" placeholder="请输入发布编号">
        </div>

        <div class="form-group">
            <input type="checkbox" aria-label="...">已收藏
            <input type="checkbox" aria-label="...">未收藏
        </div>
       
       
        <button type="submit" class="btn btn-success">查询</button>
        <div class="from-group" style="display: inline-block">
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="true">
                    排序
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">升序</a></li>
                    <li><a href="#">降序</a></li>
                </ul>
            </div>
        </div>

    </form>
    

    <div class="clearfix"></div>

</div>
    <div class="row subjects" id="objectList">
    </div>




		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							发布标的
						</h4>
					</div>
					<div class="modal-body">
					
						<form class="form-horizontal">
							<div class="form-group">
		           				<label  class="col-sm-offset-1	 control-label">发布后将冻结2000元作为保证金，交易结束将退回。</label>
		           			</div>
							<div class="form-group">
				                <label  class="col-sm-3 control-label">电量（万度）</label>
				                <div class="col-sm-8">
				                    <input type="text" class="form-control" id="elecQuantity" placeholder="请输入电量">
				                </div>
	           				</div>
	           				
	           				<div class="form-group">
				                <label  class="col-sm-3 control-label">单价（元/万度）</label>
				                <div class="col-sm-8">
				                    <input type="text" class="form-control" id="price" placeholder="请输入单价">
				                </div>
	           				</div>
	           				
	           				<div class="form-group">
				                <label  class="col-sm-3 control-label">总价（元）</label>
				                <div class="col-sm-8">
				                    <input type="text" class="form-control" id="sum" disabled >
				                </div>
	           				</div>
	           			</form>
	           			
	           			
				                
				                
	           				
					</div>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<button  type="button" class="btn btn-primary" data-dismiss="modal" onClick="publishObject()">
							发布
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
			
			
			<!-- 购买模态框（Modal） -->
		<div class="modal fade" id="buyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							购买
						</h4>
					</div>
					<div class="modal-body">
						确定后将冻结2000元作为保证金，交易结束将退回。
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
		</div>
</div>



</body>
</html>