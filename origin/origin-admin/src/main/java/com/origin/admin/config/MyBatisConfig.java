package com.origin.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/10/19 23:36
 */
@Configuration
@MapperScan("com.origin.admin.mapper.**")
public class MyBatisConfig {
}
