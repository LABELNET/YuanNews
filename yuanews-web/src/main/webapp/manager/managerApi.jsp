<%@ page import="yuan.ssm.common.constant.ManagerConstant" %>
<%@ page import="yuan.ssm.vo.UserVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-4-5
  Time: 下午12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UserVo userVo= (UserVo) session.getAttribute(ManagerConstant.MANAGER_USER_NAME); %>
<%  String projectPath=request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>新闻推荐-后台管理系统</title>
  <meta name="author" content="DeathGhost" />
  <link rel="stylesheet" type="text/css" href="css/style.css"/>

  <!--[if lt IE 9]>
  <script src="js/html5.js"></script>
  <![endif]-->
  <script src="js/jquery.js"></script>
  <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>

  <!-- 分页插件－simplePagination -->
  <link  rel="stylesheet" type="text/css" href="css/simplePagination.css" />
  <script src="js/simplePagination.js"></script>

  <script>
    (function($){
      $(window).load(function(){

        $("a[rel='load-content']").click(function(e){
          e.preventDefault();
          var url=$(this).attr("href");
          $.get(url,function(data){
            $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
            //scroll-to appended content
            $(".content").mCustomScrollbar("scrollTo","h2:last");
          });
        });

        $(".content").delegate("a[href='top']","click",function(e){
          e.preventDefault();
          $(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
        });

      });
    })(jQuery);


  </script>
</head>
<body>
<!--header-->
<header>
  <h1><img src="images/admin_logo.png"/></h1>
  <!-- 初始化 ：　管理员信息-->
  <ul class="rt_nav">
    <li><a href="<%=projectPath%>/CustomerIndex.action" target="_blank" class="website_icon">站点首页</a></li>
    <li><a href="#" class="admin_icon"><%=userVo.getNick()%></a></li>
    <li><a href="#" class="set_icon">个人中心</a></li>
    <li><a href="<%=projectPath%>/manager/managerLoginOut.action" class="quit_icon">安全退出</a></li>
  </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
  <h2><a href="<%=projectPath%>/manager/managerApi.jsp" class="active">刷新</a></h2>
  <ul>
    <li>
      <dl>
        <dt>返回后台</dt>
        <!--当前链接则添加class:active-->
        <dd><a href="<%=projectPath%>/manager/managerIndex.action">后台主页</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>用户接口</dt>
        <dd><a href="#">用户登陆</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>新闻接口</dt>
        <dd><a href="#">新闻列表</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>关于</dt>
        <dd><a href="<%=projectPath%>/manager/managerPersent.jsp">站点介绍</a></dd>
        <dd><a href="<%=projectPath%>/manager/aboutMe.jsp">关于我</a></dd>
      </dl>
    </li>

    <li>
      <p class="btm_infor">© Yuan 版权所有</p>
    </li>
  </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
  <div class="rt_content" style="margin-top: 10px;">

   <h1> hi , 新闻推荐API接口　v１.0 !</h1>


  </div>
</section>
</body>
</html>
