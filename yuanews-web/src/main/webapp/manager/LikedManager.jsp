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

    var baseUrl="<%=projectPath%>/manager/";
    var likeDeleteUrl=baseUrl+"managerDeleteLiked.action";

    //分页实现：　itemsOnPage 当前页面的item总数
    $(function() {
      $("#paginationpage").pagination({
        items: ${count},
        itemsOnPage: 10,
        page:10,
        hrefTextPrefix:"?p=",
        cssStyle: 'light-theme',
        prevText:"上一页",
        nextText:"下一页",
        currentPage:${currentPage}

      });
    });


   function showDialog(id) {
             $(".pop_bg").fadeIn();

            //弹出：确认按钮
             $(".trueBtn").click(function(){
               $(".pop_bg").fadeOut();
               var arr={
                 id:id
               };
              dataRequest(likeDeleteUrl,arr);
             });

             //弹出：取消
             $(".falseBtn").click(function(){
               $(".pop_bg").fadeOut();
                id=-1;
             });

   }

    //网络请求方法提取
    function dataRequest(typeurl,arr) {
      console.log(arr);
      $.ajax({
         url:typeurl,
         data:arr,
         type:'post',
         cache:true,
         dataType:'json',
         success:function (data,status) {
            console.log(data);
            window.location.reload()
         }
      });
    }

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
        <dd><a href="<%=projectPath%>/manager/managerLikedPage.action?p=1" class="active">点赞管理</a></dd>
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
        <dd><a href="<%=projectPath%>/manager/managerPersent.jsp">站点介绍</a></dd>
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
      <div class="page_title" >
        <h2 class="fl">新闻点赞信息管理</h2>
        <div style="float:right;">
          点赞状态描述 ：
          <img style="width:40px;margin-left:20px;" src="/image/icon/zan.png"/> 没有点赞
          <img style="width:40px;margin-left:20px;" src="/image/icon/normalzan.png"/> 点赞
          <img style="width:40px;margin-left:20px;" src="/image/icon/superzan.png"/> 超赞
        </div>
      </div>

      <table class="table center" style="margin-top:10px;">
        <thead>
          <tr>
            <th>ID</th>
            <th>用户头像</th>
            <th>昵称</th>
            <th>新闻标题</th>
            <th>点赞状态</th>
            <th>操作</th>
          </tr>
       </thead>
        <c:if test="${empty likedPos}">
           <tr>
             <td colspan="3">没有更多数据了</td>
           </tr>
        </c:if>
        <c:if test="${!empty likedPos}">
          <c:forEach items="${likedPos}" var="likedPo">
            <tr>
              <td>${likedPo.id}</td>
              <td><img style="width:50px;" src="${likedPo.userVo.head}"/></td>
              <td>${likedPo.userVo.nick}</td>
              <td>${likedPo.newsVo.title}</td>
              <td><img style="width:50px;" src="${likedPo.status==1?"/image/icon/normalzan.png":"/image/icon/superzan.png"}" /></td>
              <td>
                <a class="inner_btn" onclick="showDialog(${likedPo.id})">删除信息</a>
              </td>
            </tr>
          </c:forEach>
        </c:if>

        <tfoot>
           <tr>
             <td colspan="6">
               <div id="paginationpage" style="float: right"></div>
             </td>
           </tr>
        </tfoot>

      </table>
    </section>

    <!-- 弹出框 -->
    <section class="pop_bg">
    <div class="pop_cont">
     <!--title-->
     <h3 class="dialog_title">温馨提示</h3>
     <!--以pop_cont_text分界-->
     <div class="pop_cont_text">
      你确定要删除该条点赞信息吗？
     </div>
     <!--bottom:operate->button-->
     <div class="btm_btn">
      <input type="button" value="确认" class="input_btn trueBtn"/>
      <input type="button" value="关闭" class="input_btn falseBtn"/>
     </div>
    </div>
    </section>


  </div>
</section>
</body>
</html>
