package com.henry.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.henry.entity.Score;
import com.henry.entity.Student;
import com.henry.mapper.ScoreMapper;
import com.henry.util.MybatisUtil;

public class ScoreMapperTest {
	@Test
	public void testSelect() {
		SqlSession session = MybatisUtil.openSession();
		ScoreMapper mapper = session.getMapper(ScoreMapper.class);
		Score score = new Score();
		//score.setSubject("math");
		Student student = new Student();
		student.setId(1);
		score.setStudent(student);
		List<Score> scores = mapper.selectScore(score);
		scores.forEach(s -> System.out.println(s.getStudent().getName()));
	}
}
