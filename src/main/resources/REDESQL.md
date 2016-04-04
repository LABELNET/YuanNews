#记录sql语句


#2016.04.04
　评论表的查询sql :
 ```
     SELECT c.id as id,
                 c.content AS content,
                 c.uid AS uid,
                 c.nid AS nid,
                 u.nick AS nick,
                 u.head AS head,
                 n.title AS title
          FROM
                 comment AS c,
                 user AS u ,
                 news AS n
          WHERE
                c.uid=u.id
          AND
                c.nid=n.id
          AND
                c.id=#{0}
          AND
                c.status=0
 ```

#2016.04.03 数据库总结第一版
 总共7个表 ：
  * user 用户表
  * taste 兴趣表
  * cate 分类表
  * source 新闻来源表
  * news 新闻表
  * liked 点赞表
  * comment 评论表

#用户sql
  * 根据用户id查询用户信息
   ```
     select * from user WHERE id=1

   ```

  * 从0开始获取2条记录，并通过id排序后倒序输出
   ```
   select * from user order by id desc limit 0,2;

   ```

  * 修改某个用户的状态
   ```
   update user set status=1 where id=1;

   ```

  * 修改的sql
   ```
     update user set head='/imgage/type.jpg' where id=1;
     update user set pass=111111 where id = 1;
     update user set sex=1 where id=1;

   ```

  * 多条件查询
   ```
    SELECT id,unum,head,nick,sex,status from user where unum='150365186579' AND pass='123456';
   ```


#类别sql
#兴趣sql
#新闻sql