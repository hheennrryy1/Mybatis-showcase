package com.henry.mapper;

import java.util.List;

import com.henry.entity.Score;
import com.henry.entity.Student;

public interface ScoreMapper {
	public List<Score> selectScore(Score score);
}
