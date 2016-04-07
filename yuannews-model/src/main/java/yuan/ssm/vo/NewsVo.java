package yuan.ssm.vo;

import yuan.ssm.base.News;

/**
 * Created by yuan on 16-3-30.
 * 客户实体类
 */
public class NewsVo extends News {

    private Integer cid;
    private Integer sid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
