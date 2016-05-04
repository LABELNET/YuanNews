package yuan.ssm.datacenter;

import yuan.ssm.datacenter.LoadUtil.HuxiuLoader;
import yuan.ssm.datacenter.ParseUtil.HuxiuParser;
import yuan.ssm.datacenter.base.ThreadPoolHttpClient;

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
 * 创建日期：　16-5-4 上午9:59
 * <p/>
 * 功能描述： TODO 总执行操作类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class DataMain {

    //环球网
    private final String HuanQiuUrl="http://huanqiu.com/";

    //虎嗅网
    private final String HUXIUURL="http://www.huxiu.com/";

    public static void main(String [] args){
       //总调度类

        //1.实现主页加载类
        HuxiuLoader huxiuLoader=new HuxiuLoader(HUXIUURL);

        //2.实现解析详情的Parser
        HuxiuParser huxiuParser=new HuxiuParser()

        //2.实现线程池
        ThreadPoolHttpClient threadPoolHttpClient=new ThreadPoolHttpClient(huxiuLoader);

        //3.执行开始操作
        threadPoolHttpClient.start();
    }
}
