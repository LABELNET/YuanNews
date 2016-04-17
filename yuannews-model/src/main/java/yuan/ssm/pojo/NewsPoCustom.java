package yuan.ssm.pojo;

import yuan.ssm.vo.CateVo;
import yuan.ssm.vo.SourceVo;

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
 * 创建日期：　16-4-17 下午7:08
 * <p/>
 * 功能描述： 后台新闻管理，修改的时候，加载单条数据，还要包括分类所有信息和来源信息
 * 从而进行初始哈修改页面；
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class NewsPoCustom {

    private NewsPo newsPo;
    private List<CateVo> cates;
    private List<SourceVo> sourceVos;

    public NewsPo getNewsPo() {
        return newsPo;
    }

    public void setNewsPo(NewsPo newsPo) {
        this.newsPo = newsPo;
    }

    public List<CateVo> getCates() {
        return cates;
    }

    public void setCates(List<CateVo> cates) {
        this.cates = cates;
    }

    public List<SourceVo> getSourceVos() {
        return sourceVos;
    }

    public void setSourceVos(List<SourceVo> sourceVos) {
        this.sourceVos = sourceVos;
    }
}
