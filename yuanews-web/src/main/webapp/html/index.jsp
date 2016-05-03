<%@ page import="yuan.ssm.vo.UserVo" %><%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-5-1
  Time: 下午2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<% UserVo userVo= (UserVo) session.getAttribute("user"); %>
<%  String projectPath=request.getContextPath(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>新闻推荐-<c:out value="${title}"/></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=1200" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <link href="css/global-base.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <link rel="stylesheet" type="text/css" href="css/nalbase.css">
    <link rel="Stylesheet" type="text/css" href="css/DialogBySHF.css" />
    <link rel='stylesheet' href="css/nprogress.css"/>
    <script src="js/nprogress.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/sliders.js"></script>
    <!--[if lt IE 9]>
    <script src="js/modernizr.js"></script>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <link href="css/iefixed.css" rel="stylesheet" type="text/css" />
    <![endif]-->
    <script type="text/javascript" src="js/vivo-common.js"></script>
    <script type="text/javascript" src="js/prefixfree.min.js"></script>
    <script type="text/javascript" src="js/DialogBySHF.js"></script>

    <!-- 分页插件－simplePagination -->
    <link  rel="stylesheet" type="text/css" href="css/simplePagination.css" />
    <script src="js/simplePagination.js"></script>

    <script type="text/javascript">
        //分页实现：　itemsOnPage 当前页面的item总数
        $(function() {
            $("#paginationpage").pagination({
                items: ${count},
                itemsOnPage: 9,
                page:10,
                hrefTextPrefix:"?p=",
                cssStyle: 'light-theme',
                prevText:"上一页",
                nextText:"下一页",
                currentPage:${currectIndex}

            });
        });

    </script>



</head>
<body class="products">
<!--header 开始-->
<div id="vivo-airbox"></div>
<div id="vivo-wrap">
    <div id="vivo-head">
        <div class="vivo-search">
            <div class="search-box">
                <form action='＃' method='get' style="background:#19a97b">
                    <input type="text" placeholder="随便输入哦" name='q' style="height:40px;font-size:18px;" autocomplete="off">
                    <button style="background:#800080;margin-left:15px;">搜索</button><a class="close"></a>
                </form>
                <div class="qk-results">
                    <ul>
                    </ul>
                    <div class="other-results"><a href="#">其他搜索结果</a></div>
                </div>
            </div>
        </div>
        <div class="vivo-nav cl">
            <a style="float:left;margin-left:12%;" href="<%=projectPath%>/html/pageIndex.action?p=1&type=2&nType=6"><img style="width:120px;margin:5px;" src="images/logo.png"></a>
            <div class="search-user">
                <%--<a href="#" class="search"><b></b></a>--%>
                <%
                  if(userVo==null){

                %>
                <a href="javascript:void(0)" class="user" onclick="btnDialog(0)"><b></b></a>
                <%
                    }else{
                %>
                   <img src="<%=userVo.getHead()%>" id="indexuser" style="" onclick="btnDialog(1)"/>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>
<div id="vivo-contain"></div>
</div>
<!--header 结束-->
<!--菜单　开始-->
<div class="r_box f_r">
    <div class="nav">
        <ul>
            <li>
                <a href="<%=projectPath%>/html/pageIndex.action?p=1&type=2&nType=6">
                    新闻推荐首页
                </a>
            </li>
            <c:if test="${!empty sourceIfo.cateVos}">
                <c:forEach var="cate" items="${sourceIfo.cateVos}">
                    <li>
                        <a href="<%=projectPath%>/html/pageIndex.action?p=1&title=${cate.content}&type=2&nType=7">
                        <c:out value="${cate.content}"/>
                        </a>
                    </li>
                </c:forEach>
            </c:if>

            <c:if test="${!empty sourceIfo.sourceVos}">
                <c:forEach var="s" items="${sourceIfo.sourceVos}">
                    <li>
                        <a href="<%=projectPath%>/html/pageIndex.action?p=1&title=${s.source}&type=2&nType=8">
                            <c:out value="${s.source}"/>
                        </a>
                    </li>
                </c:forEach>
            </c:if>
            <li>
                <a style="color: purple;" href="<%=projectPath%>/html/userLabelPage.action?p=1">
                    关注标签
                </a>
            </li>
        </ul>
    </div>
</div>

<!--菜单　-->
<article>
    <div class="l_box f_l">

        <div class="topnews">
            <h2>
                <span>
                    <a href="<%=projectPath%>/html/pageIndex.action?p=1&title=${title}&type=4&nType=${ntype}">点赞</a> |
                    <a href="<%=projectPath%>/html/pageIndex.action?p=1&title=${title}&type=3&nType=${ntype}">热度</a> |
                    <a href="<%=projectPath%>/html/pageIndex.action?p=1&title=${title}&type=5&nType=${ntype}">评论</a>
                </span><b>新闻推荐网页版</b></h2>

           <c:if test="${empty customs}" >
            <div class="blogs">
                没有更多数据
            </div>
           </c:if>
           <c:if test="${!empty customs}">
               <c:forEach var="custom" items="${customs}">
                   <div class="blogs">
                       <figure><img src="${custom.img}"></figure>
                       <ul>
                           <h3><a href="<%=projectPath%>/html/newsDetailPage.action?p=1&nid=${custom.id}">${custom.title}</a></h3>
                           <p>ͨ

                             ${fn:substring(custom.content,0,90)}...

                           <p class="autor">
                               <span class="lm f_l">
                                    <a href="<%=projectPath%>/html/pageIndex.action?p=1&title=${custom.ccont}&type=2&nType=7">
                                        <c:out value="${custom.ccont}"/>
                                    </a>
                                   <c:if test="${!empty custom.scont}">
                                         ,
                                       <a href="<%=projectPath%>/html/pageIndex.action?p=1&title=${custom.scont}&type=2&nType=8">
                                           <c:out value="${custom.scont}"/>
                                       </a>
                                   </c:if>
                               </span>
                               <span class="dtime f_l">${custom.dt}</span>
                               <span class="viewnum f_r">阅读(${custom.rnum})</span>
                               <span class="pingl f_r">评论(${custom.cnum==null?0:custom.cnum})</span>
                               <c:if test="${type==4}">
                                   <span>赞(${custom.znum==null?0:custom.znum})</span>
                               </c:if>
                           </p>

                       </ul>
                   </div>

               </c:forEach>
           </c:if>

        </div>
        <div class="r_box f_r">
            <!--tit01 end-->
            <c:if test="${!empty customs}">
                <c:if test="${fn:length(customs)>10}">
                        <div id="paginationpage" style="float: right"></div>
                </c:if>
            </c:if>
            <!--r_box end -->
        </div>
    </div>
</article>



<footer>
    <p class="ft-copyright">copyright yuan.update 2016.04.19</p>
    <div id="tbox"> <a id="togbook" href="/"></a> <a id="gotop" href="javascript:void(0)"></a> </div>
</footer>
<!--菜单点击效果-->
<script type="text/javascript" src="js/nalbase.js"></script>
<script type="text/javascript">

    var loginUrl="<%=projectPath%>/html/login/userLoginPage.action";
    var userDetalUrl="<%=projectPath%>/html/login/userDetail.action";

    function btnDialog(type) {
        if(type==0) {
            showDialog(loginUrl);
        }else{
            showDialog(userDetalUrl);
        }
    }
    
    function showDialog(url) {
        $.DialogBySHF.Dialog({
            Width: 1024,
            Height: 500,
            Title: "个人中心",
            URL: url
        });
    }

    window.onload=function() {
        $('body').show();
        NProgress.start();
        setTimeout(function() { NProgress.done(); $('.fade').removeClass('out'); }, 1000);
    }

    function doneIt() {
        NProgress.done();
    }

</script>
</body>
</html>
