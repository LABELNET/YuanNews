package cn.hpu.yuan.ssm.model.base;

/**
 * Created by yuan on 16-3-30.
 * 兴趣基础对象
 */
public class Taste {

    private Integer id;
    private String label;
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
