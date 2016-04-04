package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.SourceManagerMapper;
import cn.hpu.yuan.ssm.model.vo.SourceVo;
import common.ManagerBaseTest;
import org.junit.Test;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 后台管理－来源管理-单元测试
 */
public class SourceManagerTest extends ManagerBaseTest{

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
