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

    //分页实现：　itemsOnPage 当前页面的item总数
    $(function() {
      $("#paginationpage").pagination({
        items: ${count},
        itemsOnPage: 8,
        page:10,
        hrefTextPrefix:"?p=",
        cssStyle: 'light-theme',
        prevText:"上一页",
        nextText:"下一页",
        currentPage:${currentPage}

      });
    });

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
  <h2><a href="<%=projectPath%>/manager/managerIndex.action">首页</a></h2>
  <ul>
    <li>
      <dl>
        <dt>用户信息</dt>
        <!--当前链接则添加class:active-->
        <dd><a href="<%=projectPath%>/manager/managerUserPage.action?p=1">用户列表</a></dd>
        <dd><a href="<%=projectPath%>/manager/managerTastePage.action?p=1" class="active">用户兴趣</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>新闻信息</dt>
        <dd><a href="#">新闻列表</a></dd>
        <dd><a href="#">分类管理</a></dd>
        <dd><a href="#">来源管理</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>评论信息</dt>
        <dd><a href="#">评论管理</a></dd>
        <dd><a href="#">点赞管理</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>Api设计</dt>
        <dd><a href="#">管理员接口</a></dd>
        <dd><a href="#">用户接口</a></dd>
        <dd><a href="#">其他接口</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>关于</dt>
        <dd><a href="#">站点介绍</a></dd>
        <dd><a href="#">关于我</a></dd>
      </dl>
    </li>

    <li>
      <p class="btm_infor">© Yuan 版权所有</p>
    </li>
  </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
  <div class="rt_content" style="margin-top: 10px;">

    <section>
      <div class="page_title">
        <h2 class="fl">兴趣管理</h2>
        <button type="button" class="fr top_rt_btn" onclick="addUser()">添加兴趣</button>
      </div>
          <table class="table fl" style="margin-top:8px;">
            <tr>
              <th>ID</th>
              <th>兴趣标签</th>
              <th>用户ID</th>
              <th>用户昵称</th>
              <th>操作</th>
            </tr>
            <c:if test="${empty tasteVos}">
                <tr>
                  <td colspan="5">没有更多数据了</td>
                </tr>
            </c:if>
            <c:if test="${!empty tasteVos}">
              <c:forEach items="${tasteVos}" var="tasteVo">
                <tr>
                  <td class="center">${tasteVo.id}</td>
                  <td class="center">${tasteVo.label}</td>
                  <td class="center">${tasteVo.uid}</td>
                  <td class="center">${tasteVo.nick}</td>
                  <td class="center">
                    <button type="button" class="link_btn" >修改兴趣</button>
                    <a class="inner_btn">删除信息</a>
                  </td>
                </tr>
              </c:forEach>
            </c:if>

            <tfoot>
               <tr>
                 <td colspan="5">
                   <div id="paginationpage" style="float: right"></div>
                 </td>
               </tr>
            </tfoot>
          </table>

      </section>

  </div>

</section>
</body>
</html>

