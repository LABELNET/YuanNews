package yuan.ssm.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import yuan.ssm.common.config.ConfigConstant;

import java.io.*;
import java.util.HashSet;
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


    /**
     * 获取文件路径
     * @param uid
     * @return
     */
    private static String getFilePath(Integer uid){
       return BASE_PATH+uid+".json";
    }

    /**
     * 新建文件
     * @param uid 用户id
     * @param t 新闻id集合
     */
    public static void createNewFile(Integer uid,Set<Integer> t){
         createNewFile(uid, JSON.toJSONString(t));
    }

    /**
     * 新建文件
     * @param uid Integer 当前用户id
     *
     * @param content
     *            String 文件内容
     */
    public static void createNewFile(Integer uid, String content) {
        try {
            String fileNameTemp =getFilePath(uid);
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
     * 删除文件
     * @param uid 用户id
     */
    public static void delFile(Integer uid) {
        try {
            String filePath = getFilePath(uid);
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
     * 读取数据
     * @return
     * @throws Exception
     */
    public static List<Integer> readData(Integer uid) throws Exception{
        StringBuffer buffer=new StringBuffer();
        String path=getFilePath(uid);
        File file=new File(path);
        if(file.exists()) {
            InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                buffer.append(lineTxt);
            }
            List<Integer> ids = JSON.parseArray(buffer.toString(), Integer.class);
            return ids;
        }else{
            return null;
        }
    }
    
    /**
     * 一行一行读取文件，适合字符读取，若读取中文字符时会出现乱码
     * 
     * @param path
     * @return
     * @throws Exception
     */
    public static Set<String> readFile(String path) throws Exception{
        Set<String> datas=new HashSet<String>();
        FileReader fr=new FileReader(path);
        BufferedReader br=new BufferedReader(fr);
        String line=null;
        while ((line=br.readLine())!=null) {
            datas.add(line);
        }
        br.close();
        fr.close();
        return datas;
    }
}