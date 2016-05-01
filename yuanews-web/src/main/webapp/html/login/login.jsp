<%@ page import="yuan.ssm.vo.UserVo" %><%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-5-1
  Time: 下午8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UserVo userVo= (UserVo) session.getAttribute("user"); %>
<%  String projectPath=request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!--webfonts-->
    <link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
    <!--//webfonts-->
    <script src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <link rel='stylesheet' href="../css/nprogress.css"/>
    <script src="../js/nprogress.js"></script>
</head>
<body>
<script>$(document).ready(function(c) {
    $('.close').on('click', function(c){
        $('.login-form').fadeOut('slow', function(c){
            $('.login-form').remove();
        });
    });
});
</script>
<div class="login-form">
    <div class="close"> </div>
    <div class="head-info">
        <span style="font-size: 20px;float: left;margin: 15px">
            <a style="text-decoration:none;color: #0c9c6e;" href="javascript:void(0)" onclick="registerUser()">注册</a>
        </span>
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <div>
        <span id="show" style="color: white;"></span>
    </div>
    <div class="avtar">
        <img src="images/avtar.png" />
    </div>
    <form onsubmit="return false">
        <input type="text" class="text"  id="unum" value="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
        <div class="key">
            <input type="password" id="pass" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
        </div>
    </form>
    <div class="signin">
        <input type="submit" value="登陆" onclick="userlogin()">
    </div>
</div>

<script type="text/javascript">

    var loginUrl="<%=projectPath%>/html/login/userLogin.action";
    var registerPageUrl="<%=projectPath%>/html/login/userRegesterPage.action";

    window.onload=function() {
        $('body').show();
        NProgress.start();
        setTimeout(function() { NProgress.done(); $('.fade').removeClass('out'); }, 1000);
    }

    function doneIt() {
        NProgress.done();
    }
    
    function userlogin() {
        NProgress.start();
        var unum=$("#unum").val()+"";
        if(unum.length!=11){
            $("#show").text("电话长度不对哦！");
            doneIt();
            return;
        }
        var pass=$("#pass").val();
        var arr={
            unum:unum,
            pass:pass
        };
        console.log(arr);
        dataRequest(loginUrl,arr,0);
    }

    //网络请求方法提取
    function dataRequest(typeurl,arr,type) {

        $.ajax({
            url:typeurl,
            data:arr,
            type:'post',
            cache:true,
            dataType:'json',
            success:function (data,status) {
                doneIt();
                console.log(data);
                if(status=="success"){
                    if(data==1){
                        $("#show").text("");
                        $('.login-form').fadeOut('slow',function(c){
                            $('.login-form').remove();
                        });
                    }else if(data==-1){
                        $("#show").text("登陆失败！");
                    }
                }else {
                    window.location.reload()
                }
            }
        });
    }
    
    function registerUser() {
        window.location.href=registerPageUrl;
    }

</script>
</body>
</html>

