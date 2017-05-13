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
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/register.js"></script>
    <title>注册</title>


</head>
<body>


    <div class="container">


        <div class="login-panel">
            
            
            <div class="logo">

                <img src="imgs/logo.png"  alt="">
                
            </div>

            <form class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2" >
                        <input type="text" class="form-control" id="username" placeholder="用户名">
                    </div>
                    <div style="padding-top: 5px">
	                    <span id="spanUsername" style="marginleft:3px;color: red; " ></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2" >
                        <input type="text" class="form-control" id="companyName" placeholder="公司名称">
                    </div>
                    <div style="padding-top: 5px">
	                    <span id="spanCompanyName" style="marginleft:3px;color: red; " ></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2">
                        <input type="password" class="form-control" id="password" placeholder="密码">
                    </div>
                    <div style="padding-top: 5px">
	                    <span id="spanPassword" style="marginleft:3px;color: red; " ></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2">
                        <input type="password" class="form-control" id="repassword" placeholder="确认密码">
                    </div>
                    <div style="padding-top: 5px">
	                    <span id="spanRepassword" style="marginleft:3px;color: red; " ></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2">
                        <input type="text" class="form-control" id="email" placeholder="邮箱">
                    </div>
                     <div style="padding-top: 5px">
	                    <span id="spanEmail" style="marginleft:3px;color: red; " ></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2">
                        <input type="text" class="form-control" id="phoneNum" placeholder="手机">
                    </div>
                     <div style="padding-top: 5px">
	                    <span id="spanPhoneNum" style="marginleft:3px;color: red; " ></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2">
                        <input type="text" class="" id="verifiedCode" placeholder="验证码">
                        <img src="imgs/verifiedCode.jpg" class="pull-right" alt="" style="width: 120px;">
                    </div>
                    <div style="padding-top: 5px">
	                    <span id="spanVerifiedCode" style="marginleft:3px;color: red; " ></span>
                    </div>
                </div>



                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-8">
                        <button  id="regist" type="button" class="form-control btn-success" style="margin-bottom: 4px">确认注册</button>
                    </div>
                </div>
            </form>



        </div>


    </div>

</body>

</body>
</html>