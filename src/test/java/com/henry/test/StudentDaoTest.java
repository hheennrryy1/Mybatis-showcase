package com.henry.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import com.henry.entity.Student;
import com.henry.mapper.StudentMapper;
import com.henry.util.MybatisUtil;

public class StudentDaoTest {
	@Ignore
	@Test
	public void testSelect1() {
		SqlSession session = MybatisUtil.openSession(); //事务开始  
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		int id = 1;
		Student student = mapper.selectStudent(id);
		System.out.println(student.getName());
	}
	
	@Test
	public void testDelete() {
		SqlSession session = MybatisUtil.openSession();//事务开始  
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		int id = 1;
		mapper.deleteStudent(id);
		//int i = 1/0;
		session.commit();//提交事务  
		MybatisUtil.release(session);
	}
}
