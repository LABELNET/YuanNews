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

    var tasteBaseUrl="<%=projectPath%>/manager/";

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

   var tasteInsertUrl=tasteBaseUrl+"managerTasteInsert.action";
   var tasteUpdateUrl=tasteBaseUrl+"managerTasteUpdate.action";
   var tasteDeleteUrl=tasteBaseUrl+"managerTasteDelete.action";
   var tasteFindOneUrl=tasteBaseUrl+"managerTasteFind.action";


  function addTaste(){
      //添加兴趣信息
      showDialog(0,0);
  }

  function updateTaste(id) {
    //修改兴趣信息
    var arr={id:id};
    dataRequest(tasteFindOneUrl,arr,1);
  }

  function deleteTaste(id) {
    //删除兴趣信息
    showDialog(2,id);
  }

  function showDialog(type,id) {

    $(".btn_es").hide();

    if(type==0){
      $(".pop_cont_input").show();
      $(".dialog_ids").show();
      $(".pop_cont_text").text("你确定要添加该兴趣吗？");
    }

    if(type==1){
      $(".pop_cont_input").show();
      $(".dialog_ids").hide();
      $(".pop_cont_text").text("你确定要修改该兴趣吗？");
    }

    if(type==2){
      $(".pop_cont_input").hide();
      $(".pop_cont_text").text("你确定要删除该兴趣吗？");
    }

    $(".pop_bg").fadeIn();

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
      initDialog();
      type=-1;
    });
  }

  function deleteIfo(id) {
      //执行删除
      var arr={id:id};
      dataRequest(tasteDeleteUrl,arr,2);
  }

  function update(id) {
     //执行修改
     var label=$(".dialog_label").val();
     var arr={
        id:id,
        label:label
     };
     //执行更新
     dataRequest(tasteUpdateUrl,arr,3);
  }

  function insert() {
     //执行添加
     var addLabel=$(".dialog_label").val();
     var addUid=$(".dialog_id").val();
     var arr={
       label:addLabel,
       uid:addUid
     }
     dataRequest(tasteInsertUrl,arr,0);
  }

  //清空
  function initDialog() {
     $(".dialog_label").val("");
     $(".dialog_id").val("");
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
              showResult(data,arr,status,type);
         }
      });
    }

    function showResult(data,arr,status,type) {
      console.log(data);
      if(status=="success"){
        //操作成功
        if(type==0){
　　　　　　　//添加成功　　　　
              window.location.reload();
        }else if(type==1){
          //显示修改信息
          $(".dialog_label").val(data.label);
          showDialog(1,arr.id);
        }else if(type==2){
           //删除信息，刷新页面
             window.location.reload();
        }else if (type==3) {
            //执行更新成功
              window.location.reload();
        }
     }else{
       //操作失败
       showES("网络错误，请检测网络是否链接？！");
     }
    }


    function showES(msg) {
        $(".btm_btn").hide();
        $(".pop_cont_input").hide();
        $(".pop_cont_text").text(msg);
        $(".es_btn").click(function(){
          $(".pop_bg").fadeOut();
          window.location.reload();
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
    <li><a href="<%=projectPath%>/html/pageIndex.action?p=1&type=2&nType=6" target="_blank" class="website_icon">站点首页</a></li>
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

    <section>
      <div class="page_title">
        <h2 class="fl">兴趣管理</h2>
        <button type="button" class="fr top_rt_btn" onclick="addTaste()">添加兴趣</button>
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
                    <button type="button" class="link_btn" onclick="updateTaste(${tasteVo.id})">修改兴趣</button>
                    <a class="inner_btn" onclick="deleteTaste(${tasteVo.id})">删除信息</a>
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
            <aside class="paging">
            </aside>
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
          <span>兴趣标签内容：</span>
          <input type="text" class="dialog_label" name="dialog_label" placeholder="标签内容" class="textbox"/>
         </li>
         <li class="dialog_ids">
          <span >用户ID　：</span>
          <input type="text" class="dialog_id" name="dialog_id" placeholder="用户ID" class="textbox"/>
         </li>
        </ul>
       </div>
       <!--以pop_cont_text分界-->
       <div class="pop_cont_text">
        你确定添加改兴趣吗？
       </div>
       <!--bottom:operate->button-->
       <div class="btm_btn">
        <input type="button" value="确认" class="input_btn trueBtn"/>
        <input type="button" value="关闭" class="input_btn falseBtn"/>
       </div>
       <div class="btn_es">
        <input type="button" value="确认" class="input_btn link_btn es_btn"/>
       </div>

      </div>
     </section>

  </div>
</section>
</body>
</html>
