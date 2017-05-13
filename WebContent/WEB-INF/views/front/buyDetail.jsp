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
     <script src="${pageContext.request.contextPath }/js/front/buyDetail.js"></script>
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


<div class="transaction-desc">
    <h3>购电说明</h3>
    够买需要先提交保证金，交易结束后将退回。
</div>

<div class="transaction-detail">
    <div class="panel panel-default">
        <div class="panel-heading">购买详情</div>

        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>当前价格</th>
                    <th>电量</th>
                    <th>单价</th>
                    <th>保证金额度</th>
                    <th>售电单位</th>
                    <th>发布时间</th>
                    <th>发布编号</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${object.electQuantity*object.price}</td>
                    <td>${object.electQuantity}</td>
                    <td>${object.price}</td>
                    <td>2000</td>
                    <td>${object.user.companyName}</td>
                    <td>${object.createTime}</td>
                    <td>${object.objectNum }</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <input id="check" type="checkbox" aria-label="..." onclick="check(this)"> 我已阅读并同意《XXX》
    <button id="commit" class="btn btn-danger pull-right" disabled="disabled" onclick="createTrade(${object.id})">提交保证金</button>

    <div class="clearfix" style="margin-bottom: 24px;"></div>

    <hr>

   






</body>
</html>