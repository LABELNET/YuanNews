package cn.hpu.yuan.ssm.model.pojo;

import cn.hpu.yuan.ssm.model.vo.LikedVo;
import cn.hpu.yuan.ssm.model.vo.NewsVo;
import cn.hpu.yuan.ssm.model.vo.UserVo;

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
}
