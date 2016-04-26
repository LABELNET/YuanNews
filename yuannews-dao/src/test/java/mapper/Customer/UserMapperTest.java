package mapper.Customer;

import org.junit.Test;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.vo.UserVo;

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


    /**
     * 测试数据 ：
     * {
     "head": "/image/head/2016041514302526219e9e283-b330-47bc-9150-fb416ecd1e46.png",
     "id": 24,
     "nick": "明天",
     "pass": "123456",
     "sex": 0,
     "status": 1,
     "unum": "15000000020"
     }
     */

    @Override
    public void setUp() {
        super.setUp();

    }

    @Test
    public void CheckUserUnumTest() throws Exception {
        Integer integer = userMapper.CheckUserUnum("15000000020");
        LoggerUtil.printJSON(integer);
    }

    @Test
    public void loginCheckPassTest() throws Exception {
        UserVo userVo = userMapper.loginCheckPass("15000000020", "123456");
        LoggerUtil.printJSON(userVo);
    }

    @Test
    public void registerUserTest() throws Exception {
        Integer registerUser = userMapper.registerUser("15000000120", "123456", "小明");
        LoggerUtil.printJSON(registerUser>0?"成功":"失败");
    }


    @Test
    public void userCheckTasteTest() throws Exception {
        Integer registerUser = userMapper.userCheckTaste("刘亦菲",1);
        LoggerUtil.printJSON(registerUser>0?"存在":"不存在");
    }


}
