package yuan.ssm.pojo;

import yuan.ssm.vo.NewsVo;

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
 * 创建日期：　16-4-13 下午3:53
 * <p/>
 * 功能描述： 新闻item实体类
 * <p>
 * <p/>
 * 功能更新历史：
 * 客户端：主界面新闻展示的数据 包括阅读数量,分类信息,新闻信息
 * <p>
 * ==================================================
 */
public class NewsCustom extends NewsVo{

     private Integer cnum;//评论总数

     private String ccont;//分类信息

     private Integer znum;//点赞总数

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public String getCcont() {
        return ccont;
    }

    public void setCcont(String ccont) {
        this.ccont = ccont;
    }

    public Integer getZnum() {
        return znum;
    }

    public void setZnum(Integer znum) {
        this.znum = znum;
    }
}
