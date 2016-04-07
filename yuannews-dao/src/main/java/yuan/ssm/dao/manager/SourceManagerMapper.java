package yuan.ssm.dao.manager;

import org.apache.ibatis.annotations.Param;
import yuan.ssm.vo.SourceVo;
import java.util.List;

/**
 * Created by yuan on 16-4-3.
 * 后台管理 - 新闻来源管理 - mapper
 */
public interface SourceManagerMapper {

    //分页查询　－　新闻来源管理　－　id 倒序输出
    List<SourceVo> findSources(Integer start, Integer num) throws Exception;

    //修改　－　新闻来源内容
    Integer updateSourceContent(@Param("id") Integer id, @Param("content") String content) throws Exception;

    //删除　- 新闻来源内容
    Integer deleteSourceContent(Integer id) throws Exception;

    //新增　- 新闻来源
    Integer insertSource(String content) throws Exception;

}
