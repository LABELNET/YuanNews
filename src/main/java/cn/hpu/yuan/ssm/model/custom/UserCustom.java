package cn.hpu.yuan.ssm.model.custom;

import cn.hpu.yuan.ssm.model.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 16-3-30.
 * 用户其他实体类
 */
public class UserCustom {
    List<UserVo> list=new ArrayList<UserVo>();

    public List<UserVo> getList() {
        return list;
    }

    public void setList(List<UserVo> list) {
        this.list = list;
    }
}
