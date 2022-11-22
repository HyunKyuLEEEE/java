package day22;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Attendance {
	//출석부 클래스 : 학생들, 일지들
	private ArrayList<Student> stds = new ArrayList<Student>();
	private ArrayList<Log> logs = new ArrayList<Log>();
	
}
