package cn.hpu.yuan.ssm.model.pojo;

import cn.hpu.yuan.ssm.model.vo.CateVo;
import cn.hpu.yuan.ssm.model.vo.NewsVo;
import cn.hpu.yuan.ssm.model.vo.SourceVo;

/**
 * Created by yuan on 16-4-1.
 * 新闻的 pojo -> 直接 查询到NewsPo中
 */
public class NewsPo extends NewsVo {

    private SourceVo sourceVo;
    private CateVo cateVo;

    public SourceVo getSourceVo() {
        return sourceVo;
    }

    public void setSourceVo(SourceVo sourceVo) {
        this.sourceVo = sourceVo;
    }

    public CateVo getCateVo() {
        return cateVo;
    }

    public void setCateVo(CateVo cateVo) {
        this.cateVo = cateVo;
    }
}
