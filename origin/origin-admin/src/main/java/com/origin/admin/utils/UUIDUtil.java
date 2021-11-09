package com.origin.admin.utils;

import cn.hutool.core.lang.UUID;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/11/5 21:37
 */
public class UUIDUtil {

    public static void main(String[] args) {
        String id = "RID"+"_"+UUID.randomUUID().toString().toLowerCase().replace("-", "");
        System.out.println(id.substring(0,26));
    }
}
