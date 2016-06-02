package com.henry.dao;

import org.apache.ibatis.session.SqlSession;

import com.henry.entity.Student;
import com.henry.util.MybatisUtil;

public class StudentDao {
	
	public Student select() {
		SqlSession session = MybatisUtil.openSession(); 
        String statement = "com.henry.entity.StudentMapper.selectStudent";
        int parameter = 1;
        Student student = session.selectOne(statement, parameter);
        MybatisUtil.release(session);
        return student;
	}
	
	public void delete() {
		SqlSession session = MybatisUtil.openSession(); 
		String statement = "com.henry.entity.StudentMapper.deleteStudent";
		int parameter = 1;
		session.delete(statement, parameter);
		MybatisUtil.release(session);
	}
}
