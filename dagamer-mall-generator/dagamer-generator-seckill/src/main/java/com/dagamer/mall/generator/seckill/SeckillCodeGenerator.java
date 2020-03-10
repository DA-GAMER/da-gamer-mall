package com.dagamer.mall.generator.seckill;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class SeckillCodeGenerator {

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
        pc.setParent(rb.getString("package.parent"))
                .setEntity("model.domain")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setXml("mapper");
        mpg.setPackageInfo(pc);

        /* 自定义配置 */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                // 自定义配置，在模版中cfg.superColums 获取
                // 这里解决子类会生成父类属性的问题，在模版里会用到该配置
                map.put("superColumns", this.getConfig().getStrategyConfig().getSuperEntityColumns());
                this.setMap(map);
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
        templateConfig.setController(null)
                .setEntity("/templates/entity.java.vm")
                .setXml(null);
        mpg.setTemplate(templateConfig);

        /* 数据库表配置 */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setSuperEntityClass("com.dagamer.mall.common.domain.BaseDomain")
                .setSuperEntityColumns("id","create_time","update_time")
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setInclude(StringUtils.split(rb.getString("table.list"), ","))
                .setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute();
    }

}
