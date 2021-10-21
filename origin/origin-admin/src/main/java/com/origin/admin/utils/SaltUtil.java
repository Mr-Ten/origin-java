package com.origin.admin.utils;

import lombok.val;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/7/27 16:36
 */
public class SaltUtil {
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            char c = chars[new Random().nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String PARENT = "123456";
        String SALT = getSalt(6);
        System.out.println(SALT);
        val s = MD5Encryption(PARENT, SALT);
        System.out.println(s);
    }

    public static String MD5Encryption(String parent, String salt){
        Md5Hash md5Hash = new Md5Hash(parent, salt, 1024);
        return md5Hash.toHex();
    }
}
