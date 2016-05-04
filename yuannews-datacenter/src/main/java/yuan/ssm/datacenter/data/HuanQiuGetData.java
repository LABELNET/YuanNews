package yuan.ssm.datacenter.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.vo.NewsVo;

import java.io.IOException;

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
 * 创建日期：　16-5-4 上午9:52
 * <p/>
 * 功能描述：环球网新闻爬去数据执行类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuanQiuGetData implements Runnable{


    //默认值
    private final String NO_URL=" NO ";

    //详情页url
    private String detailUrl=NO_URL;

    public HuanQiuGetData(String detailUrl) {
        this.detailUrl=detailUrl;
        new Thread(this,"百度新闻详情： "+detailUrl).start();
    }

    public void run() {
        NewsVo newsVo = loadDetailToMysql();
        if(newsVo!=null){
            //执行存储
        }
    }

    /**
     * 执行加载详情和存储到mysql操作
     */
    private NewsVo loadDetailToMysql(){
        if(NO_URL.equals(detailUrl)){
            LoggerUtil.printJSON("没有URL");
            return null;
        }
        try {
            Document document = Jsoup.connect(detailUrl).timeout(100000).get();

        } catch (IOException e) {
            LoggerUtil.printJSON("数据获取失败： "+detailUrl);
            e.printStackTrace();
        }
        return null;
    }

}
