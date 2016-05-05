package yuan.ssm.datacenter.common;

import yuan.ssm.datacenter.base.SourceEnum;

import java.util.HashMap;
import java.util.Map;

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
public class CSCommon {

    private static Map<String,Integer> cates=new HashMap<String, Integer>();

    static {
        cates.put("24小时",14);
        cates.put("车与出行",16);
        cates.put("娱乐淘金",17);
        cates.put("创业维艰",18);
        cates.put("生活腔调",19);
        cates.put("社会百科",20);
    }

    /**
     * 得到来源信息
     * @param word
     * @return
     */
    public static int getSourceId(SourceEnum word){
        switch (word){
            case huxiu:
                return 8;
            case huanqiu:
                return 9;
            default:
                return 0;
        }
    }

    //得到分类信息
    public static int getCateId(String cate){
        Integer cateId=cates.get(cate);
        if(cateId==null){
            return 20; //默认分类为社会百科
        }
        return cateId;
    }

}
