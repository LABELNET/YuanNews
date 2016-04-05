package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.NewsManagerMapper;
import cn.hpu.yuan.ssm.model.pojo.NewsPo;
import cn.hpu.yuan.ssm.model.vo.NewsVo;
import common.MapperContanst;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by yuan on 16-4-1.
 * 后台管理 - 新闻管理 - 单元测试
 */
public class NewsManagerTest {


    private ApplicationContext context;
    private NewsManagerMapper newsManagerMapper;

    @Before
    public void setUp(){
        context=new ClassPathXmlApplicationContext(MapperContanst.APPLIACTION_CONTEXT_LOCATION);
        newsManagerMapper= (NewsManagerMapper) context.getBean("newsManagerMapper");
    }


    /**
     * 通过id , 查询新闻（不包含内容）
     */
    @Test
    public void findNewsById() throws Exception{
        NewsPo newsById = newsManagerMapper.findNewsById(2);
        System.out.printf("新闻测试结果  ： "+newsById.toString());
    }

    /**
     * 分页查询新闻信息
     */
    @Test
    public void findNews() throws Exception{
        List<NewsPo> news = newsManagerMapper.findNews(0, 3);
        System.out.printf("新闻测试结果  ： "+news.toString());
    }

    /**
     * 测试获取 新闻内容
     */
    @Test
    public void findNewsContentById() throws Exception{
        String byId = newsManagerMapper.findNewsContentById(2);
        System.out.printf("新闻测试结果  ： "+byId);
    }

    /**
     * 根据分类，分页获得新闻
     */
    @Test
    public void findNewsByCate() throws Exception{
        List<NewsPo> newsPos = newsManagerMapper.findNewsByCate(0, 3, 1);
        System.out.printf("新闻测试结果  ： "+newsPos);
    }


    /**
     * 根据来源
     */
    @Test
    public void findNewsBySource() throws Exception{
        List<NewsPo> newsPos = newsManagerMapper.findNewsBySource(0, 3, 1);
        System.out.printf("新闻测试结果  ： "+newsPos);
    }


    /**
     * 更新阅读量
     */
    @Test
    public void updateNewsRnum() throws Exception{
        Integer integer = newsManagerMapper.updateNewsRnum(2, 100);
        System.out.printf("新闻测试结果  ： "+integer+ " | " +(integer>0?"成功":"失败") );
    }


    /**
     * 修改 title
     */
    @Test
    public void updateNewsTitle() throws Exception{
        Integer integer = newsManagerMapper.updateNewsTitle(2,"失败是成功之母 ？　Yes ");
        System.out.printf("新闻测试结果  ： "+integer+ " | " +(integer>0?"成功":"失败") );
    }

    /**
     * 修改新闻来源
     */
    @Test
    public void updateNewsSource() throws Exception{
        Integer integer = newsManagerMapper.updateNewsSource(2,3);
        System.out.printf("新闻测试结果  ： "+integer+ " | " +(integer>0?"成功":"失败") );
    }

    /**
     * 修改图片地址
     */
    @Test
    public void updateNewsImg() throws Exception{
        Integer integer = newsManagerMapper.updateNewsImg(2,"/images/moren.jpg");
        System.out.printf("新闻测试结果  ： "+integer+ " | " +(integer>0?"成功":"失败") );
    }

    /**
     * 修改时间
     */
    @Test
    public void updateNewsTime() throws Exception{
        Integer integer = newsManagerMapper.updateNewsTime(2,new Date().toString());
        System.out.printf("新闻测试结果  ： "+integer+ " | " +(integer>0?"成功":"失败") );
    }

    /**
     * 修改分类信息
     */
    @Test
    public void updateNewsCate() throws Exception{
        Integer integer = newsManagerMapper.updateNewsCate(2,2);
        System.out.printf("新闻测试结果  ： "+integer+ " | " +(integer>0?"成功":"失败") );
    }


    /**
     * 测试添加
     */
    @Test
    public void insertNews() throws Exception{
        NewsVo vo=new NewsVo();
        vo.setContent("我是一个小鸭子！！");
        vo.setDt(new Date().toString());
        vo.setImg("/images/moren.jpg");
        vo.setTitle("测试添加！！");
        vo.setCid(3);
        vo.setSid(1);

        Integer integer = newsManagerMapper.insertNews(vo);
        System.out.printf("新闻测试结果  ： "+integer+ " | " +(integer>0?"成功":"失败") );
    }


    /**
     * 测试　删除
     *
     */
    @Test
    public void deleteNewsById() throws Exception{
        Integer integer = newsManagerMapper.deleteNewsById(16);
        System.out.printf("新闻测试结果  ： "+integer+ " | " +(integer>0?"成功":"失败") );
    }






}
