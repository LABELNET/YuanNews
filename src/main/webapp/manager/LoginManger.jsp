<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-4-5
  Time: 上午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>后台登录</title>
    <meta name="author" content="DeathGhost" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <style>
        body{height:100%;background:#16a085;overflow:hidden;}
        canvas{z-index:-1;position:absolute;}
    </style>
    <script src="js/jquery.js"></script>
    <script src="js/verificationNumbers.js"></script>
    <script src="js/Particleground.js"></script>
    <script type="application/javascript">
        $(document).ready(function() {
            //粒子背景特效
            $('body').particleground({
                dotColor: '#5cbdaa',
                lineColor: '#5cbdaa'
            });
            //验证码
            createCode();

            //弹出：确认按钮
            $(".trueBtn").click(function(){
                $(".pop_bg").fadeOut();
            });
            //弹出：取消或关闭按钮
            $(".falseBtn").click(function(){
                $(".pop_bg").fadeOut();
            });

        });

        function login() {

            var isTrue = validate();
            if(isTrue==false){
                showDialog("验证码不正确，请重写输入！");
                return;
            }

            var num=$("#unum").val();
            var  pass=$("#pass").val();
            $.post("/managerLogin.action",{
                        unum:num,
                        pass:pass
                    },
                    function (data,status) {
                        console.log(data+ " | "+status);
                        forwardPage(data);
                    }
            );
        }

        function forwardPage(data) {
            if(data>0){
                //跳转
                location.href="/managerIndex.action";
            }

            if(data==-1){
                //密码错误
                showDialog("密码错误");
            }

            if(data==-2){
                //账号不存在
                showDialog("账号不存在！");
            }

            if(data==-3){
                //服务器错误，登陆失败
                showDialog("服务器错误，登陆失败,请刷新重试！");
            }

        }

        function showDialog(msg) {
            $(".pop_cont_text").text(msg);
            $(".pop_bg").fadeIn();
        }

    </script>
</head>
<body>
<dl class="admin_login">
    <dt>
        <strong>新闻推荐－后台管理系统</strong>
        <em>Management System</em>
    </dt>
    <dd class="user_icon">
        <input type="number" name="unum" id="unum" placeholder="账号" class="login_txtbx"/>
    </dd>
    <dd class="pwd_icon">
        <input type="password" id="pass" placeholder="密码" class="login_txtbx"/>
    </dd>
    <dd class="val_icon">
        <div class="checkcode">
            <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
            <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
        </div>
        <input type="button" value="刷新验证码" class="ver_btn" onClick="createCode()">
    </dd>
    <dd>
        <input type="button" value="立即登陆" class="submit_btn" onclick="login()"/>
    </dd>
    <dd>
        <p>© 201６ LABELNET－yuan 版权所有</p>
        <p><a href="http://www.labelnet.cn">yuan</a></p>
    </dd>
</dl>

<section class="pop_bg">
    <div class="pop_cont">
        <!--title-->
        <h3>　温馨提示　</h3>
        <!--以pop_cont_text分界-->
        <div class="pop_cont_text">
            这里是文字性提示信息！
        </div>
        <!--bottom:operate->button-->
        <div class="btm_btn">
            <input type="button" value="确认" class="input_btn trueBtn"/>
            <input type="button" value="关闭" class="input_btn falseBtn"/>
        </div>
    </div>
</section>

</body>
</html>

