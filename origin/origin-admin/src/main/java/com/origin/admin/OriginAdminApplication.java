package com.origin.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
* <pre>
*
* </pre>
*
* @author: Simon
* @Date:  2021/8/16 11:53
*/
@SpringBootApplication
@ComponentScan(basePackages = {"com.origin.admin.*"})
public class OriginAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(OriginAdminApplication.class, args);
    }

}
