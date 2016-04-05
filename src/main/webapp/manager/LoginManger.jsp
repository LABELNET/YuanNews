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
        });

        function login() {
            validate();
            var unum=$("#unum").val();
            var  pass=$("#pass").val();
            $.post("/managerLogin.action",{
                        unum:unum,
                        pass:pass
                    },
                    function (data,status) {
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
                alert("密码错误");
            }

            if(data==-2){
                //账号不存在
                alert("账号不存在！")
            }

            if(data==-3){
                //服务器错误，登陆失败
                alert("服务器错误，登陆失败,请刷新重试！");
            }

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
        <input type="text"　id="unum" placeholder="账号" class="login_txtbx"/>
    </dd>
    <dd class="pwd_icon">
        <input type="password" id="pass" placeholder="密码" class="login_txtbx"/>
    </dd>
    <dd class="val_icon">
        <div class="checkcode">
            <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
            <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
        </div>
        <input type="button" value="验证码核验" class="ver_btn" onClick="">
    </dd>
    <dd>
        <input type="button" value="立即登陆" class="submit_btn" onclick="login()"/>
    </dd>
    <dd>
        <p>© 201６ LABELNET－yuan 版权所有</p>
        <p><a href="http://www.labelnet.cn">yuan</a></p>
    </dd>
</dl>
</body>
</html>

