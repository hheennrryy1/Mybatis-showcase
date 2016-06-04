package com.henry.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import com.henry.entity.Student;
import com.henry.mapper.StudentMapper;
import com.henry.util.MybatisUtil;

public class StudentDaoTest {
	@Test
	@Ignore
	public void testSelect() {
		SqlSession session = MybatisUtil.openSession(); //事务开始
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			int id = 1;
			Student student = mapper.selectStudent(id);
			System.out.println(student.getName());
		} catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	@Ignore
	@Test
	public void testDelete() {
		SqlSession session = MybatisUtil.openSession();//事务开始  
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			int id = 1;
			mapper.deleteStudent(id);
			//int i = 1/0;
			session.commit();//提交事务  
		} catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	@Ignore
	public void testInsert() {
		SqlSession session = MybatisUtil.openSession();//事务开始  
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = new Student();
			student.setId(4);
			student.setName("amy");
			student.setBirth(new Date());
			mapper.insertStudent(student);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testUpdate() {
		SqlSession session = MybatisUtil.openSession();//事务开始  
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = new Student();
			student.setId(3);
			student.setName("stark");
			student.setBirth(new Date());
			mapper.updateStudent(student);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}		
	}
}
