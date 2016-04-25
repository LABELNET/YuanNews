package yuan.ssm.pojo;

import yuan.ssm.vo.CateVo;
import yuan.ssm.vo.SourceVo;

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
 * 创建日期：　16-4-25 下午5:20
 * <p/>
 * 功能描述：分类信息和来源信息，用来显示菜单使用
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class CSCustom {

    private CateVo cateVo;
    private SourceVo sourceVo;

    public CateVo getCateVo() {
        return cateVo;
    }

    public void setCateVo(CateVo cateVo) {
        this.cateVo = cateVo;
    }

    public SourceVo getSourceVo() {
        return sourceVo;
    }

    public void setSourceVo(SourceVo sourceVo) {
        this.sourceVo = sourceVo;
    }
}
