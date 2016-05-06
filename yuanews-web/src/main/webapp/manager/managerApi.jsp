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
        <dd><a href="#userrlogin">用户登陆</a></dd>
        <dd><a href="#userregister">用户注册</a></dd>
        <dd><a href="#updateHead">修改头像</a></dd>
        <dd><a href="javascript:void(0)">修改密码</a></dd>
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
<!-- 登陆 -->
   <table id="userrlogin" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
          <th colspan="2"><h1>用户登录</h1></th>
      </thead>
     <tbody>
         <tr>
            <td>接口地址 ：</td>
            <td>api/login</td>
         </tr>
         <tr>
           <td>参数类型：</td>
           <td>
               unum : String 账户 <br>
               pass : String 密码
           </td>
         </tr>
         <tr>
            <td>返回数据：</td>
            <td>
              {<br>
              "code": 0,<br>
              "data": {<br>
              "head": "/image/head/2016041514302526219e9e283-b330-47bc-9150-fb416ecd1e46.png",<br>
              "id": 24,<br>
              "nick": "明天",<br>
              "pass": "123456",<br>
              "sex": 0,<br>
              "status": 1,<br>
              "unum": "15000000020"<br>
              },<br>
              "msg": "登录成功"<br>
              }<br>
            </td>
         </tr>
         <tr>
            <td>数据解释 ：</td>
            <td>
               code :响应码 0,成功;-1失败;-2 系统错误；<br>
               data :用户实体对象 <br>
               msg  :响应信息<br>
              <br>
              data/head :用户头像<br>
              data/id   :用户id<br>
              data/nick :用户昵称<br>
              data/pass :用户密码<br>
              data/sex  :用户性别 0,男 ; 1，女;<br>
              data/status : 状态 0，普通用户;1,管理员；<br>
              data/unum  : 用户账户<br>
            </td>
         </tr>
     </tbody>
     <tfoot>
        <tr>
          <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/05</b></td>
        </tr>
     </tfoot>
   </table>

<!-- 注册 -->
    <table id="userregister" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>用户注册</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/register</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          unum : String 账户 <br>
          pass : String 密码 <br>
          nick : String 昵称
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "msg": "注册成功"<br>
          }<br>
          <br>
          {<br>
          "code": -1,<br>
          "msg": "用户已存在"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2 系统错误；<br>
          msg  :响应信息<br>
          <br>

        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>

    <table id="updateHead" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>修改头像</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/login</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          unum : String 账户 <br>
          pass : String 密码
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": {<br>
          "head": "/image/head/2016041514302526219e9e283-b330-47bc-9150-fb416ecd1e46.png",<br>
          "id": 24,<br>
          "nick": "明天",<br>
          "pass": "123456",<br>
          "sex": 0,<br>
          "status": 1,<br>
          "unum": "15000000020"<br>
          },<br>
          "msg": "登录成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2 系统错误；<br>
          data :用户实体对象 <br>
          msg  :响应信息<br>
          <br>
          data/head :用户头像<br>
          data/id   :用户id<br>
          data/nick :用户昵称<br>
          data/pass :用户密码<br>
          data/sex  :用户性别 0,男 ; 1，女;<br>
          data/status : 状态 0，普通用户;1,管理员；<br>
          data/unum  : 用户账户<br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/05</b></td>
      </tr>
      </tfoot>
    </table>

  </div>
</section>
</body>
</html>
