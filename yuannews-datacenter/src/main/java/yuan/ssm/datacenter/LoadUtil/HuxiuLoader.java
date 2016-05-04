package yuan.ssm.datacenter.LoadUtil;

import yuan.ssm.datacenter.base.LoaderBase;
import yuan.ssm.datacenter.base.SourceEnum;

import java.util.ArrayList;
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
 * 创建日期：　16-5-4 下午2:03
 * <p/>
 * 功能描述： TODO
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuxiuLoader extends LoaderBase{



    protected List<String> getUrls() {
        List<String> urls=new ArrayList<String>();
        urls.add("http://www.huxiu.com/article/147523/1.html");
        urls.add("http://www.huxiu.com/article/147512/1.html");
        urls.add("http://www.huxiu.com/article/147525/1.html");
        urls.add("http://www.huxiu.com/article/147470/1.html");
        urls.add("http://www.huxiu.com/article/147509/1.html");
        return null;
    }

    protected SourceEnum getType() {
        return SourceEnum.huxiu;
    }
}
