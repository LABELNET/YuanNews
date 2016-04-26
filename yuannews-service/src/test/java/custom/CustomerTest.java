package custom;

import common.ServiceBaseTest;
import org.junit.Test;
import yuan.ssm.common.newsenum.ServiceEnum;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.pojo.CSCustom;
import yuan.ssm.pojo.NewsCustom;
import yuan.ssm.service.customer.NewsService;

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
 * 创建日期：　16-4-26 下午11:41
 * <p/>
 * 功能描述： newsservice测试类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class CustomerTest extends ServiceBaseTest{

    private NewsService newsService;
    @Override
    public void setUp() {
        super.setUp();
        newsService= (NewsService) super.context.getBean("newsServiceImpl");
    }

    @Test
    public void testfindCustomById() throws Exception {
        List<NewsCustom> customById = newsService.findCustomById(0, 10, "", ServiceEnum.normal);
        LoggerUtil.printJSON(customById);
    }

    @Test
    public void testfindCustomByZan() throws Exception {
        List<NewsCustom> customById = newsService.findCustomByZan(0, 10, "社会", ServiceEnum.cate);
        LoggerUtil.printJSON(customById);
    }

    @Test
    public void findCateSourceIfoTest() throws Exception {
        CSCustom cateSourceIfo = newsService.findCateSourceIfo();
        LoggerUtil.printJSON(cateSourceIfo);
    }


}
