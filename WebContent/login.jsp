<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
    <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/front/login.js"></script>
<title>登陆</title>
</head>
<body>
<div class="container">


    <div class="login-panel">


        <div class="logo">

            <img src="imgs/logo.png" alt="">

        </div>

        <form class="form-horizontal" action="login" method="post">
            <div class="form-group">
                <div class="col-sm-8 col-sm-offset-2">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon2"><span
                                class="glyphicon glyphicon-user"></span></span>
                        <input name="username" type="text" class="form-control" placeholder="请输入用户名" aria-describedby="sizing-addon2">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-8 col-sm-offset-2">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon2"><span
                                class="glyphicon glyphicon-lock"></span></span>
                        <input name="password" type="password" class="form-control" placeholder="请输入密码" aria-describedby="sizing-addon2">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> 记住密码
                        </label>
                        <a href="" class="pull-right" data-toggle="modal" data-target="#get-password" >忘记密码？</a>
                    </div>

                </div>


            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                	<input name="submit" type="submit" class= "form-control btn-success" style="margin-bottom: 4px" value="登录">
                    
                    <a href="register.jsp"><button type="button" class="form-control btn-success">注册</button></a>
                </div>
            </div>
        </form>


    </div>


</div>

<div class="modal fade" id="get-password">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">找回密码</h4>
            </div>

            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <div class="col-sm-8 col-sm-offset-2">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8 col-sm-offset-2">
                            <input type="password" class="form-control" id="" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8 col-sm-offset-2">
                            <input type="password" class="" id="" placeholder="验证码">
                            <img src="imgs/verifiedCode.jpg" class="pull-right" alt="" style="width: 160px;">
                        </div>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
</body>
</html>