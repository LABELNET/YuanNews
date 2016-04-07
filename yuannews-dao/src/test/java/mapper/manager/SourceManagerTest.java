package mapper.manager;


import common.ManagerBaseTest;
import org.junit.Test;
import yuan.ssm.dao.manager.SourceManagerMapper;
import yuan.ssm.vo.SourceVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 后台管理－来源管理-单元测试
 */
public class SourceManagerTest extends ManagerBaseTest {

    private SourceManagerMapper sourceManagerMapper;

    @Override
    public void setUp() {
        super.setUp();
        sourceManagerMapper= (SourceManagerMapper) super.context.getBean("sourceManagerMapper");
    }

    @Test
    public void findSources() throws Exception {
        List<SourceVo> sources = sourceManagerMapper.findSources(0, 4);
        System.out.printf("来源测试　：　"+sources);
    }

}
