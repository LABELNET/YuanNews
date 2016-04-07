package yuan.ssm.common.util;

/**
 * Created by yuan on 16-4-5.
 * 控制台日志打印　－　工具类
 */
public class LoggerUtil {


    public static void print(Object... params){
        Object[] objects = params.clone();
        System.out.println("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
        System.out.println("＋＋");
        for(int i=0;i<objects.length;i++){
            System.out.println("＋＋  "+i+"   :   "+objects[i]);
        }
        System.out.println("＋＋");
        System.out.println("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
    }

}
