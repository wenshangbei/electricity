$(function(){
	
	 checkUsername();
	 checkCompanyName();
	 checkPassword();
	 checkRepassword();
	 checkEmail();
	 checkPhoneNum();
	 regist();
});


/*
 * 检验用户名
 */
function checkUsername() {
	$("#username").blur(function(){
		var username = $("#username").val();
		if(username.length == 0){
			$("#spanUsername").text("不能为空");
		}else{
			
			$.ajax({
				url:"register/existUsername",
				data:{"username":username},
				success:function(msg){
					if("true" == msg){
						$("#spanUsername").text("用户已存在");
					}else {
						$("#spanUsername").text("");
					}
				}
			});
		}
	});
}

/*
 * 检验公司
 */
function checkCompanyName() {
	$("#companyName").blur(function(){
		var companyName = $("#companyName").val();
		if(companyName.length == 0)
			$("#spanCompanyName").text("不能为空");
		else
			$("#spanCompanyName").text("");
		
	});
}
/**
 * 校验密码
 */
function checkPassword() {
	$("#password").blur(function(){
		var password = $("#password").val();
		if(password.length == 0) {
			$("#spanPassword").text("不能为空");
		}else {
			$("#spanPassword").text("");
		}
	})
}

/**
 * 校验确认密码
 */
function checkRepassword() {
	$("#repassword").blur(function(){
		var repassword = $("#repassword").val();
		var password = $("#password").val();
		if(repassword.length == 0) {
			$("#spanRepassword").text("不能为空");
		}else if(password != repassword){
			$("#spanRepassword").text("密码不一致");
		}else {
			$("#spanRepassword").text("");
		}
	})
}

/**
 * 检验邮箱
 */
function checkEmail() {
	$("#email").blur(function(){
		var email = $("#email").val();
		if(email.length == 0) {
			$("#spanEmail").text("不能为空");
		}else if(!isEmail(email)){
			$("#spanEmail").text("格式不正确");
		}else {
			$("#spanEmail").text("");
		}
	})
}

/**
 * 检验手机号码
 */
function checkPhoneNum() {
	$("#phoneNum").blur(function(){
		var phoneNum = $("#phoneNum").val();
		if(phoneNum.length == 0) {
			$("#spanPhoneNum").text("不能为空");
		}else if(!isPhoneNum(phoneNum)){
			$("#spanPhoneNum").text("格式不正确");
		}else {
			$("#spanPhoneNum").text("");
		}
	})
	
	
}

/**
 * 确认注册
 */
function regist() {
	$("#regist").click(function(){
		console.log("点击注册按钮");
		var username = $("#username").val();
		var password = $("#password").val();
		var repassword = $("#repassword").val();
		var email = $("#email").val();
		var phoneNum = $("#phoneNum").val();
		var companyName = $("#companyName").val();
		
		
		if(username.length == 0){
			$("#spanUsername").text("不能为空");
		}else{
			
			$.ajax({
				url:"register/existUsername",
				data:{"username":username},
				success:function(msg){
					if("true" == msg){
						$("#spanUsername").text("用户已存在");
					}else {
						$("#spanUsername").text("");
					}
				}
			});
		}
		if(companyName.length == 0)
			$("#spanCompanyName").text("不能为空");
		else{
			$("#spanCompanyName").text("");
		}
		
		if(password.length == 0)
			$("#spanPassword").text("不能为空");
		else{
			$("#spanPassword").text("");
		}
		
		if(email.length == 0) {
			$("#spanEmail").text("不能为空");
		}else if(!isEmail(email)){
			$("#spanEmail").text("格式不正确");
		}else {
			$("#spanEmail").text("");
		}
		
		if(phoneNum.length == 0) {
			$("#spanPhoneNum").text("不能为空");
		}else if(!isPhoneNum(phoneNum)){
			$("#spanPhoneNum").text("格式不正确");
		}else {
			$("#spanPhoneNum").text("");
		}
		if(repassword.length == 0) {
			$("#spanRepassword").text("不能为空");
		}else if(password != repassword){
			$("#spanRepassword").text("密码不一致");
		}else {
			$("#spanRepassword").text("");
		}
		if(username.length != 0 && password.length != 0 && password==repassword && isEmail(email) && isPhoneNum(phoneNum)){
			
			$.ajax({
				url:"register/regist",
				type: "POST",
				data:{
						"username": username,
						"password": password,
						"email": email,
						"phoneNum": phoneNum
				},
				success: function(msg) {
					if("true" == msg){
						window.location.href = "success.jsp"
					}
				}
				
			});
		}
		
		
	});
}

/**
 * 邮箱检验的正则表达式
 * @param str
 * @returns
 */
function isEmail(str){ 
	var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;; 
	return reg.test(str);
}

/**
 * 手机号码的正则表达式
 * @param str
 * @returns
 */
function isPhoneNum(str){ 
	var reg = /^1[3|4|5|8][0-9]\d{4,8}$/;
	return reg.test(str);
} 