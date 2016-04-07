package yuan.ssm.pojo;


import yuan.ssm.vo.LikedVo;
import yuan.ssm.vo.NewsVo;
import yuan.ssm.vo.UserVo;

/**
 * Created by yuan on 16-4-4.
 * 后台管理－点赞管理－点赞拓展类
 */
public class LikedPo extends LikedVo {
    private UserVo userVo;
    private NewsVo newsVo;

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public NewsVo getNewsVo() {
        return newsVo;
    }

    public void setNewsVo(NewsVo newsVo) {
        this.newsVo = newsVo;
    }

    @Override
    public String toString() {
        return super.toString()+"LikedPo{" +
                "userVo=" + userVo +
                ", newsVo=" + newsVo +
                '}';
    }
}
