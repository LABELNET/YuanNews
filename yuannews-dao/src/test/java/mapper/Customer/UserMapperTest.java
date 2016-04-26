package mapper.Customer;

import org.junit.Test;
import yuan.ssm.common.util.LoggerUtil;

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
 * 创建日期：　16-4-26 下午7:49
 * <p/>
 * 功能描述： 用户mapper测试类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class UserMapperTest extends CustomerBaseTest{


    @Override
    public void setUp() {
        super.setUp();

    }

    @Test
    public void CheckUserUnumTest() throws Exception {
        Integer integer = userMapper.CheckUserUnum("15000000020");
        LoggerUtil.printJSON(integer);
    }

}
