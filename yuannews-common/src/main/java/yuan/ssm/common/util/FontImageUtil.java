package yuan.ssm.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

import static yuan.ssm.common.config.ConfigConstant.FONT_IMAGE_BASE_PATH;

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
 * 创建日期：　16-4-14 上午11:36
 * <p/>
 * 功能描述： 根据用户昵称生成用户头像
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class FontImageUtil {


    /**
     * 根据文字和图片名称创建图片
     * 默认的字体　宋体加粗
     * @param str　文字
     * @param imgName　文件明
     * @throws Exception
     */
    public static void createImage(String str, String imgName) throws Exception{
        createImage(str,new Font("宋体",Font.BOLD,18),new File(FONT_IMAGE_BASE_PATH+imgName));
    }

    /**
     * 根据str,输出目录创建图片
     * 文字样式默认为　宋体加粗
     * @param str　文字
     * @param outFile　输出目录
     * @throws Exception
     */
    public static void createImage(String str, File outFile) throws Exception{
        createImage(str,new Font("宋体",Font.BOLD,18),outFile);
    }

    /**
     * 根据str,font的样式以及输出文件目录
     * @param str 文字
     * @param font　字体样式
     * @param outFile　输出的文件及其输出的位置
     * @throws Exception
     * createImage("中华人民共和国",new Font("宋体",Font.BOLD,18),new File("e:/a.png"));
     */
    public static void createImage(String str, Font font, File outFile) throws Exception{

        //获取font的样式应用在str上的整个矩形
        Rectangle2D r=font.getStringBounds(str, new FontRenderContext(AffineTransform.getScaleInstance(1, 1),false,false));
        int unitHeight=(int)Math.floor(r.getHeight());//获取单个字符的高度
        //获取整个str用了font样式的宽度这里用四舍五入后+1保证宽度绝对能容纳这个字符串作为图片的宽度
        int width=(int)Math.round(r.getWidth())+1;
        int height=unitHeight+3;//把单个字符的高度+3保证高度绝对能容纳字符串作为图片的高度

        //创建图片
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics g=image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);//先用白色填充整张图片,也就是背景
        g.setColor(Color.black);//在换成黑色
        g.setFont(font);//设置画笔字体
        g.drawString(str, 0, font.getSize());//画出字符串
        g.dispose();

        ImageIO.write(image, "png", outFile);//输出png图片
    }

}
