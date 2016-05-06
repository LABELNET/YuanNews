package yuan.ssm.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import yuan.ssm.common.config.ConfigConstant;

import java.io.*;
import java.util.List;
import java.util.Set;


/**
 * 文件工具类
 *  功能：用来读取和存储 推荐的新闻ids
 *  作用：缓存用户的推荐新闻id
 *  create by yuanmingzhuo on 16/05/03
 */
public class FileTool {

    private static final Logger log = Logger.getLogger(FileTool.class);

    private static final String BASE_PATH= ConfigConstant.JSON_IDS_BASE_PATH;


    private static final String DATA_CENTER_LOG_NAEM="datacenter";

    /**
     * 获取文件路径
     * @param uid
     * @return
     */
    private static String getFilePath(Integer uid){
       return BASE_PATH+uid+".json";
    }

    private static String getFilePath(String name){
        return BASE_PATH+name+".json";
    }

    private static String getFilePath(){return BASE_PATH+DATA_CENTER_LOG_NAEM+".json";}

    /**
     * 新建文件
     * @param uid 用户id
     * @param t 新闻id集合
     */
    public static void createNewFile(Integer uid,Set<Integer> t){
         createNewFile(getFilePath(uid),JSON.toJSONString(t));
    }

    /**
     * 新建文件，存储爬虫后的日志文件
     * @param logContent
     */
    public static void createNewFile(String logContent){
        try {
            List<String> logs = readData();
            logs.add(logContent);//添加日志信息
            createNewFile(getFilePath(),JSON.toJSONString(logs));
        } catch (Exception e) {
            log.error(" dataCenter 爬虫日志文件创建异常 : createNewFile: "+e.getMessage());
        }
    }

    /**
     * 新建文件
     * @param fileNameTemp String 文件路径
     *
     * @param content
     *            String 文件内容
     */
    private static void createNewFile(String fileNameTemp,String content) {
        try {
            File filePath = new File(fileNameTemp);
            filePath.createNewFile();
            FileWriter fw = new FileWriter(filePath);
            PrintWriter pw = new PrintWriter(fw);
            String strContent = content;
            pw.println(strContent);
            pw.flush();
            pw.close();
            fw.close();
        } catch (Exception e) {
            log.error("新建文件操作出错: "+e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * 新建文件
     * @param name 文件名
     * @param urls 地址
     */
    public static void createNewFile(String name,Set<String> urls){
        createNewFile(getFilePath(name),JSON.toJSONString(urls));
    }

    /**
     * 删除-文件名
     * @param name
     */
    public static void deleteFile(String name){
        delFile(getFilePath(name));
    }

    /**
     * 删除-用户id
     * @param uid
     */
    public static void deleteFile(Integer uid){
        delFile(getFilePath(uid));
    }


    /**
     * 删除文件
     */
    private static void delFile(String filePath) {
        try {
            java.io.File delFile = new java.io.File(filePath);
            if(delFile.exists()){
                delFile.delete();
            }else{
                log.info("删除的文件不存在");
            }
        } catch (Exception e) {
            log.error("删除文件操作出错: "+e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * 读取用户id
     * @param uid
     * @return
     * @throws Exception
     */
    public static List<Integer> readData(Integer uid) throws Exception{

        String content=readData(getFilePath(uid),uid);
        if(content==null){
            return null;
        }
        return JSON.parseArray(content,Integer.class);
    }

    /**
     * 读取urls
     * @param name
     * @return 集合
     * @throws Exception
     */
    public static List<String> readData(String name) throws Exception{
        String content=readData(getFilePath(name),0);
        if(content==null){
           return null;
        }
        return JSON.parseArray(content,String.class);
    }

    /**
     * 读取datacenter日志文件
     * @return 集合
     * @throws Exception
     */
    public static List<String> readData() throws Exception{
        String content=readData(getFilePath(),0);
        if(content==null){
            return null;
        }
        return JSON.parseArray(content,String.class);
    }


    /**
     * 读取数据
     * @return
     * @throws Exception
     */
    private static String readData(String path,Integer uid) throws Exception{
        StringBuffer buffer=new StringBuffer();
        File file=new File(path);
        if(file.exists()) {
            InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                buffer.append(lineTxt);
            }
            return buffer.toString();
        }else{
            return null;
        }
    }
    

}