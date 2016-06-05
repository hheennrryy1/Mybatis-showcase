package com.henry.entity;

public class Score {
	private int id;
	private int score;
	private String subject;
	private Student student;
	
	@Override
	public String toString() {
		return "Score [id=" + id + ", score=" + score + ", subject=" + subject + ", student=" + student + "]";
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
