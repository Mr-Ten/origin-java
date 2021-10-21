package com.origin.admin.utils;

import com.origin.admin.constants.ConstantUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 系统工具类
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/10/13 22:49
 */
@Log4j2
@Component
public class CommonUtil {

    /**
     * 获取当前操作系统
     * @return
     */
    public static String getSystem(){
        return System.getProperties().getProperty("os.name");
    }

    /**
     * 查看当前系统是否是linux
     * @return
     */
    public static Boolean isLinux(){
        final String system = getSystem();
        if(ConstantUtil.SYSTEM_LINUX.equals(system)){
            return true;
        }
        return false;
    }
}
