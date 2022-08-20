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

/**
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 自动生成工具</P>
 */
public class MyGenerator {
		/////////////////项目基础包前缀//////////////////////
		private static final String basePackage = "cn.axg.common";

		// 基础信息：项目名、作者、版本
		public static final String PROJECT = "commons-api";
		public static final String AUTHOR = "anxiaoguo";
		public static final String VERSION = "V1.0";
		// 数据库连接信息：连接URL、用户名、秘密、数据库名
		public static final String URL = "jdbc:mysql:///ssm?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
		public static final String NAME = "root";
		public static final String PASS = "root";
		public static final String DATABASE = "ssm";
		// 类信息：类名、对象名（一般是【类名】的首字母小些）、类说明、时间
		public static final String CLASSNAME = "Book";
		public static final String TABLE = "book";
		public static final String CLASSCOMMENT = "书籍表";
		public static final String TIME = "2019年6月12日";
		public static final String AGILE = new Date().getTime() + "";
		// 路径信息，分开路径方便聚合工程项目，微服务项目
		public static final String ENTITY_URL = basePackage+".model";
		public static final String DAO_URL = basePackage+".mapper";
		public static final String XML_URL = basePackage+".mapper";
		public static final String SERVICE_URL = basePackage+".service";
		public static final String SERVICE_IMPL_URL = basePackage+".service.impl";
		public static final String CONTROLLER_URL = basePackage+".controller";
		//是否是Swagger配置
		public static final String IS_SWAGGER = "true";
		
	public static void main(String[] args) {
		BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,
				DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL,IS_SWAGGER);
		bi.setTable(TABLE);
		bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
		bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
		bi.setEntityComment(CLASSCOMMENT);
		try {
			bi = EntityInfoUtil.getInfo(bi);
			String fileUrl = "D:\\project\\cloud-study\\commons-api\\src\\main\\java\\";// 生成文件存放位置
			//项目命名要规范，路径名和项目名中不能包含java字眼
			String mapperUrl = fileUrl.replaceFirst("java", "resources");

			//开始生成文件
			String aa1 = Generator.createEntity(fileUrl, bi).toString();
			String aa2 = Generator.createDao(fileUrl, bi).toString(); 
			String aa3 = Generator.createDaoImpl(mapperUrl, bi).toString();
			String aa4 = Generator.createService(fileUrl, bi).toString(); 
			String aa5 = Generator.createServiceImpl(fileUrl, bi).toString(); 
			String aa6 = Generator.createController(fileUrl, bi).toString();
			// 是否创建swagger配置文件
			String aa7 = Generator.createSwaggerConfig(fileUrl, bi).toString();
			
			System.out.println(aa1);
			System.out.println(aa2); System.out.println(aa3); System.out.println(aa4);
			System.out.println(aa5); System.out.println(aa6); System.out.println(aa7);
			
			//System.out.println(aa7);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
