package top.yzlin.img;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class ImgTest {

    public static void main(String[] args) {
        System.out.println(downloadImg("https://dl.pvp.xoyo.com/prod/icons/skill_chunyang40.png"));
    }


    public static String downloadImg(String url) {
        try {
            BufferedImage read = ImageIO.read(new URL(url));
            BufferedImage newBufferedImage = new BufferedImage(read.getWidth(), read.getHeight(), BufferedImage.TYPE_INT_RGB);
            newBufferedImage.createGraphics().drawImage(read, 0, 0, Color.WHITE, null);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(newBufferedImage, "jpg", baos);
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(baos.toByteArray()).replaceAll("[\r\n]", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
