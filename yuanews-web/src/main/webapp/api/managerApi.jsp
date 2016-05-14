<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 16-4-5
  Time: 下午12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String projectPath=request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>新闻推荐-后台管理系统</title>
  <meta name="author" content="DeathGhost" />
  <link rel="stylesheet" type="text/css" href="css/style.css"/>


</head>
<body>
<!--aside nav-->
<aside >
  <ul style="position: fixed;left: 70%;">
    <li>
      <dl>
        <dt>用户接口</dt>
        <dd><a href="#userrlogin">用户登陆</a></dd>
        <dd><a href="#userregister">用户注册</a></dd>
        <dd><a href="#updateUserIfo">修改信息</a></dd>
        <dd><a href="#updateUserHead">修改头像</a></dd>
        <dd><a href="#updateUserPass">修改密码</a></dd>
        <dd><a href="#addTasteLabel">添加兴趣</a></dd>
        <dd><a href="#allLabels">查询兴趣</a></dd>
        <dd><a href="#deleteLabel">删除兴趣</a></dd>
        <dd><a href="#getUserDetail">用户详情</a></dd>
        <dd><a href="#userZanNews">用户点赞</a></dd>
        <dd><a href="#userCommentNews">用户评论</a></dd>
      </dl>
    </li>
    <li>
      <dl>
        <dt>新闻接口</dt>
        <dd><a href="#getNesList">新闻列表</a></dd>
        <dd><a href="#getNesTuiList">推荐新闻</a></dd>
        <dd><a href="#getCateSources">分类和来源</a></dd>
        <dd><a href="#getNewsDetail">新闻详情</a></dd>
        <dd><a href="#getLikedHead">点赞列表</a></dd>
        <dd><a href="#getNewsComment">评论列表</a></dd>
        <dd><a href="#getNewsTaste">兴趣标签列表</a></dd>
        <dd><a href="#getLikedApiStatus">新闻的点赞状态</a></dd>
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
              code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
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
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
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
<!-- 修改用户信息：昵称，性别 -->
    <table id="updateUserIfo1" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>修改用户信息</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/updateUserIfo</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          uid  ： int 用户id , Y<br>
          nick : String 昵称 <br>
          sex :  int :0男，1女
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "msg": "修改成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
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

<!-- 修改用户头像 -->
    <table id="updateUserHead" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>修改用户头像</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/updateUserHead</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          uid  ： int 用户id , Y<br>
          multipart/form-data : 对象 Y <br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "msg": "头像修改成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/06 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>

<!-- 修改用户密码 -->
    <table id="updateUserPass" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>修改用户密码</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/updateUserPass</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          uid  ： int 用户id , Y<br>
          pass : String 密码，Y <br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "msg": "密码修改成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/06 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>


<!-- 添加兴趣标签 -->
    <table id="addTasteLabel" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>添加兴趣标签</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/addTasteLabel</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          uid  ： int 用户id , Y<br>
          label : String 标签 <br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "msg": "添加成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/06 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>


<!-- 查询用户所有兴趣 -->
    <table id="allLabels" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>查询用户所有兴趣</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/allLabels</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          uid  ： int 用户id , Y<br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": [<br>
          {<br>
          "id": 1,<br>
          "label": "新闻",<br>
          "uid": 1<br>
          },<br>
          {<br>
          "id": 2,<br>
          "label": "大街",<br>
          "uid": 1<br>
          },<br>
          {<br>
          "id": 3,<br>
          "label": "刘亦菲",<br>
          "uid": 1<br>
          }<br>
          ],<br>
          "msg": "成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>

        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/06 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>


<!-- 删除标签 -->
    <table id="deleteLabel" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>删除标签</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/deleteLabel</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          tid  ： int 兴趣 , Y<br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "msg": "删除成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>

        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/06 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>


<!-- 得到用户详情 -->
    <table id="getUserDetail" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>得到用户详情</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getUserDetail</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          uid  ： int 用户id , Y<br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": {<br>
          "head": "/image/head/moren.jpg",<br>
          "id": 1,<br>
          "nick": "旺旺",<br>
          "pass": "",<br>
          "sex": 0,<br>
          "status": 1,<br>
          "unum": "15036518579"<br>
          },<br>
          "msg": "成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
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


<!-- 用户点赞-->
    <table id="userZanNews" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>用户点赞</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/userZanNews</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          uid  ： int 用户id , Y<br>
          nid :  int 新闻id <br>
          status :  int :新闻的状态
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "msg": "已赞"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
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


