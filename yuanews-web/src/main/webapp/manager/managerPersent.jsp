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
    <li><a href="<%=projectPath%>/html/pageIndex.action?p=1&type=2&nType=6" target="_blank" class="website_icon">站点首页</a></li>
    <li><a href="#" class="admin_icon"><%=userVo.getNick()%></a></li>
    <li><a href="#" class="set_icon">个人中心</a></li>
    <li><a href="<%=projectPath%>/manager/managerLoginOut.action" class="quit_icon">安全退出</a></li>
  </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
  <h2><a href="<%=projectPath%>/manager/managerIndex.action" class="active">首页</a></h2>
  <ul>
    <li>
      <dl>
        <dt>用户信息</dt>
        <!--当前链接则添加class:active-->
        <dd><a href="<%=projectPath%>/manager/managerUserPage.action?p=1">用户列表</a></dd>
        <dd><a href="<%=projectPath%>/manager/managerTastePage.action?p=1">用户兴趣</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>新闻信息</dt>
        <dd><a href="<%=projectPath%>/manager/managerNewsPage.action?p=1">新闻列表</a></dd>
        <dd><a href="<%=projectPath%>/manager/managerCatePage.action">分类管理</a></dd>
        <dd><a href="<%=projectPath%>/manager/managerSourcePage.action?p=1">来源管理</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>评论信息</dt>
        <dd><a href="<%=projectPath%>/manager/managerCommentPage.action?p=1">评论管理</a></dd>
        <dd><a href="<%=projectPath%>/manager/managerLikedPage.action?p=1">点赞管理</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>Api设计</dt>
        <dd><a href="<%=projectPath%>/manager/managerApi.jsp"　target="_blank">新闻推荐API</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>关于</dt>
        <dd><a href="<%=projectPath%>/manager/managerPersent.jsp" class="active">站点介绍</a></dd>
        <dd><a href="<%=projectPath%>/manager/aboutMe.jsp">关于我</a></dd>
      </dl>
    </li>

    <li>
      <p class="btm_infor">© Yuan 版权所有</p>
    </li>
  </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
  <div class="rt_content center" style="margin-top: 10px;">

   <h1> 站点系统介绍　</h1>
　　<div style="text-align: center;">
     <p style="max-width: 500px;margin: 0 auto;">　　随着网络的快速发展，新闻成为我们生活中不可或缺的信息。但是在过量的新闻中，反而使得用户无法找到自己感兴趣的新闻。用户只能通过搜索工具或导航去盲目的查找自己感兴趣的新闻，而大多数的新闻门户网站向用户推荐的内容是热门或最新的新闻，并不符合用户自身的兴趣爱好的新闻。</p>
   </div> <br>
    <div style="text-align: center">
       <p style="max-width: 500px;margin: 0 auto;">　　基于用户兴趣标签的新闻推荐系统根据用户自定义的兴趣标签，社交平台兴趣标签，来及时的，动态的分析并给用户推荐相关兴趣的新闻。利用自动分类，关键字分词提取，建立用户兴趣模型，推荐给用户感兴趣的新闻，并为用户生成用户兴趣的新闻浏览页面。</p>
    </div>
    <div style="text-align: center">
      <p style="max-width: 500px;margin: 0 auto;">　
         开发环境：idea , mysql , ssm ;
      </p>
    </div>
      <br><br>
   <h5>作者：　原明卓　　　编辑时间:　2016.04.17 　　更新时间：　2016.04.17</h5>
  </div>
</section>
</body>
</html>
