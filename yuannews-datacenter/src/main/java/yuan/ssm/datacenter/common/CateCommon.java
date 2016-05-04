package yuan.ssm.datacenter.common;

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
 * 创建日期：　16-5-4 下午4:02
 * <p/>
 * 功能描述： 分类工具类
 * 1.虎嗅
 * 2.环球
 * 3.
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class CateCommon {

    public static int getCateId(String word){

        //虎嗅
        if(UrlsContanst.HUXIU_BASE_URL.contains(word)){
            return 1;
        }

        //环球
        return 0;
    }

}
