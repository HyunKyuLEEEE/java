package day14;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import lombok.Data;

@Data
public class Student {
	//필드 : 학년, 반, 번호, 이름, 성적들
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private ArrayList<Score> scoreList = new ArrayList<Score>();
	
	
	/**
	 * 학생 정보에 성적을 추가하는 메소드
	 * @param 추가할 성적
	 * @return 추가 여부
	 */
	
	public boolean addScore(Score score) {
		if(score == null) {
			throw new RuntimeException("성적 정보가 없어서 추가할 수 없습니다.");
		}
		
		//선택한 학생의 성적 정보들 중에서 과목, 학기가 같은 성적 정보가 없으면 추가
		boolean res = scoreList.contains(score);
		if(res) {
			return false;
		}
		scoreList.add(new Score(score));
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "[" + grade + "학년 " + classNum + "반 " + num + "번 " + name + "]";
	}

	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	public Student(int grade, int classNum, int num) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}

	
	public void printScore() {
		for(Score temp : scoreList) {
			System.out.println(temp);
		}
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}
}
