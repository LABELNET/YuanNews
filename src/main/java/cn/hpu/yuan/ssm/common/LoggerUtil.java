package cn.hpu.yuan.ssm.common;

/**
 * Created by yuan on 16-4-5.
 * 控制台日志打印　－　工具类
 */
public class LoggerUtil {


    public static void print(String msg,String msg1,String msg2,String msg3,String msg4){
        System.out.println("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
        System.out.println("＋＋");
        System.out.println("＋＋　　msg0 :　 "+msg);
        System.out.println("＋＋　　msg1 :　 "+msg1);
        System.out.println("＋＋　　msg2 : 　"+msg2);
        System.out.println("＋＋　　msg3 : 　"+msg3);
        System.out.println("＋＋　　msg4 :　 "+msg4);
        System.out.println("＋＋");
        System.out.println("＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋＋");
    }

    public static void print(String msg,String msg1,String msg2,String msg3) {
        print(msg, msg1, msg2, msg3,null);
    }

    public static void print(String msg,String msg1,String msg2) {
        print(msg, msg1, msg2,null);
    }

    public static void print(String msg,String msg1) {
        print(msg, msg1,null);
    }

    public static void print(String msg) {
        print(msg,null);
    }


}
