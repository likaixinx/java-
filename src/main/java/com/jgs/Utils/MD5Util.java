package com.jgs.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author likaixin
 * @ClassName com.jr.Utils.MD5Util
 * @create 2022年010月2日 10:47
 * @desc: md5哈希算法 加密密码  不让密码明文显示
 */
public class MD5Util {
    public static String digest(String content) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md5.digest(content.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(digest);
        return new String(encode);
    }
}
