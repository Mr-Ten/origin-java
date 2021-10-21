package com.origin.admin.config;

import com.origin.admin.utils.CommonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/10/14 21:35
 */
@Order(100)
@Component
@Log4j2
public class StartFinishesLoading implements CommandLineRunner {

    @Value("${swagger.autoOpenEnable}")
    private Boolean swaggerAutoOpenEnable;

    @Value("${spring.profiles.active}")
    private String profiles;

    @Value("${server.port}")
    private Integer port;

    @Override
    public void run(String... args) throws Exception {
        openSwaggerPage();
    }

    public void openSwaggerPage() throws Exception {
        if (!swaggerAutoOpenEnable){
            return;
        }
        if(!CommonUtil.isLinux()){
            String ip = InetAddress.getLocalHost().getHostAddress();
            String cmd = "open http://"+ip+":"+port+"/swagger-ui.html";
            final Runtime runtime = Runtime.getRuntime();
            log.info("Swagger访问地址：{}", cmd.split(" ")[1]);
            runtime.exec(cmd);
        }
    }
}
