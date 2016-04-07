package yuan.ssm.common.util;

/**
 * Created by yuan on 16-4-5.
 * 控制台日志打印　－　工具类
 */
public class LoggerUtil {


    public static void print(String... params){
        String[] strings = params.clone();
        System.out.println("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
        System.out.println("＋＋");
        for(int i=0;i<strings.length;i++){
            System.out.println("＋＋  arg"+i+"   :   "+strings[i]);
        }
        System.out.println("＋＋");
        System.out.println("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
    }


}
