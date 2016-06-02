package com.henry.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static InputStream in;
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
        // 1. 加载MyBatis的配置文件：mybatis.xml（它也加载关联的映射文件，也就是mappers结点下的映射文件）
        in = MybatisUtil.class.getClassLoader().getResourceAsStream("Mybatis.xml");
        // 2. SqlSessionFactoryBuidler实例将通过输入流调用build方法来构建 SqlSession 工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}
	
	public static void release(SqlSession session) {
		if(session!=null) {
			session.close();
		}
	}
}
