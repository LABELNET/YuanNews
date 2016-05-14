package yuan.ssm.other;

import yuan.ssm.pojo.NewsCustom;

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
 * 创建日期：　16-5-14 上午10:13
 * <p/>
 * 功能描述： 推荐新闻Model
 * 包括：
 *  1.推荐新闻总数；
 *  2.一天新闻信息；
 *  3.可拓展性高；
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class TuijianModel {

    private Integer count;

    private NewsCustom newsCustom;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public NewsCustom getNewsCustom() {
        return newsCustom;
    }

    public void setNewsCustom(NewsCustom newsCustom) {
        this.newsCustom = newsCustom;
    }
}
