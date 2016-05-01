<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-5-2
  Time: 上午12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div>
    <span id="show" style="color: purple;margin: 10%;float: left;"></span>
</div>

<div class="signin" style="width: 100px;float: right;margin: 20% 10%;">
    <input type="submit" value="注册" onclick="userRegister()">
</div>

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
            <a style="text-decoration:none;color: #0c9c6e;" href="javascript:void(0)" onclick="loginUser()">登陆</a>
        </span>
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <form onsubmit="return false" style="height: 400px;">
        <input type="text" style="height: 10px;" class="text"  id="nick" value="昵称" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '昵称';}" />
        <input type="text" style="height: 10px;" class="text"  id="unum" value="电话" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '电话';}" />
        <input type="text" style="height:10px;" id="pass" value="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码';}"/>
        <input type="text" style="height: 10px;" id="passtwo" value="确认密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '确认密码';}"/>
    </form>

</div>

<script type="text/javascript">

    var loginPageUrl="<%=projectPath%>/html/login/userLoginPage.action";
    var registerUrl="<%=projectPath%>/html/login/userRegister.action";

    window.onload=function() {
        $('body').show();
        NProgress.start();
        setTimeout(function() { NProgress.done(); $('.fade').removeClass('out'); }, 1000);
    }

    function doneIt() {
        NProgress.done();
    }

    function userRegister() {
        NProgress.start();

        var nick=$("#nick").val();
        if(nick.trim().length==0){
            $("#show").text("请输入昵称！");
            doneIt();
            return;
        }

        var unum=$("#unum").val()+"";
        if(unum.length!=11){
            $("#show").text("电话长度不对哦！");
            doneIt();
            return;
        }
        var pass=$("#pass").val()+"";

        if(pass.length==0){
            $("#show").text("请输入密码！");
            doneIt();
            return;
        }

        var passtwo=$("#passtwo").val();
        if(pass!=passtwo){
            $("#show").text("密码两次不一样！");
            doneIt();
            return;
        }


        var arr={
            unum:unum,
            pass:pass,
            nick:nick
        };
        console.log(arr);
        dataRequest(registerUrl,arr,0);
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
                        $("#show").text("账户已存在");
                    }else if(data==-2){
                        $("#show").text("系统错误");
                    }
                    else {
                        $("#show").text("注册失败，请重试！");
                    }
                }else {
                    window.location.reload()
                }
            }
        });
    }

    function loginUser() {
        window.location.href=loginPageUrl;
    }

</script>
</body>
</html>