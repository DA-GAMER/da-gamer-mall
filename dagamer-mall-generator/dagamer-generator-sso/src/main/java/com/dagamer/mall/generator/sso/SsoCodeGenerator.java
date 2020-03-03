package com.dagamer.mall.generator.sso;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SsoCodeGenerator {

    public static void main(String[] args) {

        // 获取mybatis-plus.properties文件属性
        final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");

        AutoGenerator mpg = new AutoGenerator();

        final String PROJECT_PATH = System.getProperty("user.dir") + rb.getString("generator.target.project.path");

        /* 全局配置 */
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + "/src/main/java")
                .setFileOverride(false)
                .setOpen(false)
                .setEnableCache(false)
                .setAuthor("DaGamer")
                .setKotlin(false)
                .setSwagger2(true)
                .setActiveRecord(false)
                .setBaseResultMap(false)
                .setBaseColumnList(false)
                .setDateType(DateType.TIME_PACK)
                .setEntityName(null)
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName(null)
                .setIdType(null);
        mpg.setGlobalConfig(gc);

        /* 数据源配置 */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
                .setUrl(rb.getString("mysql.url"))
                .setDriverName(rb.getString("mysql.driver.name"))
                .setUsername(rb.getString("mysql.username"))
                .setPassword(rb.getString("mysql.password"));
        mpg.setDataSource(dsc);

        /* 包名配置 */
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.dagamer.mall.generator.sso")
                .setEntity("model/domain")
                .setService("service")
                .setServiceImpl("service/impl")
                .setMapper("mapper")
                .setXml("mapper");
        mpg.setPackageInfo(pc);

        /* 自定义配置 */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        String templatePath = "/templates/mapper.xml.vm";
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PROJECT_PATH + "/src/main/resources/mapper/" +
                        tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        /* 模板配置 */
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("").setXml(null);
        mpg.setTemplate(templateConfig);

        /* 数据库表配置 */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setInclude("uoc_user")
                .setControllerMappingHyphenStyle(true)
                .setTablePrefix(rb.getString("table_prefix"));
        mpg.setStrategy(strategy);
        mpg.execute();
    }

}
