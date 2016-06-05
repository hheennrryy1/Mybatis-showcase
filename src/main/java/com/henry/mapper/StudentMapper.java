package com.henry.mapper;
import java.util.List;

import com.henry.entity.Student;

public interface StudentMapper {
	/**
	 * 直接通过注解，不用xml，但不灵活
	 */
/*	@Select("select * from student where id = #{id}")
	public Student selectStudent(Integer id);*/
	
	//方法名要和xml中id相同
	public Student selectStudent(int id);
	
	public List<Student> selectStudentByName(Student student);
	
	public List<Student> queryStudent(List<Integer> list);
	
	public void deleteStudent(int id);
	
	public void insertStudent(Student student);
	
	public void updateStudent(Student student);
}
