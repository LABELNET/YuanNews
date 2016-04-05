<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-4-5
  Time: 上午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>管理员登陆</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Easy Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
    <!-- Custom CSS -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!-- Graph CSS -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <!-- lined-icons -->
    <link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
    <!-- //lined-icons -->
    <!-- chart -->
    <script src="js/Chart.js"></script>
    <!-- //chart -->
    <!--animate-->
    <link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
    <!--//end-animate-->
    <!----webfonts--->
    <link href='http://fonts.useso.com/css?family=Cabin:400,400italic,500,500italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
    <!---//webfonts--->
    <!-- Meters graphs -->
    <script src="js/jquery-1.10.2.min.js"></script>
    <!-- Placed js at the end of the document so the pages load faster -->

    <script type="application/javascript">
        function login() {
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

<body class="sign-in-up">
<section>
    <div id="page-wrapper" class="sign-in-wrapper">
        <div class="graphs">
            <div class="sign-in-form">
                <div class="sign-in-form-top">
                    <p><span>新闻推荐</span> <a href="index.html">后台管理</a></p>
                </div>
                <div class="signin">
                    <div class="signin-rit">
								<span class="checkbox1">
									 <label class="checkbox"><input type="checkbox" name="checkbox" checked="">忘记密码 ?</label>
								</span>
                        <p><a href="#">点我－> 回到主页</a> </p>
                        <div class="clearfix"> </div>
                    </div>
                    <form >
                        <div class="log-input">
                            <div class="log-input-left">
                                <input type="text" class="user" id="unum" name="unum" value="手机号码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '手机号码:';}"/>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="log-input">
                            <div class="log-input-left">
                                <input type="password" class="lock" id="pass" name="pass" value="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码:';}"/>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <input type="button" onclick="login()" value="　登　陆　">
                    </form>
                </div>
                <div class="new_people">
                    <h4>新 来 的 ?</h4>
                    <p>欢迎进入新闻推荐后台管理系统，如果你没有账号的话，请先点击下面的按钮进行注册，后联系管理员哦！</p>
                    <a href="sign-up.html">马上注册　!</a>
                </div>
            </div>
        </div>
    </div>
    <!--footer section start-->
    <footer>
        <p>Copyright &copy; 201６.LABELNET-yuan All rights reserved.<a target="_blank" href="http://www.labelnet.cn">yuan</a></p>
    </footer>
    <!--footer section end-->
</section>

<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
