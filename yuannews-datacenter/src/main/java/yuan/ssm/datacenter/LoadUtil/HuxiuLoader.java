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

    /**
     * 注意，在进行返回url的时候，需求去重复的url，防止多余的爬虫和数据
     * @return
     */
    protected Set<String> getUrls() {
        //调式urls本地存储方式
//        Set<String> stringSet = cleanUrls(ParseIndex.getHuXiuPageUrls(super.getDoc()), SourceEnum.huxiu.toString());
//        LoggerUtil.printJSON(stringSet);
//        return null;
        return cleanUrls(ParseIndex.getHuXiuPageUrls(super.getDoc()),SourceEnum.huxiu.toString());
    }

    protected SourceEnum getType() {
        return SourceEnum.huxiu;
    }
}
