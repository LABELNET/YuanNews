package yuan.ssm.dao.customer;

import org.apache.ibatis.annotations.Param;
import yuan.ssm.vo.TasteVo;
import yuan.ssm.vo.UserVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 用户端　－　mapper接口
 */
public interface UserMapper {

    /**
     * 用户登陆策略：
     * 1.查询账户是否存在
     * 2.根据账户查询密码是否正确
     * 3.返回不同的状态
     */


    /**
     * 1.查询账户： 存在集合size大于0，且不为null
     * 登陆/注册
     * @param unum 账户
     * @return id
     * @throws Exception
     */
    Integer CheckUserUnum(@Param("unum") String unum) throws Exception;

    /**
     * 2.根据账户和密码查询用户信息
     *
     * @param unum 账户
     * @param pass 密码
     * @return
     * @throws Exception
     */
    UserVo loginCheckPass(@Param("unum") String unum,@Param("pass") String pass) throws Exception;




    /**
     * 用户注册策略：
     * 1.判断账户是否存在
     * 2.注册到数据库
     * 3.保存用户信息session（控制器实现）
     */

    /**
     * 2.注册用户信息
     * @param unum 用户账户
     * @param pass 密码
     * @param nick 昵称
     * @return 修改行数
     * @throws Exception
     */
    Integer registerUser(@Param("unum") String unum,@Param("pass") String pass,@Param("nick") String nick,@Param("head") String head) throws Exception;


    //----------------------------------------兴趣标签操作--------------------------------

    /**
     * 用户兴趣标签策略：
     * 0.添加的时候，判断用户是否已经存在该用户兴趣标签
     * 1.添加兴趣标签,每个人最多可以添加30个兴趣标签，所以客户端需要做判断
     * 2.读取所有的兴趣标签
     * 3.查询当前用户的兴趣标签个数
     * TODO 4.根据用户的兴趣标签，给用户推荐的兴趣标签，插入到新闻列表中（后期）
     * 5.分页查询兴趣标签，需要用户浏览选择；
     */


    /**
     * 查询用户的兴趣标签是否已经存在 ,id>0，存在
     * @param label 标签
     * @param id 用户id
     * @return 兴趣id
     * @throws Exception
     */
    Integer userCheckTaste(@Param("label") String label,@Param("id") Integer id) throws Exception;

    /**
     * 添加用户兴趣标签
     * @param label 兴趣标签
     * @param id 用户id
     * @return
     */
    Integer userAddTasteLabel(@Param("label") String label,@Param("id") Integer id) throws Exception;


    /**
     * 查询用户的兴趣标签总数
     * @param id 用户id
     * @return 标签总数
     * @throws Exception
     */
    Integer userSelectTasteCount(@Param("id") Integer id) throws Exception;


    /**
     * 查询用户的所有兴趣标签
     * @param id 用户id
     * @return 用户所有的兴趣标签
     * @throws Exception
     */
    List<TasteVo> userSelectTasteById(@Param("id") Integer id) throws Exception;


    /**
     * 分页查询兴趣标签 ,id倒序输出
     * @param state 开始
     * @param num 总数
     * @return 当前页面的兴趣标签内容
     */
    List<TasteVo> selectTaste(@Param("start") Integer state , @Param("num") Integer num) throws Exception;


    /**
     * 用户删除兴趣标签
     * @param tid
     * @return
     * @throws Exception
     */
    Integer userDeleteTaste(@Param("tid") Integer tid) throws Exception;

    //---------------------------------------- 点赞操作--------------------------------------------

    /**
     * 点赞策略：
     * 1.用户点赞修改状态，第一次为点赞，第二次为超赞;客户端进行判断type是什么点赞
     * 2.根据id,查询当前点赞状态
     * 3.TODO 根据用户id ,可以查询到用户的浏览记录 新闻id
     */

    /**
     * 点赞-添加点赞信息
     * @param uid 用户id
     * @param nid 新闻id
     * @return 操作行
     * @throws Exception
     */
    Integer userNewsZan(@Param("uid") Integer uid,@Param("nid") Integer nid) throws Exception;


    /**
     * 第二次点赞 - 直接根据
     * @param uid 用户id
     * @param nid 新闻id
     * @return 影响行
     * @throws Exception
     */
    Integer userNewsSuperZan(@Param("uid") Integer uid,@Param("nid") Integer nid) throws Exception;




    //---------------------------------------- 评论操作--------------------------------------------

    /**
     * 用户评论策略：
     * 1.用户评论 , 评论字数限制200;
     * 2.TODO 根据用户id 可以查询到用户评论的新闻信息
     */
    Integer userNewsComment(@Param("uid") Integer uid,@Param("nid") Integer nid,@Param("content") String content) throws Exception;

}
