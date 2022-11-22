package day22;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

//학생 클래스 : 이름, 생년월일
@Data
public class Student {
	private String name;
	private String birthday;
	
	public Student(String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	public Student(Student std) {
		this.name = std.name;
		this.birthday = std.birthday;
	}

	public void update(String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
	}
}
