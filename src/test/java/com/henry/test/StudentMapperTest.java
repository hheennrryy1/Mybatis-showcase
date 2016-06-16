package com.henry.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import com.henry.entity.Student;
import com.henry.mapper.StudentMapper;
import com.henry.util.MybatisUtil;

public class StudentMapperTest {
	@Test
	@Ignore
	public void testSelect() {
		SqlSession session = MybatisUtil.openSession(); //事务开始
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			int id = 1;
			Student student = mapper.selectStudent(id);
			System.out.println(student.getScores().size());
			student.getScores().forEach(s -> System.out.println(s));
		} catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testCache() {
		SqlSession session = MybatisUtil.openSession(); //事务开始
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		mapper.selectStudent(1);
		session.close();
		
		SqlSession session1 = MybatisUtil.openSession(); //事务开始
		StudentMapper mapper1 = session1.getMapper(StudentMapper.class);
		mapper1.selectStudent(1);
		session1.close();
	}
	
	
	@Test
	@Ignore
	public void testQuery() {
		SqlSession session = MybatisUtil.openSession(); //事务开始
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			List<Student> students = mapper.queryStudent(Arrays.asList(1, 3, 4));
			students.forEach(s -> System.out.println(s.getName()));
		} catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	@Ignore
	public void testSelectByName() {
		SqlSession session = MybatisUtil.openSession(); //事务开始
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = new Student();
			student.setName("he");
			List<Student> students = mapper.selectStudentByName(student);
			System.out.println(students.size());
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
	@Ignore
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
