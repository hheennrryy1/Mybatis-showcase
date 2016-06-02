package com.henry.test;

import org.junit.Ignore;
import org.junit.Test;

import com.henry.dao.StudentDao;
import com.henry.entity.Student;

public class StudentDaoTest {
	@Test
	public void testSelect() {
		StudentDao dao = new StudentDao();
		Student student = dao.select();
		System.out.println(student.getName());
	}
	
	@Ignore
	@Test
	public void testDelete() {
		StudentDao dao = new StudentDao();
		dao.delete();
	}
}
