/**
 * @filename:UserController 2019年4月9日
 * @project wallet-manage  V1.0
 * Copyright(c) 2018 flying-cattle Co. Ltd.
 * All right reserved.
 */
package com.flying.cattle.mdg;

import com.github.flying.cattle.mdg.entity.BasisInfo;
import com.github.flying.cattle.mdg.util.EntityInfoUtil;
import com.github.flying.cattle.mdg.util.Generator;
import com.github.flying.cattle.mdg.util.MySqlToJavaUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2019
 *
 * <p>说明： 自动生成工具</P>
 */
public class MyGenerator {
    // 基础信息：项目名、作者、版本
    public static final String PROJECT = "seata-study-stock";
    public static final String AUTHOR = "安晓国";
    public static final String VERSION = "V1.0";
    // 数据库连接信息：连接URL、用户名、秘密、数据库名
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/stock?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    public static final String NAME = "root";
    public static final String PASS = "root";
    public static final String DATABASE = "stock";
    // 类信息：类名、对象名（一般是【类名】的首字母小些）、类说明、时间
    //public static final String CLASSNAME = "LiveProductActivity";
    public static final String TABLE = "admin_user";
    public static final String CLASSCOMMENT = "用户信息表";
    public static final String TIME = "2022年8月20日";
    public static final String AGILE = new Date().getTime() + "";
    //是否是Swagger配置
    public static final String IS_SWAGGER = "true";
    /////////////////项目基础包前缀//////////////////////
    private static final String basePackage = "com.axg.cloud.study";
    private static final String modelName = "";
    public static final String SERVICE_URL = basePackage + ".service";
    public static final String SERVICE_IMPL_URL = basePackage + ".service.impl";
    public static final String CONTROLLER_URL = basePackage + ".controller";
    // 路径信息，分开路径方便聚合工程项目，微服务项目
    public static final String ENTITY_URL = "com.axg.cloud.study.model." + modelName;
    public static final String DAO_URL = "com.axg.cloud.study.mapper." + modelName;
    public static final String XML_URL = "mapper." + modelName;
    private static final String mapperFileUrl = "D:\\project\\cloud-study\\seata-study-stock\\src\\main\\java\\";// 生成文件存放位置
    private static final String mapperXmlUrl = "D:\\project\\cloud-study\\seata-study-stock\\src\\main\\resources\\";// 生成文件存放位置

    private static final String fileUrl = "D:\\project\\cloud-study\\seata-study-stock\\src\\main\\java\\";// 生成文件存放位置

    public static void main(String[] args) {
        Map<String, String> tables = new HashMap<>();
        tables.put("stock_at", "库存表");
        /*
        tables.put("shop_user", "商户用户信息表");
        tables.put("shop_wallet", "商户钱包表");
        tables.put("shop_withdraw", "商户提现记录表");*/
        tables.forEach((s, s2) -> {
            BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,
                DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL, IS_SWAGGER);
            bi.setTable(s);
            bi.setEntityName(MySqlToJavaUtil.getClassName(s));
            bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(s));
            bi.setEntityComment(s2);
            try {
                BasisInfo bi2 = EntityInfoUtil.getInfo(bi);
                //开始生成文件
                String aa1 = Generator.createEntity(mapperFileUrl, bi2).toString();
                String aa2 = Generator.createDao(mapperFileUrl, bi2).toString();
                String aa3 = Generator.createDaoImpl(mapperXmlUrl, bi2).toString();
                String aa4 = Generator.createService(fileUrl, bi2).toString();
                String aa5 = Generator.createServiceImpl(fileUrl, bi2).toString();
                String aa6 = Generator.createController(fileUrl, bi2).toString();

                System.out.println(aa1);
                System.out.println(aa2);
                System.out.println(aa3);
                System.out.println(aa4);
                System.out.println(aa5);
                System.out.println(aa6);

                // 是否创建swagger配置文件
                /*String aa7 = Generator.createSwaggerConfig(fileUrl, bi2).toString();
                System.out.println(aa7);*/

                //System.out.println(aa7);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }
}
