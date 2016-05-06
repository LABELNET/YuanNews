package yuan.ssm.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import yuan.ssm.common.config.ConfigConstant;
import yuan.ssm.common.util.DateUtil;
import yuan.ssm.other.DataBean;
import yuan.ssm.service.customer.UserService;
import yuan.ssm.service.manager.UserManager;
import yuan.ssm.service.mobile.UserAppService;
import yuan.ssm.vo.TasteVo;
import yuan.ssm.vo.UserVo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
 * 创建日期：　16-5-5 下午3:41
 * <p/>
 * 功能描述： Android 客户端　数据 接口API
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */

@Controller
@RequestMapping(value = "api/")
public class AndroidController {

    @Autowired
    private UserService userService; //用户service

    @Autowired
    private UserManager userManager;//用户manager


    @Autowired
    private UserAppService userAppService;//用户特殊service

    /**
     * 01.用户登录接口
     * @param unum 账户
     * @param pass 密码
     * @return json
     */
    @RequestMapping("login")
    public @ResponseBody String login(@RequestParam String unum,@RequestParam String pass){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        try {
            UserVo vo = userService.userLogin(unum, pass);
            if(vo==null){
                bean.setCode(-1);
                bean.setMsg("登录失败");
            }else{
                bean.setCode(0);
                bean.setMsg("登录成功");
                bean.setData(vo);
            }
        } catch (Exception e) {
            bean.setCode(-3);
            bean.setMsg("系统错误");
        }
        return JSON.toJSONString(bean);
    }


    /**
     * 02.用户注册
     * @param unum 账户
     * @param pass 密码
     * @param nick 昵称
     * @return json
     */
    @RequestMapping("register")
    public @ResponseBody String register(@RequestParam String unum,@RequestParam String pass,@RequestParam String nick){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        try {
                Integer integer = userService.userRegister(unum, pass, nick);
                if (integer == -2) {
                    bean.setCode(-2);
                    bean.setMsg("参数不正确");
                }

                if (integer == -1) {
                    bean.setCode(-1);
                    bean.setMsg("账户已存在");
                }

                if (integer > 0) {
                    bean.setCode(0);
                    bean.setMsg("注册成功");
                }
        } catch (Exception e) {
            bean.setCode(-3);
            bean.setMsg("系统错误");
        }
        return JSON.toJSONString(bean);
    }


    /**
     * 03.修改用户的昵称，性别信息
     * @param userVo
     * @return json
     */
    @RequestMapping("updateUserIfo")
    public @ResponseBody String updateUserIfo(@ModelAttribute UserVo userVo){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        userVo.setStatus(-1);
        try {
            Integer integer = userManager.managerUpdateUserIfo(userVo);
            if(integer==-1){
                bean.setCode(-1);
                bean.setMsg("参数不正确");
            }

            if(integer==-2){
                bean.setCode(-2);
                bean.setMsg(" 用户 id 有误");
            }

            if(integer>0){
                bean.setCode(0);
                bean.setMsg("修改成功");
            }


        } catch (Exception e) {
            bean.setCode(-3);
            bean.setMsg("系统错误");
        }
        return JSON.toJSONString(bean);
    }


    /**
     * 04.修改用户头像
     * @param uid 用户id
     * @param mfile  enctype="multipart/form-data" 对象
     * @return json
     */
    @RequestMapping("updateUserHead")
    public @ResponseBody String updateUserHead(@RequestParam Integer uid,MultipartFile mfile){
        DataBean<UserVo> bean = new DataBean<UserVo>();

        if(uid==null){
            bean.setCode(-2);
            bean.setMsg("id参数不正确");
        }else{

            if(uid<0){
                bean.setCode(-2);
                bean.setMsg("id参数不正确");
            }else{
                String imgName = DateUtil.getDateFileName()+ UUID.randomUUID() +".png";
                String imgPath= ConfigConstant.FONT_IMAGE_BASE_PATH+imgName;
                File file=new File(imgPath);
                try {
                    mfile.transferTo(file);
                    String head="/image/head/"+imgName;
                    Integer integer = userAppService.updateUserHead(uid, head);
                    if(integer>0){
                        bean.setCode(0);
                        bean.setMsg("头像修改成功");
                    }else{
                        bean.setCode(-1);
                        bean.setMsg("头像修改失败");
                    }
                } catch (IOException e) {
                    bean.setCode(-3);
                    bean.setMsg("系统错误");
                } catch (Exception e) {
                    bean.setCode(-3);
                    bean.setMsg("系统错误");
                }

            }
        }
        return JSON.toJSONString(bean);
    }

    /**
     * 05.修改密码操作
     * @param uid
     * @param pass
     * @return json
     */
    @RequestMapping("updateUserPass")
    public @ResponseBody String updateUserPass(@RequestParam Integer uid,@RequestParam String pass){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        if(uid==null){
            bean.setCode(-2);
            bean.setMsg("id参数不正确");
        }else{

            if(uid<0){
                bean.setCode(-2);
                bean.setMsg("id参数不正确");
            }else{
                try {
                    Integer integer = userAppService.updateUserPass(uid, pass);
                    if(integer>0){
                        bean.setCode(0);
                        bean.setMsg("密码修改成功");
                    }else{
                        bean.setCode(-1);
                        bean.setMsg("密码修改失败");
                    }
                } catch (Exception e) {
                    bean.setCode(-3);
                    bean.setMsg("系统错误");
                }

            }
        }
        return JSON.toJSONString(bean);
    }

