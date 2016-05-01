package yuan.ssm.other;

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
 * 创建日期：　16-5-1 下午2:47
 * <p/>
 * 功能描述： 用户端，分页对象
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class PageVo {

    private Integer start; //开始
    private Integer num; //数量
    private Integer p; //分页
    private Integer type; //操作类型
    private String title; //title
    private Integer nType; //新闻类型，normal,cata,source

    public Integer getnType() {
        return nType;
    }

    public void setnType(Integer nType) {
        this.nType = nType;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        if(p<0){
            p=1; //添加判断
        }
        this.p = p;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
