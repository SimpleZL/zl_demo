package com.zl;

import com.google.common.collect.Sets;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 感知哈希算法
 * 1. 缩小图片尺寸 -8*8
 * 2.简化色彩-转化为64级灰度
 * 3. 计算所有64个像素的灰度平均值
 * 4. 比较像素的灰度
 */
public class PerceptualHash {
    /**
     * 图像指纹的尺寸,将图像resize到指定的尺寸，来计算哈希数组
     */
    private static final int HASH_SIZE = 8;


    /**
     * 缩放图像到指定尺寸
     *
     * @param src
     * @param width
     * @param height
     * @return
     */
    private static BufferedImage resize(Image src, int width, int height) {
        BufferedImage result = new BufferedImage(width, height,
                BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = result.getGraphics();
        try {
            g.drawImage(src.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        } finally {
            g.dispose();
        }
        return result;
    }


    /**
     * 转灰度图像
     *
     * @param src
     * @return
     */
    private static BufferedImage toGray(BufferedImage src) {
        if (src.getType() == BufferedImage.TYPE_BYTE_GRAY) {
            return src;
        } else {
            // 图像转灰
            BufferedImage grayImage = new BufferedImage(src.getWidth(), src.getHeight(),
                    BufferedImage.TYPE_BYTE_GRAY);
            new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null).filter(src, grayImage);
            return grayImage;
        }
    }

    /**
     * 计算均值
     *
     * @param src
     * @return
     */
    private static int mean(byte[] src) {
        long sum = 0;
        // 将数组元素转为无符号整数
        for (byte b : src) {
            sum += (long) b & 0xff;
        }
        return (Math.round((float) sum / src.length));
    }

    /**
     * 比较均值，获取64位图片指纹
     *
     * @param src
     * @return
     */
    private static byte[] binaryzation(byte[] src) {
        byte[] dst = src.clone();
        int mean = mean(src);
        for (int i = 0; i < dst.length; ++i) {
            // 将数组元素转为无符号整数再比较
            dst[i] = (byte) (((int) dst[i] & 0xff) >= mean ? 1 : 0);
        }
        return dst;

    }

    public static byte[] hashValue(BufferedImage src) {
        BufferedImage hashImage = resize(src, HASH_SIZE, HASH_SIZE);
        byte[] matrixGray = (byte[]) toGray(hashImage).getData().getDataElements(0, 0, HASH_SIZE, HASH_SIZE, null);
        return binaryzation(matrixGray);
    }

    public static String picFingerPrint(String url) {
        try {
            BufferedImage buffer = ImageIO.read(new URL(url));
            byte[] bytes = hashValue(buffer);
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aByte : bytes) {
                stringBuilder.append(aByte);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean compare(String s1, String s2) {
        char[] f1 = s1.toCharArray();
        char[] f2 = s2.toCharArray();
        if (f1.length != f2.length) {
            throw new IllegalArgumentException("mismatch FingerPrint length");
        }
        int sameCount = 0;
        for (int i = 0; i < f1.length; ++i) {
            {
                if (f1[i] != f2[i]) {
                    ++sameCount;
                    if (sameCount > 10) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<String> sets = Sets.newConcurrentHashSet();
        sets.add("1");
        sets.add("2");
        sets.add("3");
        sets.add("4");
        sets.add("5");
        sets.add("6");
        AtomicBoolean flag = new AtomicBoolean(false);
        sets.parallelStream().forEach(set -> {
            if (set.equals(5)) {
                flag.set(true);
            }
        });
    }
}
