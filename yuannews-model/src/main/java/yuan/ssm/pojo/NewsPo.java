package yuan.ssm.pojo;


import yuan.ssm.vo.NewsVo;

/**
 * Created by yuan on 16-4-1.
 * 新闻的 pojo -> 直接 查询到NewsPo中
 */
public class NewsPo extends NewsVo {

    private String cateStr;
    private String sourceStr;

    public String getCateStr() {
        return cateStr;
    }

    public void setCateStr(String cateStr) {
        this.cateStr = cateStr;
    }

    public String getSourceStr() {
        return sourceStr;
    }

    public void setSourceStr(String sourceStr) {
        this.sourceStr = sourceStr;
    }

    @Override
    public String toString() {
        return super.toString()+"NewsPo{" +
                "cateStr=" + cateStr +
                ", sourceStr=" + sourceStr +
                '}';
    }
}
