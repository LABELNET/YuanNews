package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.SourceManagerMapper;
import common.ManagerBaseTest;
import org.junit.Test;

/**
 * Created by yuan on 16-4-4.
 */
public class SourceManagerTest extends ManagerBaseTest{

    private SourceManagerMapper sourceManagerMapper;

    @Override
    public void setUp() {
        super.setUp();
        sourceManagerMapper= (SourceManagerMapper) super.context.getBean("sourceManagerMapper");
    }

    @Test
    private void findSources(){

    }

}