<!-- 用户评论新闻 ：  -->
    <table id="userCommentNews" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>用户评论新闻</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/userCommentNews</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          uid  ： int 用户id , Y<br>
          nid : int 新闻id <br>
          content : String 评论内容
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "msg": "评论成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
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



<!-- 获取新闻列表 -->
    <table id="getNesList" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>获取新闻列表</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getNesList</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          1. p : 当前页；<br>
          2. num: 请求总数；<br>
          3. type : 操作类型：阅读量排序3，点赞排序4，评论排序5，正常请求2  <br>
          4. nType : 查询方式 ： 正常方式6,分类查询7，来源查询8  <br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": [<br>
          {<br>
          "ccont": "24小时",<br>
          "cid": 14,<br>
          "content": "这是新闻内容",
          <br> "dt": "2016-05-06 15:04",
          <br> "id": 842,
          <br> "img": "/image/huxiu/20160506151432908-e6d144d4-2d0f-40fe-a200-492d3a25d168.jpg",
          <br>"rnum": 0,
          <br>"scont": "虎嗅网",
          <br> "sid": 8,
          <br> "title": "中国游戏直播行业链报告：盈利模式、融资、投资逻辑、估值、品牌……-虎嗅网"
          <br>  },
          <br> {
          <br>"ccont": "24小时",
          <br> "cid": 14,
          <br> "cnum": 1,
          <br> "content": "这是新闻内容",
          <br>"dt": "2016-05-06 14:05",
          <br>"id": 841,
          <br> "img": "/image/huxiu/20160506144543195-2c470f80-e4c1-40c5-81e9-3386cde9199d.jpg",
          <br> "rnum": 5,
          <br> "scont": "虎嗅网",
          <br>"sid": 8,
          <br> "title": "在国内的呼风唤雨的BAT，为什么要做海外支付？-虎嗅网"
          <br> }
          <br>],
          <br>"msg": "成功"
          <br> }
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
          data/ccont : 分类内容<br>
          data/cid : 分类id<br>
          data/content : 新闻内容<br>
          data/dt :时间<br>
          data/img :新闻图片<br>
          data/rnum :阅读量<br>
          data/scont: 来源<br>
          data/sid :来源id<br>
          data/title :标题<br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>



<!-- 用户推荐新闻列表信息 -->
    <table id="getNesTuiList" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>用户推荐新闻列表信息</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getNesTuiList</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          *  p  : int 分页<br>
          *  num : int  数量<br>
          *  uid : int  用户id<br>
          *  type : int 类型 <br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": [<br>
          {<br>
          "ccont": "24小时",<br>
          "cid": 14,<br>
          "content": "这是新闻内容",
          <br> "dt": "2016-05-06 15:04",
          <br> "id": 842,
          <br> "img": "/image/huxiu/20160506151432908-e6d144d4-2d0f-40fe-a200-492d3a25d168.jpg",
          <br>"rnum": 0,
          <br>"scont": "虎嗅网",
          <br> "sid": 8,
          <br> "title": "中国游戏直播行业链报告：盈利模式、融资、投资逻辑、估值、品牌……-虎嗅网"
          <br>  },
          <br> {
          <br>"ccont": "24小时",
          <br> "cid": 14,
          <br> "cnum": 1,
          <br> "content": "这是新闻内容",
          <br>"dt": "2016-05-06 14:05",
          <br>"id": 841,
          <br> "img": "/image/huxiu/20160506144543195-2c470f80-e4c1-40c5-81e9-3386cde9199d.jpg",
          <br> "rnum": 5,
          <br> "scont": "虎嗅网",
          <br>"sid": 8,
          <br> "title": "在国内的呼风唤雨的BAT，为什么要做海外支付？-虎嗅网"
          <br> }
          <br>],
          <br>"msg": "成功"
          <br> }
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
          data/ccont : 分类内容<br>
          data/cid : 分类id<br>
          data/content : 新闻内容<br>
          data/dt :时间<br>
          data/img :新闻图片<br>
          data/rnum :阅读量<br>
          data/scont: 来源<br>
          data/sid :来源id<br>
          data/title :标题<br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>



<!-- 得到分类和来源信息 -->
    <table id="getCateSources" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>得到分类和来源信息</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getCateSources</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          无
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": {<br>
          "cateVos": [<br>
          {<br>
          "content": "24小时",<br>
          "id": 14<br>
          },<br>
          {<br>
          "content": "车与出行",<br>
          "id": 16<br>
          }<br>
          ],<br>
          "sourceVos": [<br>
          {<br>
          "id": 8,<br>
          "source": "虎嗅网"<br>
          },<br>
          {<br>
          "id": 9,<br>
          "source": "环球网"<br>
          }<br>
          ]<br>
          },<br>
          "msg": "成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
          data/cateVos 分类集合<br>
          data/cateVos/content :分类内容<br>
          data/cateVos/id :分类 id<br><br>
          data/sourceVos 来源集合<br>
          data/sourceVos/id :来源id<br>
          data/sourceVos/source : 来源信息<br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>


