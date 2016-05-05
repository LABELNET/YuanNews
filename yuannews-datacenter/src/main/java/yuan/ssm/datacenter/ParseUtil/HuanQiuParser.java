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
 * 创建日期：　16-5-4 上午9:57
 * <p/>
 * 功能描述：  环球网新闻解析类
 *
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuanQiuParser extends ParserBase{

    public HuanQiuParser(InputStream inputStream, String url) {
        super(inputStream, url);
    }

    protected NewsVo parserDetailPage() {
        //解析详情页，稍后完成

        return null;
    }

    protected SourceEnum getType() {
        return SourceEnum.huanqiu;
    }
}
