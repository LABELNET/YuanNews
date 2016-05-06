package yuan.ssm.datacenter.ParseUtil;

import yuan.ssm.datacenter.base.ParserBase;
import yuan.ssm.datacenter.base.SourceEnum;
import yuan.ssm.vo.NewsVo;

import java.io.InputStream;

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
 * 创建日期：　16-5-6 上午10:37
 * <p/>
 * 功能描述： ChinaNews详情页解析类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class ChinaNewsParser extends ParserBase{


    public ChinaNewsParser(InputStream inputStream, String url) {
        super(inputStream, url);
    }

    protected NewsVo parserDetailPage() {
        return null;
    }

    protected SourceEnum getType() {
        return null;
    }
}
