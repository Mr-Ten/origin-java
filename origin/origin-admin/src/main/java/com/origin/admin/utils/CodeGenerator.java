package com.origin.admin.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.origin.admin.constants.ConstantUtil;

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

    private static final String property = System.getProperty("user.dir")+ConstantUtil.ADMIN_MODULE_NAME;

    public static void main(String[] args) {
        String[] tables = {"roles_menu", "menu"};
        codeGeneration(tables);
        System.out.println("自动化生成代码完成...");
    }

    public static void codeGeneration(String... table){

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(property+"/src/main/java")
                .setAuthor("MrTen")
                .setOpen(false) //是否打开输出目录
                .setFileOverride(true) //覆盖已有文件
                .setActiveRecord(true) //开启 ActiveRecord 模式，继承Model类
                .setEnableCache(false) //是否在xml中添加二级缓存
                .setBaseResultMap(true) //XML 开启 BaseResultMap
                .setDateType(DateType.ONLY_DATE)
                .setSwagger2(true);


        //配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://47.110.32.58:3306/origin?useUnicode=true&characterEncoding=UTF-8&useSSL=false&tinyInt1isBit=false")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("admin")
                .setPassword("1234")
                .setDbType(DbType.MYSQL)
                .setTypeConvert(new MySqlTypeConvertCustom());


        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.origin.admin")
                .setController(null)
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setEntity("entity.po");


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
                return property + "/src/main/resources/mapper/" + "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigs);


        //配置模版
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null)
                    .setController(""); //设置不生成controller


        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("create_time", FieldFill.INSERT));
        tableFills.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        tableFills.add(new TableFill("is_deleted", FieldFill.INSERT));
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setEntityTableFieldAnnotationEnable(false)
                .setControllerMappingHyphenStyle(true)
                .setVersionFieldName("version")
                .setLogicDeleteFieldName("is_deleted")
                .setTableFillList(tableFills)
                .setInclude(table);

        //代码生成器
        AutoGenerator generator = new AutoGenerator();
        generator.setGlobalConfig(globalConfig) //全局配置
                .setDataSource(dataSourceConfig) //数据源配置
                .setPackageInfo(packageConfig) //包配置
                .setCfg(injectionConfig) //自定义配置
                .setTemplate(templateConfig) //模版配置
                .setStrategy(strategyConfig) //策略配置
                .setTemplateEngine(new FreemarkerTemplateEngine()) //设置使用freemarker模版引擎
                .execute(); //启动
    }
}

class MySqlTypeConvertCustom extends MySqlTypeConvert implements ITypeConvert {
    @Override
    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        final String s = fieldType.toLowerCase();
        if(s.contains(ConstantUtil.TINYINT)){
            return DbColumnType.INTEGER;
        }
        return super.processTypeConvert(globalConfig, fieldType);
    }
}
