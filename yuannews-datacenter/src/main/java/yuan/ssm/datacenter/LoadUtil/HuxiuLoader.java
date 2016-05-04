package yuan.ssm.datacenter.LoadUtil;

import yuan.ssm.datacenter.ParseUtil.ParseIndex;
import yuan.ssm.datacenter.base.LoaderBase;
import yuan.ssm.datacenter.base.SourceEnum;

import java.util.Set;

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
 * 功能描述： 虎嗅数据加载
 * 1.使用
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuxiuLoader extends LoaderBase{


    public HuxiuLoader(String url) {
        super(url);
    }

    protected Set<String> getUrls() {
        return ParseIndex.getHuXiuPageUrls(super.getDoc());
    }

    protected SourceEnum getType() {
        return SourceEnum.huxiu;
    }
}
