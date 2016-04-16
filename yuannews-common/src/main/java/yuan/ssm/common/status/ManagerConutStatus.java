package yuan.ssm.common.status;

/**
 * Created by yuan on 16-4-12.
 * 查询数量，不同的类型查询不同的数量
 */
public interface ManagerConutStatus {

    //用户类型
    Integer MANAGER_USER_COUNT_TYPE=1;

    //新闻类型
    Integer MANAGER_NEWS_COUNT_TYPE=2;

    //评论类型
    Integer MANAGER_COMMENT_COUNT_TYPE=3;

    //点赞类型
    Integer MANAGER_LIKED_COUNT_TYPE=4;

    //爱好类型
    Integer MANAGER_TASTE_COUNT_TYPE=5;

    //新闻来源类型
    Integer MANAGER_SOURCE_COUNT_TYPE=6;


}
