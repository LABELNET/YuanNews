package cn.hpu.yuan.ssm.common;

/**
 * Created by yuan on 16-4-5.
 * 控制台日志打印　－　工具类
 */
public class LoggerUtil {

    public static void print(String msg,String msg1,String msg2,String msg3,String msg4){
        System.out.printf("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
        System.out.printf("＋");
        System.out.printf("＋ "+msg);
        System.out.printf("＋ "+msg1);
        System.out.printf("＋ "+msg2);
        System.out.printf("＋ "+msg3);
        System.out.printf("＋ "+msg4);
        System.out.printf("＋");
        System.out.printf("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
    }

    public static void print(String msg,String msg1,String msg2,String msg3) {
        print(msg, msg1, msg2, msg3);
    }

    public static void print(String msg,String msg1,String msg2) {
        print(msg, msg1, msg2);
    }

    public static void print(String msg,String msg1) {
        print(msg, msg1);
    }

    public static void print(String msg) {
        print(msg);
    }

}
