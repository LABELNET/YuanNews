package yuan.ssm.other;

/**
 * Created by yuan on 16-4-7.
 * 分页所需要的属性，可拓展性
 */
public class PageJo {

    private Integer allCount; //总数

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }
}