<!-- 新闻详细信息 -->
    <table id="getNewsDetail" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>新闻详细信息</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getNewsDetail</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          nid  ： int 新闻id , Y<br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": {<br>
          "ccont": "时局政治",<br>
          "cid": 21,<br>
          "cnum": 1,<br>
         "content": "这是新闻内容 ",
          <br> "dt": "2016-05-05 08:13:00",<br>
          "id": 400,<br>
          "img": "/image/huanqiu/ac76c027-c820-4c61-9809-8d5c3df0567a.jpg",<br>
          "rnum": 0,<br>
          "scont": "环球网",<br>
          "sid": 9,<br>
          "title": "安倍将与普京举行第13次会晤 美媒吐酸水：跟奥巴马才见7次",<br>
          "znum": 1<br>
          }, <br>
          "msg": "成功" <br>
          } <br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
          <br>
          data/ccont : 分类内容<br>
          data/cid : 分类id<br>
          data/content : 新闻内容<br>
          data/dt :时间<br>
          data/img :新闻图片<br>
          data/rnum :阅读量<br>
          data/scont: 来源<br>
          data/sid :来源id<br>
          data/title :标题<br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>



<!-- 查询点赞人信息 -->
    <table id="getLikedHead" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>查询点赞人信息</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getLikedHead</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          nid  ： int 新闻id , Y<br>
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {
          "code": 0,<br>
          "data": [<br>
          {<br>
          "head": "/image/head/moren.jpg",<br>
          "id": 4,<br>
          "nick": "zhuo1",<br>
          "status": 0<br>
          }<br>
          ],<br>
          "msg": "成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
          data/head/  : 用户头像<br>
          data/id :用户id<br>
          data/nick :昵称<br>
          data/status : 暂时没有<br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>


<!-- 分页查看新闻评论 -->
    <table id="getNewsComment" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>分页查看新闻评论</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getNewsComment</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          p  ： int 当前页面 Y<br>
          num : int 数量 <br>
          nid : int 新闻id
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": [<br>
          {<br>
          "content": "good !",<br>
          "head": "/image/head/moren.jpg",<br>
          "id": 5,<br>
          "nick": "旺旺",<br>
          "status": 0<br>
          }<br>
          ],<br>
          "msg": "成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
          data/content : 评论内容<br>
          data/head : 用户头像<br>
          data/id : 用户id<br>
          data/nick : 用户昵称<br>
          data/status : 暂时没有用<br>
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/06</b></td>
      </tr>
      </tfoot>
    </table>

    <table id="getNewsTaste" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>分页查看兴趣标签</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getNewsTaste</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          p  ： int 当前页面 Y<br>
          num : int 数量 <br>
          uid : int 用户id,没有的话，传0
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": [<br>
          "新闻",<br>
          "版本升级",<br>
          "刘亦菲",<br>
          "帮不帮我打",<br>
          "错错错的",<br>
          "vvv哈哈哈",<br>
          "哇后台⊙ω⊙"<br>
          ],<br>
          "msg": "成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
          data string 集合
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/13</b></td>
      </tr>
      </tfoot>
    </table>

    <table id="getLikedApiStatus" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>查询当前用户当前新闻的点赞状态</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getLikedApiStatus</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          nid  ： int 新闻id<br>
          uid : int 用户id
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          {<br>
          "code": 0,<br>
          "data": 2,<br>
          "msg": "成功"<br>
          }<br>
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
          data 点赞status
          注意： 由于分页加载，所以需要客户端自己进行去重操作使用Set集合
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/13</b></td>
      </tr>
      </tfoot>
    </table>

    <table id="getTuijianNotification" class="table center" style="margin-top:10px;text-align: left" >
      <thead>
      <th colspan="2"><h1>推荐新闻提醒通知</h1></th>
      </thead>
      <tbody>
      <tr>
        <td>接口地址 ：</td>
        <td>api/getTuijianNotification</td>
      </tr>
      <tr>
        <td>参数类型：</td>
        <td>
          uid : int 用户id
        </td>
      </tr>
      <tr>
        <td>返回数据：</td>
        <td>
          <br> {
          <br>"code": 0,
          <br> "data": {
          <br>"count": 292,
          <br> "newsCustom": {
          <br> "ccont": "24小时",
          <br> "cid": 14,
          <br> "cnum": 0,
          <br>"content": "美国被很多人视为灯塔，LendingClub（简写作LC）则被业界视为P2P乃至互联网金融行业的灯塔。最近关于LendingClub的新闻则很有冲击感。2200万美元贷款被违规出售给客户，联合创始人、首席执行官Renaud Laplanche辞职，股价两天内狂泄超过40%，高盛和投行Jefferies停止向LC购买贷款。 Lending Club联合创始人、前CEO Renaud Laplanche 这家大洋彼岸的明星互联网金融企业突然给人一种从天堂到地狱的感觉。然而复盘这起事件，可以发现美国的互联网金融生态有内涵值得中国互金行业学习，也有一些弊端值得中国同行引以为戒。 事件回顾 美国当地时间5月9日，LendingClub公告宣布联合创始人、首席执行官雷诺•拉普兰赫(Renaud Laplanche)以及三名高管辞职，原因是公司在最近的内部评估中发现有2200万美元贷款违规出售给客户投行Jefferies。 LendingClub曾对这笔 2200 万美元的次优贷款进行过调查。结果显示，贷款规格与投资者的“要求”不符。董事会还发现，公司内部某些人明知贷款不符合投资人的标准，且公司修改了其中300万美元贷款的申请日期，使其符合要求。 受该消息影响，LendingClub股价当日狂跌近35%。当地时间10日开盘后，LendingClub继续暴跌，跌幅超过10%，收盘报4.10美元。而这与2014年上市时的股价相比已经下跌了80%以上。5月11日收盘，股价又小幅下跌至4.08美元。 LendingClub股价走势（截图来自新浪财经） 值得注意的是，LendingClub刚刚发布了超出市场预期的2016Q1财报，截止今年3月31日，LendingClub本季度交易额达到27.5亿美元，同比增长68%。迄今为止，LendingClub已经完成190亿美元的贷款发放量。LendingClub第一季度的营收为1.51亿美元，与去年同期相比增加了87%。，第一季度实现扭亏为盈，净利润达到了410万美元。而去年同期净利润则亏损640万美元。 在利好的财报公布后，股价依然狂跌，足见该事件对投资者信心影响之大。 此次事件表明LendingClub出了哪些问题？ 第一，内控出现一定问题，一笔2200万美元的贷款被违规出售给客户，而这笔资产并不符合客户的要求。有关这笔贷款问题的细节仍有待披露。可以确定的是，这项操作违反了投资者意愿，甚至有可能给客户带来损失，也违背了公司的管理制度。但从公司CEO到具体负责该事务的高管都没有制止这样的行为，甚至可能参与了这种行为。已经披露的资料显示公司相关人员修改了其中300万美元贷款的申请日期，使其符合客户的购买要求。违反公司制度的事件没有被制止，显然内控出现问题。 风控是金融企业的核心，风控不仅是对资产质量的控制，对信用风险的控制，也应包含对公司制度被破坏给公司带来损失的可能性的把控，也就是对公司内控的管理。LendingClub此次内控的失误，实际也是公司风控出了一定问题。 对于互联网金融行业而言，不仅需要关注信用风险，还需要关注人员操作风险，防止制度被破坏而没能及时发现，防止监守自盗，防止员工利益输送等行为，健全内控制度，实施更全面的风险管理。目前的中国互金行业还在忙于资产端与资金端的竞争，对于更精细化的企业内控可能无暇顾及。LendingClub的失误给业界敲响了警钟，这样的事件出现后对投资人信心会有比较大的负面影响。 第二，凸显了上市后的LendingClub正在逐步远离初心，在发展质量与发展速度上出现摇摆，无法兼顾。从创立以来，LendingClub一直只提供个人贷款，践行“谨慎增长”的思路，宁愿发展得慢一些，也要重视“安全，风险管理、合规和内控，一旦增长过快，就会违背这些原则”。 但不可忽视的是，仅靠个人贷款业务很难实现资产规模的快速做大，毕竟相比于to B的业务，靠to C业务增长将交易规模达到一定量级需要更多时间。尤其是在个人消费金融服务非常完善的美国，拓展个人贷款业务更有我们想象不到的困难。 而上市后的LendingClub又要面对资本的期待，企业本身也难以抑制做大的冲动。于是LendingClub开始尝试机构业务。同时也在探索通过资产证券化加快资产流转的速度，以图实现更大规模的交易量级。此次向投行Jefferies出售的2200万美元贷款实际上也是资产证券化产品。而有消息称，本月早些时候，Jefferies试图从LendingClub购买1.5亿美元贷款，并将其打包为债券卖给投资者。 本次内控出问题，本质上还是公司加速资产周转、做大交易规模、实现快速发展的意愿在驱使。 当然，成为一家快公司还是慢公司没有对错之分。重要的是在战略思路与运营风格发生变化的过程中要保持稳健，思路统一。LendingClub在这方面出了一定问题。 LendingClub有哪些值得我们学习和敬畏 LendingClub一直是中国互联网金融行业学习的对象，这次负面事件的发生对其市场形象打击比较大，但我们没必要幸灾乐祸，在商业环境更加恶劣、跑路、诈骗新闻不断的中国互联网金融领域，确实也没有幸灾乐祸的资本。实际上复盘事件我们可以发现，LendingClub以及美国的商业环境有些元素值得我们学习和敬畏。 首先，此次事件凸显了LendingClub比较完善的公司治理。雷诺•拉普兰赫(Renaud Laplanche)是LendingClub董事长、联合创始人兼CEO，在该事件发生后不得不以辞职的方式对事件负责，以图部分消除其负面影响。这实际上体现了比较成熟的公司治理，即实现了比较成熟的权力制衡，避免了创始人兼高管把控公司的局面，这对于一家互联网金融企业的长远、健康发展其实是有很大的保障的。 我国频现的P2P平台跑路，本质上就是这样的平台缺乏必要的公司治理，创始及运营团队完全把控公司，缺乏必要的制衡，投资人利益也就无法保障。 互联网金融企业如果要长远发展就需要构建对于投资人的信任体系，从创立伊始就建立起成熟的公司治理是一个基础性工作。LendingClub此次出了该事件，表明公司存在一定问题，但不会有人认为LendingClub要倒掉，实际上是良好的公司治理起了基础性作用。 其次，这次事件表明公司具体的内控体系有问题，但问题并非系统性的，而是细节没有做到完美。应当看到本次公司内控出问题不是外界发现的，而是公司内部审查时发现，并主动公布。这表明公司内控不存在实质性问题。出现问题还不算可怕，可怕的是有问题无法发现，甚至默认，这才是一个企业走向衰亡的征兆。 另外，LendingClub的善后处理与危机公关值得认可。公司主动承认了内部的问题，并向客户投行Jefferies回购了问题资产。LendingClub表示， 2200万美元贷款所带来的金融影响并不大，但此举违反了商业准则以及信息披露滞后令公司无法容忍。公司的关键原则是维持与借贷人、投资人、监管者、股东以及员工之间最高程度的信任。 这种做法和表态可以在最大程度上挽回投资者与客户信任。相比于隐瞒事件真相，LendingClub的做法可以树立一种负责、透明的市场形象，这对于企业长远发展势必有所帮助。 *文章为作者独立观点，不代表虎嗅网立场 本文由 网事风云 授权 虎嗅网 发表，并经虎嗅网编辑。转载此文请于文首标明作者姓名，保持文章完整性（包括虎嗅注及其余作者身份信息），并请附上出处（虎嗅网）及本页链接。原文链接：http://www.huxiu.com/article/148410/1.html 未按照规范转载者，虎嗅保留追究相应责任的权利 关注微信公众号虎嗅网（huxiu_com），定时推送，福利互动精彩多",
          <br> "dt": "2016-05-12 12:16",
          <br> "id": 1640,
          <br> "img": "/image/huxiu/20160512175024330-509d62d6-15b3-48ea-ab50-5b3530d18db9.jpg",
          <br> "rnum": 0,
          <br> "scont": "虎嗅网",
          <br>"sid": 8,
          <br> "title": "LendingClub股价大跌，给中国互金行业怎样的启示？-虎嗅网",
          <br> "znum": 0
          <br>  }
          <br>  },
          <br> "msg": "成功"
          <br> }
        </td>
      </tr>
      <tr>
        <td>数据解释 ：</td>
        <td>
          code :响应码 0,成功;-1失败;-2：其他；-3 系统错误；<br>
          msg  :响应信息<br>
          <br>
          data/count ： 推荐新闻总数<br>
          data/newsCustom :第一条推荐新闻信息
        </td>
      </tr>
      </tbody>
      <tfoot>
      <tr>
        <td colspan="2"><b>create by yuan on 2016/05/05 ;  update by yuan on 2016/05/14</b></td>
      </tr>
      </tfoot>
    </table>

  </div>
</section>
</body>
</html>
