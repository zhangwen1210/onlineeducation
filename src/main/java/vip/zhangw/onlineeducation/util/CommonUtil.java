package vip.zhangw.onlineeducation.util;

import java.security.MessageDigest;

/**
 * @program: onlineeducation->CommonUtil
 * @description: 通用工具类
 * @author: zhangwen
 * @create: 2020-08-08 14:57
 **/
public class CommonUtil {

    /**
     * MD5工具加密
     * @param data
     * @return
     */
    public static String MD5(String data) {
        try {
            java.security.MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) |
                        0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;
    }


}
