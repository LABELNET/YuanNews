package yuan.ssm.datacenter.DownUtil;

import yuan.ssm.common.util.LoggerUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
 * 创建日期：　16-5-4 下午10:00
 * <p/>
 * 功能描述：图片下载类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class ImageDown {

    //本地硬盘存储位置
    private static final String LOCAL_IMAGE_PATH="/mnt/JAVA/tomcatImageServer/";


    private String type,imgurl;

    public ImageDown(String type,String imgurl) {
        this.type = type;
        this.imgurl=imgurl;
    }

    /**
     * 下载图片并存储到本地硬盘
     * @param imgName 图片名称
     */
    public synchronized void downloadImage(String imgName){

        imgName=getLocalPath()+"/"+imgName;

        HttpURLConnection httpURLConnection= null;
        try {
            URL url2=new URL(imgurl);
            httpURLConnection = (HttpURLConnection) url2.openConnection();
            httpURLConnection.setReadTimeout(3000);
            int code=httpURLConnection.getResponseCode();
            if(code==200){
                saveImage(imgName,httpURLConnection.getInputStream());
            }
            httpURLConnection.disconnect();
        } catch (Exception e) {
            LoggerUtil.printJSON("ParserBase NewsManagerMapper downloadImage Exception");
        }
    }

    /**
     * 获取图片名
     * @return
     */
    public String getImageName(){
        return UUID.randomUUID()+".jpg";
    }

    /**
     * 获取网络路径
     * @return
     */
    public String getNetPath(String fileName){
        return "/image/"+type+"/"+fileName;
    }

    /**
     * 得到本地路径
     * @return
     */
    private String getLocalPath() {
        String dir=LOCAL_IMAGE_PATH+type;
        File fileDir=new File(dir);
        if(!fileDir.exists()){
            fileDir.mkdir();
        }
        return dir;
    }

    /**
     * 保存图片操作
     * @param path
     * @param stream
     * @throws Exception
     */
    private synchronized void saveImage(String path,InputStream stream) throws Exception {
        File file=new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream outputStream=new FileOutputStream(file);
        outputStream.write(readInputStream(stream));
        outputStream.flush();
        outputStream.close();
    }


    /**
     * 获取图片Stream
     * @param inStream 请求过来的数据流
     * @return
     * @throws Exception
     */
    private synchronized byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }

}
