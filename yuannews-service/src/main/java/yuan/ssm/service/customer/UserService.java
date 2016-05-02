package yuan.ssm.service.customer;

import yuan.ssm.other.CommentJo;
import yuan.ssm.pojo.NewsCustom;
import yuan.ssm.vo.TasteVo;
import yuan.ssm.vo.UserVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层－用户端－用户服务接口
 */
public interface UserService {

    /**
     * 用户接口策略 ：
     * 1.登陆：判断账号是否存在，后登陆查询    ---（判断账号存不存在可以在拦截器中实现）
     * 2.注册：判断账号是否存在，后做注册
     * 3.关注兴趣标签：判断是否已经存在(客户端进行判断)，判断总数是否超过30个（客户端做判断）
     * 4.查询用户的所有兴趣标签
     * ---
     * 5.分页查询兴趣页面--单独的页面
     *
     * 6.点赞,根据当前状态进行判断需要操作的类型；
     *   （0,添加点赞信息，为赞）
     *   （1,修改状态为2，为超赞）
     *
     * 7.用户评论
     *
     */

    /**
     * 判断账号是否存在
     * @param unum　账号
     * @return
     * @throws Exception
     */
    boolean isCheckUnum(String unum) throws Exception;

    /**
     * 用户登陆
     * @param unum　账号
     * @param pass　密码
     * @return 用户信息
     * @throws Exception
     */
    UserVo userLogin(String unum,String pass) throws Exception;


    /**
     * 用户注册
     * @param unum　账号
     * @param pass　密码
     * @param nick　昵称
     * @return 影响行数
     * @throws Exception
     */
    Integer userRegister(String unum,String pass,String nick) throws Exception;


    /**
     * 检查用户标签是否存在
     * @param label
     * @param id 用户id
     * @return
     * @throws Exception
     */
    boolean userCheckTaste(String label,Integer id) throws Exception;

    /**
     * 添加用户标签
     * @param label
     * @param id 用户id
     * @return
     * @throws Exception
     */
    Integer userAddTasteLabel(String label,Integer id) throws Exception;

    /**
     * 查询用户标签总数
     * @param id　用户id
     * @return
     * @throws Exception
     */
    Integer userSelectTasteCount(Integer id) throws Exception;


    /**
     * 查询用户所有的兴趣标签
     * @param id　用户id
     * @return 兴趣标签s
     * @throws Exception
     */
    List<TasteVo> userSelectTasteById(Integer id) throws Exception;


    /**
     * 用户取消兴趣标签删除
     * @param tid
     * @return
     * @throws Exception
     */
    Integer userDeleteTasteById(Integer tid) throws Exception;


    /**
     * 分页查询所有的兴趣标签
     * @param start
     * @param num
     * @return
     * @throws Exception
     */
    List<TasteVo> selectTaste(Integer start,Integer num) throws Exception;


    /**
     *　用户点赞操作
     * @param uid 　用户id
     * @param nid 新闻id
     * @param status 当前状态
     * @return 影响行数
     * @throws Exception
     */
    Integer userZanNews(Integer uid,Integer nid,Integer status) throws Exception;

    /**
     * 用户评论
     * @param uid　用户id
     * @param nid 新闻id
     * @param content 评论内容
     * @return 影响行数
     * @throws Exception
     */
    Integer userCommentNews(Integer uid,Integer nid,String content) throws Exception;

    /**
     * 根据新闻id查询新闻
     * @param nid 新闻id
     * @return
     * @throws Exception
     */
    NewsCustom selectNewsDetailById(Integer nid) throws Exception;

    /**
     * 根据新闻id，查询点赞人的头像
     * @param nid 新闻id
     * @return
     * @throws Exception
     */
    List<String> selectLikedByNid(Integer nid) throws Exception;


    /**
     * 根据新闻id，分页查询评论信息
     * @param start 开始
     * @param num 数量
     * @param nid 新闻id
     * @return
     * @throws Exception
     */
    List<CommentJo> selectComments(Integer start,Integer num,Integer nid) throws Exception;

    /**
     * 点赞状态获取
     * @param uid
     * @param nid
     * @return
     * @throws Exception
     */
    Integer selectZanStatus(Integer uid,Integer nid) throws Exception;

}
