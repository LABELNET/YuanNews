package yuan.ssm.service.base;

import yuan.ssm.common.newsenum.ServiceEnum;
import yuan.ssm.pojo.CSCustom;

import java.util.List;

/**
 * ==================================================
 * <p/>
 * 版权：　软件工程.net12-1 原明卓
 * <p/>
 * 项目：　基于用户兴趣标签的新闻推荐系统
 * <p/>
 * 作者：　原明卓
 * <p/>
 * 版本：　1.0
 * <p/>
 * 创建日期：　16-4-26 下午11:00
 * <p/>
 * 功能描述： 用户端service基类
 *  共同的方法提取
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public interface ServiceBase<T> {

    /**
     * 查询分类和来源信息
     * @return
     * @throws Exception
     */
    CSCustom findCateSourceIfo() throws Exception;


    /**
     * 根据id查询
     * @param start 开始
     * @param num 数量
     * @param cs 条件/分类或来源
     * @return 数据
     * @throws Exception
     */
    List<T> findCustomById(Integer start, Integer num, String cs, ServiceEnum type) throws Exception;


    /**
     * 根据id查询
     * @param start 开始
     * @param num 数量
     * @param cs 条件/分类或来源
     * @return 数据
     * @throws Exception
     */
    List<T> findCustomByZan(Integer start,Integer num,String cs,ServiceEnum type) throws Exception;


    /**
     * 根据id查询
     * @param start 开始
     * @param num 数量
     * @param cs 条件/分类或来源
     * @return 数据
     * @throws Exception
     */
    List<T> findCustomByComment(Integer start,Integer num,String cs,ServiceEnum type) throws Exception;


    /**
     * 根据id查询
     * @param start 开始
     * @param num 数量
     * @param cs 条件/分类或来源
     * @return 数据
     * @throws Exception
     */
    List<T> findCustomByRnum(Integer start,Integer num,String cs,ServiceEnum type) throws Exception;

}
