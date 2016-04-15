package yuan.ssm.service.base;

import yuan.ssm.other.PageJo;

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
 * 创建日期：　16-4-15 下午11:05
 * <p/>
 * 功能描述： 基础类: 提供接口，为每个接口提供方法，减少代码量
 * 开始实施：　后台管理处理用户管理和兴趣管理没有使用，前者未能进行重构　　　　　　
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public interface ManagerBase<T> {


    /**
     * 分页查询数据
     * @param start　开始位置
     * @param num　数量
     * @return 数据列表
     * @throws Exception　
     */
    List<T> managerFindList(Integer start, Integer num) throws Exception;

    /**
     * 查询单条信息
     * @param id　查询的id
     * @return 单条数据
     * @throws Exception
     */
    T managerFindOne(Integer id) throws Exception;

    /**
     * 添加单条信息
     * @param t　添加的数据
     * @return 0,１
     * @throws Exception
     */
    Integer managerInsertOne(T t) throws Exception;

    /**
     * 修改单条信息
     * @param t　修改的数据
     * @return 0,1
     * @throws Exception
     */
    Integer managerUpdateOne(T t) throws Exception;

    /**
     * 删除单条信息
     * @param id　删除的信息id
     * @return
     * @throws Exception
     */
    Integer managerDeleteOne(Integer id) throws Exception;


    /**
     * 获得总数
     * @return
     * @throws Exception
     */
    PageJo managerFindCount() throws Exception;

}
