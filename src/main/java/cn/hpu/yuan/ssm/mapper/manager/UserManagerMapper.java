package cn.hpu.yuan.ssm.mapper.manager;

import cn.hpu.yuan.ssm.model.vo.UserVo;

/**
 * Created by yuan on 16-3-30.
 * 用户mapper
 */
public interface UserManagerMapper {

    //根据用户id，获得用户信息
    UserVo findUserById(Integer id) throws Exception;

}