    /**
     * 06.添加兴趣标签
     * @param uid 用户id
     * @param label 标签
     * @return json
     */
    @RequestMapping("addTasteLabel")
    public @ResponseBody String addTasteLabel(@RequestParam Integer uid,@RequestParam String label){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        if(uid==null){
            bean.setCode(-2);
            bean.setMsg("id参数不正确");
        }else{
            if(uid<0){
                bean.setCode(-2);
                bean.setMsg("id参数不正确");
            }else{
                try {

                    if(label.length()==0){
                        bean.setCode(-1);
                        bean.setMsg("标签内容不存在");
                    }else{
                        Integer integer = userService.userAddTasteLabel(label, uid);
                        if(integer>0){
                            bean.setCode(0);
                            bean.setMsg("添加成功");
                        }else{
                            bean.setCode(-1);
                            bean.setMsg("添加失败");
                        }
                    }
                } catch (Exception e) {
                    bean.setCode(-3);
                    bean.setMsg("系统错误");
                }

            }
        }
        return JSON.toJSONString(bean);
    }

    /**
     * 07.查询用户所有的兴趣标签
     * @param uid 用户uid
     * @return json
     */
    @RequestMapping("allLabels")
    public @ResponseBody String allLabels(@RequestParam Integer uid){
        DataBean<List<TasteVo>> bean = new DataBean<List<TasteVo>>();
        if(uid==null){
            bean.setCode(-2);
            bean.setMsg("id参数不正确");
        }else{
            if(uid<0){
                bean.setCode(-2);
                bean.setMsg("id参数不正确");
            }else{
                try {
                    List<TasteVo> tasteVos = userService.userSelectTasteById(uid);
                    bean.setMsg("成功");
                    bean.setCode(0);
                    bean.setData(tasteVos);
                } catch (Exception e) {
                    bean.setCode(-3);
                    bean.setMsg("系统错误");
                }
            }
        }
        return JSON.toJSONString(bean);
    }


    /**
     * 08.删除用户兴趣
     * @param tid 兴趣id
     * @return json
     */
    @RequestMapping("deleteLabel")
    public @ResponseBody String deleteLabel(@RequestParam Integer tid){
        DataBean<TasteVo> bean = new DataBean<TasteVo>();
        if(tid==null){
            bean.setCode(-2);
            bean.setMsg("id参数不正确");
        }else{
            if(tid<0){
                bean.setCode(-2);
                bean.setMsg("id参数不正确");
            }else{
                try {
                    Integer integer = userService.userDeleteTasteById(tid);
                    if(integer>0){
                       bean.setCode(0);
                       bean.setMsg("删除成功");
                    }else{
                        bean.setCode(-1);
                        bean.setMsg("删除失败");
                    }
                } catch (Exception e) {
                    bean.setCode(-3);
                    bean.setMsg("系统错误");
                }
            }
        }
        return JSON.toJSONString(bean);
    }

    /**
     * 09.查询用户详情
     * @param uid 用户id
     * @return json
     */
    @RequestMapping("getUserDetail")
    public @ResponseBody String getUserDetail(@RequestParam Integer uid){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        if(uid==null){
            bean.setCode(-2);
            bean.setMsg("id参数不正确");
        }else{
            if(uid<0){
                bean.setCode(-2);
                bean.setMsg("id参数不正确");
            }else{
               try{

                   UserVo vo = userManager.managerFindUserIfo(uid);
                   if(vo==null){
                       bean.setCode(-1);
                       bean.setMsg("失败");
                   }else{
                       vo.setPass("");//隐藏密码
                       bean.setCode(0);
                       bean.setMsg("成功");
                       bean.setData(vo);
                   }
               } catch (Exception e) {
                    bean.setCode(-3);
                    bean.setMsg("系统错误");
                }
            }
        }
        return JSON.toJSONString(bean);
    }

    /**
     * 10 . 用户点赞
     * @param uid
     * @param nid
     * @param status
     * @return
     */
    @RequestMapping("userZanNews")
    public @ResponseBody String userZanNews(@RequestParam Integer uid,@RequestParam Integer nid,@RequestParam Integer status){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        if(uid==null){
            bean.setCode(-2);
            bean.setMsg("id参数不正确");
        }else{
            if(uid<0){
                bean.setCode(-2);
                bean.setMsg("id参数不正确");
            }else{
                try{
                    Integer integer = userService.userZanNews(uid, nid, status);
                    if(integer>0){
                        bean.setCode(0);
                        bean.setMsg("已赞");
                    }else{
                        bean.setCode(-1);
                        bean.setMsg("失败");
                    }
                } catch (Exception e) {
                    bean.setCode(-3);
                    bean.setMsg("系统错误");
                }
            }
        }
        return JSON.toJSONString(bean);
    }

    /**
     * 11.用户评论新闻
     * @param uid 用户id
     * @param nid 新闻id
     * @param content 评论内容
     * @return json
     */
    @RequestMapping("userCommentNews")
    public @ResponseBody String userCommentNews(@RequestParam Integer uid,@RequestParam Integer nid,@RequestParam String content){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        if(uid==null){
            bean.setCode(-2);
            bean.setMsg("id参数不正确");
        }else{
            if(uid<0){
                bean.setCode(-2);
                bean.setMsg("id参数不正确");
            }else{
                try{
                    Integer integer = userService.userCommentNews(uid, nid, content);
                    if(integer>0){
                        bean.setCode(0);
                        bean.setMsg("评论成功");
                    }else {
                        bean.setCode(-1);
                        bean.setMsg("评论失败");
                    }
                } catch (Exception e) {
                    bean.setCode(-3);
                    bean.setMsg("系统错误");
                }
            }
        }
        return JSON.toJSONString(bean);
    }


}
