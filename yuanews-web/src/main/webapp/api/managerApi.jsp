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

  </div>
</section>
</body>
</html>
