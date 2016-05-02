<%@ page import="yuan.ssm.vo.UserVo" %><%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-5-2
  Time: 下午4:47
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
    <title>新闻详情</title>
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
    <link rel='stylesheet' href="css/detail.css"/>
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
            $(".paginationpage").pagination({
                items: ${count},
                itemsOnPage: 10,
                page:10,
                hrefTextPrefix:"?p=",
                cssStyle: 'light-theme',
                prevText:"上一页",
                nextText:"下一页",
                currentPage:currentPage

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
                <a href="#" class="search"><b></b></a>
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
                <a href="<%=projectPath%>/html/pageIndex.action?p=1&type=2&nType=6">
                    关注标签
                </a>
            </li>
        </ul>
    </div>
</div>

<!--菜单　-->
<article>
    <div class="l_box f_l">

        <div class="content_top">
            <%--标题，来源，分类等--%>
            <h1>落马官员曾被评为全国劳模 国家给奖金都不要</h1>
            <hr>

                <label>时间：2016.05.02</label>　｜
                <label>分类：<a href="#">社会</a></label>　｜
                <label>来源：<a href="#">腾讯新闻</a></label>　｜
                <label>阅读(2016)</label>
        </div>

        <div class="content_center">
            <%--图片，新闻内容--%>
            <img src="http://himg2.huanqiu.com/attachment2010/2016/0502/20160502070914738.png"/>
            <p>
                2000年，陈明宪被任命为湖南省交通厅副厅长；2008年，被任命为交通厅党组书记。主政湖南交通系统期间，正是湖南高速公路迅猛发展之时。
                　　他先后主持了广东南海力江大桥、妹沙湘江北大桥、安徽铜陵长江大桥一南昌新八一大桥、南京长江第二大桥、岳阳洞庭湖大桥等一批大型、特大型桥梁的施工建设,26次获得国家和省部级科技成果奖和a项国家专利,荣获湖南省最高科技奖一一“光召科技奖”他以严格、科学的管理,营造了一支路桥建设铁军—“路侨湘军’,开创了省级地方队伍在长江中下游承建大型桥梁的先河,成为全国交通行业的佼佼者。
            </p>
            <hr>
        </div>

        <div class="content_bottom">
             <%--点赞--%>
             <div class="bottom_top">
                    <img src="<%=projectPath%>/image/icon/superzan.png" />
             </div>

            <div class="bottom_bottom">
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
                <img src="<%=projectPath%>/image/head/moren.png" />
            </div>

        </div>

        <div class="content_comment">
            <hr>
            <label>发表评论</label>
            <div class="comment_commit">
                 <textarea id="comment">
                 </textarea>
                <div class="commit">
                    发表评论
                </div>
            </div>

        </div>

        <div class="content_footer">
            <hr>
            <label>评论(2000)</label>
            <%--评论,分页--%>
            <div class="footer_item">
                  <img src="<%=projectPath%>/image/head/moren.png"/>
                  <span>LABELNET</span>
                  <p>制度害人，好人也会被诱骗蜕变成腐败分子，这些人就是铁证。不从制度改革入手堵塞产生腐败的根源，贪官只会“野火烧不尽，春风吹又生”。</p>

                  <hr>
            </div>
            <div class="footer_item">
                <img src="<%=projectPath%>/image/head/moren.png"/>
                <span>LABELNET</span>
                <p>制度害人，好人也会被诱骗蜕变成腐败分子，这些人就是铁证。不从制度改革入手堵塞产生腐败的根源，贪官只会“野火烧不尽，春风吹又生”。</p>

                <hr>
            </div>
            <div class="footer_item">
                <img src="<%=projectPath%>/image/head/moren.png"/>
                <span>LABELNET</span>
                <p>制度害人，好人也会被诱骗蜕变成腐败分子，这些人就是铁证。不从制度改革入手堵塞产生腐败的根源，贪官只会“野火烧不尽，春风吹又生”。</p>

                <hr>
            </div>
            <div class="footer_item">
                <img src="<%=projectPath%>/image/head/moren.png"/>
                <span>LABELNET</span>
                <p>制度害人，好人也会被诱骗蜕变成腐败分子，这些人就是铁证。不从制度改革入手堵塞产生腐败的根源，贪官只会“野火烧不尽，春风吹又生”。</p>

                <hr>
            </div>

            <div class="paginationpage"></div>

        </div>



    </div>
</article>



<footer>
    <p class="ft-copyright">copyright yuan.update 2016.05.02</p>
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
