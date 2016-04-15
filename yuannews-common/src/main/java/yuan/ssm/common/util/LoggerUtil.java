package yuan.ssm.common.util;

/**
 * Created by yuan on 16-4-5.
 * 控制台日志打印　－　工具类
 */
public class LoggerUtil {


    /**
     * 可拓展性
     * 当不需要打印log的时候，注释 printf()方法即可
     * @param params
     */
    public static void print(Object... params){
        printf(params);
    }

    private static void printf(Object... params){
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
