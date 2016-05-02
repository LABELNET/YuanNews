<%@ page import="yuan.ssm.vo.UserVo" %><%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-5-1
  Time: 下午11:35
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
    <link href="css/detail.css" rel='stylesheet' type='text/css' />
    <!--webfonts-->
    <link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
    <!--//webfonts-->
    <script src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <link rel='stylesheet' href="../css/nprogress.css"/>
    <script src="../js/nprogress.js"></script>


</head>
<body>
<script>
    $(document).ready(
        function (c) {
            $('.close').on('click', function(c){
                $('.login-form').fadeOut('slow', function(c){
                    $('.login-form').remove();
                });
       });
   });
</script>

<div class="content">

    <div class="content_top">

        <div class="top_left">
            <h3>个人信息</h3>
            <div class="left_img">
                <img src="http://localhost:8088/image/head/moren.jpg">
                <h3>LABELNET</h3>
                <input type="button" value="安全退出" onclick="userOut()">
            </div>

            <div class="left_ifo">
                <h4>电话：150000000000</h4>
                <h4>性别：男</h4>
                <h4>权限：</h4>
            </div>

        </div>

        <div class="top_right">
                <div class="label_left">
                    <h3>兴趣标签</h3>
                    <div class="labels">
                        <label>刘亦菲</label>
                    </div>
                </div>
        </div>

    </div>


</div>
<script type="text/javascript">

    var loginOutUrl="<%=projectPath%>/html/login/userLoignout.action";

    window.onload=function() {
        $('body').show();
        NProgress.start();
        setTimeout(function() { NProgress.done(); $('.fade').removeClass('out'); }, 1000);
    }



    function doneIt() {
        NProgress.done();
    }

    
    function userOut() {
        dataRequest(loginOutUrl,new Array(),0);
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
                if(status=="success"){
                    if(data==0){
                        $.DialogBySHF.Close();
                    }
                }else {
                    window.location.reload()
                }
            }
        });
    }

    //获取随机颜色 - 标签颜色
    var getRandomColor = function(){
        return  '#' +

                (function(color){

                    return (color +=  '0123456789abcdef'[Math.floor(Math.random()*16)])

                    && (color.length == 6) ?  color : arguments.callee(color);

                })('');
    };

</script>
</body>
</html>
