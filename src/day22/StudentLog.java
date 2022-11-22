package day22;

import lombok.Data;

@Data
public class StudentLog{
	//학생 일지 클래스 : 이름, 생년월일, 출결(학생클래스 포함)
	private Student std;
	private String state;
	
	public StudentLog(String name, String birthday, String state) {
		std = new Student(name, birthday);
		this.state = state;
	}
	
	public StudentLog(Student std, String state) {
		this.std = new Student(std);
		this.state = state;
	}
}
