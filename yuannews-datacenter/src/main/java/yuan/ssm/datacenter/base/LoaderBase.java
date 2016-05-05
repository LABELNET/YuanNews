package yuan.ssm.datacenter.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import yuan.ssm.common.util.FileTool;
import yuan.ssm.common.util.LoggerUtil;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
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
 * 创建日期：　16-5-4 下午1:08
 * <p/>
 * 功能描述： 主页数据加载的抽象类
 * 1.返回urls
 * 2.
 * <p>
 * <p/>
 * 功能更新历史：
 *
 * url去脏操作-循环比较上一天的url,去除后进行返回
 *
 * <p>
 * ==================================================
 */
public abstract class LoaderBase {

    private String url=null;


    public LoaderBase(String url) {
        this.url = url;
    }

    protected Document getDoc(){
        try {
            return Jsoup.connect(url).timeout(200000).get();
        } catch (IOException e) {
            LoggerUtil.printJSON("LoaderBase  getDoc Exception Url : "+url);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 去除重复的urls
     * 策略： 如果url大于1000,则不进行操作，直接删除文件，存储目前最新的urls
     * @return 最新的urls
     */
    protected synchronized Set<String> cleanUrls(Set<String> newUrls,String filename){
        Set<String> bigUrls=new HashSet<String>();
        try {
            List<String> oldUrls = FileTool.readData(filename);

            if(newUrls==null){
                //新的url为空
                return bigUrls;//返回空的urls
            }

            if(oldUrls==null){
                FileTool.createNewFile(filename,newUrls);//存储最新的地址链接
                return newUrls;//返回最新的地址链接
            }else{
                if(oldUrls.size()==0){
                    FileTool.createNewFile(filename,newUrls);//存储最新的地址链接
                    return newUrls;//返回最新的地址链接
                }else{
                    if(oldUrls.size()>=1000){
                        FileTool.createNewFile(filename,newUrls);//存储最新的地址链接
                        return newUrls;//返回最新的地址链接
                    }else{
                        bigUrls.addAll(oldUrls);
                        //去除已经爬去的urls
                        for (String url :oldUrls) {
                            if(newUrls.contains(url)){
                                newUrls.remove(url); //去除重复的
                            }
                        }
                        bigUrls.addAll(newUrls);
                        FileTool.createNewFile(filename,bigUrls); //存储最新爬取过的url
                        LoggerUtil.printJSON(bigUrls);
                    }
                }
            }

        } catch (Exception e) {
            LoggerUtil.printJSON("LoaderBase  cleanUrls Exception ");
            e.printStackTrace();
        }
        return newUrls;
    }

    /**
     * 获取某个新闻来源上的主页urls
     * @return url集合
     */
    protected abstract Set<String> getUrls();

    /**
     * 获取某个新闻来源的类型
     * @return 来源类型
     */
    protected abstract SourceEnum getType();

}
