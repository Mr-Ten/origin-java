package com.origin.admin.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/10/28 21:39
 */
public class CodeGenerator {

    public static void main(String[] args) {
        codeGeneration("admin_role");

        //System.out.println(System.getProperty("user.dir"));
    }

    public static void codeGeneration(String... table){
        //代码生成器
        AutoGenerator generator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        final String property = System.getProperty("user.dir")+"/origin-admin";
        globalConfig.setOutputDir(property+"/src/main/java")
                .setAuthor("MrTen")
                .setOpen(false) //是否打开输出目录
                .setActiveRecord(true) //开启 ActiveRecord 模式
                .setEnableCache(false) //是否在xml中添加二级缓存
                .setBaseResultMap(true) //XML 开启 BaseResultMap
                .setDateType(DateType.ONLY_DATE)
                .setSwagger2(true);
        generator.setGlobalConfig(globalConfig);

        //配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://47.110.32.58:3306/origin?useUnicode=true&characterEncoding=UTF-8&useSSL=false")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("admin")
                .setPassword("1234")
                .setDbType(DbType.MYSQL);
        generator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.origin.admin")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper.auto")
                .setEntity("entity.po");
        generator.setPackageInfo(packageConfig);

        //自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                //TODO: nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        //自定义输出配置
        List<FileOutConfig> fileOutConfigs = new ArrayList<FileOutConfig>();
        fileOutConfigs.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return property + "/src/main/resources/mapper/auto/" + "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigs);
        generator.setCfg(injectionConfig);

        //配置模版
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        generator.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setEntityTableFieldAnnotationEnable(false)
                .setControllerMappingHyphenStyle(true)
                .setInclude(table);

        generator.setStrategy(strategyConfig);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }
}
