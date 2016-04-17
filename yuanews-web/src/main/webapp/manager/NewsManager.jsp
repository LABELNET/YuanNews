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
        itemsOnPage: 10,
        page:10,
        hrefTextPrefix:"?p=",
        cssStyle: 'light-theme',
        prevText:"上一页",
        nextText:"下一页",
        currentPage:${currentPage}

      });
    });

      var baseUrl="<%=projectPath%>/manager/";
    //  var newsInsertUrl=baseUrl+"managerInsertNews.action";
      var newsUpdateUrl=baseUrl+"managerUpdateNews.action";
      var newsDeleteUrl=baseUrl+"managerDeleteNews.action";
      var newsFindOne=baseUrl+"managerNewsOne.action";
      var newsFindNewsContent=baseUrl+"managerFindNewsContent.action";


    //type: 0,添加　；２,删除　；１,修改 : ３，提交修改 : ４．查看新闻内容
    function showDialog(id,type){

　　　　　$(".pop_bg").fadeIn();

　　　　　if(type==4){
          $(".dialog_title").text("新闻内容：");
          $(".pop_cont_input").hide();
       }

       if(type==2){
         $(".dialog_title").text("温馨提醒");
         $(".pop_cont_input").hide();
         $(".pop_cont_text").text("你确定要删除该条新闻吗？");
       }

　　　　　if(type==1){
//          $(".dialog_title").text("修改新闻来源信息");
//          $(".pop_cont_input").show();
//          $(".pop_cont_text").text("你确定要修改该来源信息吗？");
       }

        //弹出：确认按钮
        $(".trueBtn").click(function(){
          $(".pop_bg").fadeOut();
          if(type==0){
            insert();
          }else if(type==1){
            update(id);
          }else if(type==2){
            deleteIfo(id);
          }
        });

        //弹出：取消
        $(".falseBtn").click(function(){
          $(".pop_bg").fadeOut();
          $(".dialog_label").val("");
          type=-1;
        });
    }


　function update(id) {
　  //修改:　提交修改type 3
    var source=$(".dialog_label").val();
    var arr={
      id:id,
      source:source
    }
    dataRequest(newsDeleteUrl,arr,3);
　}

　function deleteIfo(id) {
　  //删除
　　var arr={
      id:id
    }
    dataRequest(newsDeleteUrl,arr,2);
　}


    //加载修改的信息
    function dataRequestIfo(id,type) {
        var arr={
          id:id
        }
        dataRequest(newsFindOne,arr,type);
    }

    function dataRequestContent(id,type) {
      var arr={
        id:id
      }
      dataRequest(newsFindNewsContent,arr,type);
    }


    //网络请求方法提取
    function dataRequest(typeurl,arr,type) {
      console.log(arr);
      $.ajax({
         url:typeurl,
         data:arr,
         type:'post',
         cache:true,
         dataType:'json',
         success:function (data,status) {
            console.log(data);
             if(type==4){
                 //查看新闻内容
                 showDialog(arr.id,type);
                 $(".pop_cont_text").text(data.content);
             }else if(type==1){
                 showDialog(arr.id,type);
                 //初始化dialog　信息

             }else{
               window.location.reload()
             }
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
        <h2 class="fl">新闻来源管理</h2>
         <div style="color:blue;margin-left:50px;float:right;">
            新闻数据不提供录入功能，数据来自爬虫自动完成！
         </div>
      </div>

      <table class="table center">
        <thead>
          <tr>
            <th>ID</th>
            <th>title</th>
            <th>图片</th>
            <th>阅读量</th>
            <th>时间</th>
            <th>内容</th>
            <th>来源</th>
            <th>分类</th>
            <th>操作</th>
          </tr>
       </thead>
        <c:if test="${empty newsPos}">
           <tr>
             <td colspan="3">没有更多数据了</td>
           </tr>
        </c:if>
        <c:if test="${!empty newsPos}">
          <c:forEach items="${newsPos}" var="newsPo">
            <tr>
              　<td>${newsPo.id}</td>
                <td>${newsPo.title}</td>
                <td><img style="width: 80px" src="${newsPo.img}" /></td>
                <td>${newsPo.rnum}</td>
                <td>${newsPo.dt}</td>
              <td><button type="button" class="link_btn" onclick="dataRequestContent(${newsPo.id},4)">查看新闻内容</button> </td>
              <td>${newsPo.sourceStr}</td>
              <td>${newsPo.cateStr}</td>
              <td>
                <button type="button" class="link_btn" onclick="dataRequestIfo(${newsPo.id},1)">修改信息</button>
                <a class="inner_btn" onclick="showDialog(${newsPo.id},2)">删除信息</a>
              </td>
            </tr>
          </c:forEach>
        </c:if>

        <tfoot>
           <tr>
             <td colspan="9">
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
     <!--content-->
     <div class="pop_cont_input">
      <ul>
       <li>
        <span>标题信息：</span>
        <input type="text" class="dialog_label" name="dialog_label" placeholder="标签内容" class="textbox"/>
       </li>
      </ul>
     </div>
     <!--以pop_cont_text分界-->
     <div class="pop_cont_text">
      你确定操作吗？
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
