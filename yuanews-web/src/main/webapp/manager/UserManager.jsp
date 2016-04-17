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
<% String projectPath=request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>新闻推荐-后台管理系统</title>
  <meta name="author" content="DeathGhost" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />

  <!--[if lt IE 9]>
  <script src="js/html5.js"></script>
  <![endif]-->
  <script src="js/jquery.js"></script>
  <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>

  <!-- 分页插件－simplePagination -->
  <link  rel="stylesheet" type="text/css" href="css/simplePagination.css" />
  <script src="js/simplePagination.js"></script>

  <script>

    var updateGetUserIfoUrl="<%=projectPath%>/manager/managerUserIfo.action";
    var updateCommitUserIfoUrl="<%=projectPath%>/manager/managerUpdateUser.action";
    var deleteUserIfoUrl="<%=projectPath%>/manager/managerDeleteUserIfo.action";
    var insertUserIfoUrl="<%=projectPath%>/manager/managerInsertUserIfo.action";
    var settingUserIfoUrl="<%=projectPath%>/manager/managerSettingUserIfo.action";

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
        items: ${userCount},
        itemsOnPage: 8,
        page:10,
        hrefTextPrefix:"?p=",
        cssStyle: 'light-theme',
        prevText:"上一页",
        nextText:"下一页",
        currentPage:${currentPage}

      });
    });

    function deleteUser(id) {
      //删除用户ajax进行操作
      var arr={id:id};
      showDialog(arr,1);
    }

    function addUser() {
      //新增用户
      showDialog("",2);
    }


    function updateUser(id) {
      //1.加载当前用户信息
      var arr={ id:id };
      dataRequest(updateGetUserIfoUrl,arr,0);
    }

    function settingsUser(id) {
      //回复用户信息
      var arr={ id:id };
      dataRequest(settingUserIfoUrl,arr,1);
    }

    //实现思路　：　两个方法　：　dialog(user) 和　ajax(url,user)

    function showDialog(data,type) {

      if(type==0){
        //初始化修改dialog界面

        $("#pop_title").text("　修改信息 ");
        $(".pop_cont_input").show();
        $("#userunum").text("账号：　"+data.unum);
        $(".nick").val(data.nick);
        $(".pop_add_input").hide();
        $("#uid").val(data.id);
        if(data.sex==0){
          $("#sex").find("option[text='男']").attr("selected",true);
        }else if(data.sex==1){
          $("#sex").find("option[text='男']").attr("selected",true);
        }else {
          $("#sex").find("option[text='未知']").attr("selected",true);
        }

　　　　　if(data.status==0){
          $("#status").find("option[text='普通用户']").attr("selected",true);
        }else {
          $("#status").find("option[text='管理员']").attr("selected",true);
        }

        $(".pop_cont_text").text("是否对　"+data.unum+"　的信息进行修改？");

      }

      if(type==1){
        //初始化删除dialog界面
        $(".pop_bg").fadeIn();
        $("#pop_title").text(" 删除信息 ");
        $(".pop_cont_input").hide();
        $(".pop_cont_text").text("　你确定要删除该用户吗？　");
        $(".pop_add_input").hide();
      }

      if(type==2){
        //初始化添加dialog界面
        $(".pop_bg").fadeIn();
        $("#pop_title").text("　添加用户　");
        $(".pop_cont_input").hide();
        $(".pop_cont_text").text(" 你确定要添加该用户吗？ ");
        $(".pop_add_input").show();
      }

　　  $(".pop_bg").fadeIn();

      //弹出：确认按钮
      $(".trueBtn").click(function(){
　　　　　if(type==0){
  　　　　　　//进行修改
           var nick=$(".nick").val();
           var sex=$("#sex").val();
           var status=$("#status").val();
           var id=$("#uid").val();
           var arr={
             id:id,
             nick:nick,
             sex:sex,
             status:status
           };
           dataRequest(updateCommitUserIfoUrl,arr,0);
　　　　　}

        if(type==1){
          //进行删除
          dataRequest(deleteUserIfoUrl,data,1);
        }

        if(type==2){
          //进行添加
          var userVonick=$("#userVonick").val();
          var username=$(".username").val();
          var password=$(".password").val();
          var pass=$(".pass").val();
          var arr2={
            nick:userVonick,
            unum:username,
            pass:password
          };
          console.log(arr2);
          if(pass==password){
            dataRequest(insertUserIfoUrl,arr2,1);
          }else {
            $("#pass").val("");
            return;
          }
        }

        $(".pop_bg").fadeOut();
      });

      //弹出：取消或关闭按钮
      $(".falseBtn").click(function(){
        $(".pop_bg").fadeOut();
        type=-1;
      });

    }

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
            if(status=="success"){
              if(data>=0){
                //刷新页面
                window.location.reload();
              }else if(data<0){
                showSE("操作失败～");
              }else {
                showDialog(data,type);
              }
            }else {
              showSE("网络加载失败～");
            }
         }
      });
    }

    function showSE(msg) {
      $(".pop_bg").fadeIn();
      $("#pop_title").text("温馨提醒");
      $(".pop_cont_input").hide();
      $(".pop_cont_text").text(msg);
      $(".falseBtn").hide();
      $(".pop_add_input").hide();
      //弹出：确认按钮
      $(".trueBtn").click(function(){
        $(".pop_bg").fadeOut();
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
        <dd><a href="<%=projectPath%>/manager/managerUserPage.action?p=1" class="active">用户列表</a></dd>
        <dd><a href="<%=projectPath%>/manager/managerTastePage.action?p=1">用户兴趣</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>新闻信息</dt>
        <dd><a href="#">新闻列表</a></dd>
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
        <h2 class="fl">用户管理</h2>
        <button type="button" class="fr top_rt_btn" onclick="addUser()">新增用户</button>
      </div>
      <table class="table" style="text-align:center">
        <tr>
          <th>序号</th>
          <th>头像</th>
          <th>账号</th>
          <th>昵称</th>
          <th>性别</th>
          <th>身份</th>
          <th>操作</th>
        </tr>
        <c:if test="${!empty userVos}">
          <c:forEach items="${userVos}" var="userVo">
            <tr>
              <td>${userVo.id}</td>
              <td><img src="${userVo.head}" style="max-width: 50px;max-height: 50px;"></td>
              <td>${userVo.unum}</td>
              <td>${userVo.nick}</td>
              <td>${userVo.sex==0?"男":"女"}</td>
              <c:if test="${userVo.status==3}">
                <td style="color: red;">该用户已被删除</td>
                <td><button type="button" class="link_btn" onclick="settingsUser(${userVo.id})">恢复信息</button></td>
              </c:if>

              <c:if test="${userVo.status!=3}">
                <td>${userVo.status==0?"普通用户":"管理员"}</td>
                <td>
                  <button type="button" class="link_btn" onclick="updateUser(${userVo.id})">修改信息</button>
                  <a class="inner_btn" onclick="deleteUser(${userVo.id})">删除信息</a>
                </td>
              </c:if>

            </tr>
           </c:forEach>
        </c:if>
        <c:if test="${empty userVos}">
          　<tr>
               <td colspan="7"><c:out value="没有更多数据了"/></td>
            </tr>
        </c:if>
      </table>
      <aside class="paging">
        <div id="paginationpage" style="float: right"></div>
      </aside>
    </section>

    <section class="pop_bg">
      <div class="pop_cont">
        <!--title-->
        <h3 id="pop_title">弹出提示标题</h3>
        <!--content-->
        <div class="pop_cont_input">
          <ul>
            <li>
              <span id="userunum">账号：</span>
              <input type="hidden" id="uid" />
            </li>

            <li>
              <span class="ttl">昵称：</span>
              <input type="text"　id="nick" name="nick"  placeholder="修改你的昵称" class="nick"/>
            </li>

            <li>
              <span class="ttl">性别：</span>
              <select  　class="select" id="sex">
                <option value="0">男</option>
                <option value="1">女</option>
                <option value="2">未知</option>
              </select>
            </li>
            <li>
              <span class="ttl">权限设置：</span>
              <select  　class="status" name="status" id="status">
                <option value="0">普通用户</option>
                <option value="1">管理员</option>
              </select>

            </li>
          </ul>
        </div>

　　　　<div class="pop_add_input">
          <ul>
            <li>
              <span class="ttl">昵称：</span>
              <input type="text"　name="userVonick" id="userVonick" placeholder="输入你的昵称" class="textbox userVonick"/>
            </li>
            <li>
              <span class="ttl">账号：</span>
              <input type="text" name="username" 　id="username" placeholder="输入你的账号" class="textbox username"/>
            </li>
            <li>
              <span class="ttl">密码：</span>
              <input type="text" name="password" 　id="password" placeholder="输入你的密码" class="textbox password"/>
            </li>
            <li>
              <span class="ttl">重新输入密码：</span>
              <input type="text"　name="pass" id="pass" placeholder="重新输入你的密码" class="textbox pass"/>
            </li>
          </ul>
       </div>

        <!--以pop_cont_text分界-->
        <div class="pop_cont_text">
          是否进行信息的修改?
        </div>
        <!--bottom:operate->button-->
        <div class="btm_btn">
          <input type="button" value="确认" class="input_btn trueBtn"/>
          <input type="button" value="关闭" class="input_btn falseBtn"/>
        </div>
      </div>
    </section>
    <!--结束：弹出框效果-->


  </div>
</section>
</body>
</html>
