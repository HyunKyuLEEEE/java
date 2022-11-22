package day22;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Log {
	//일지 클래스 : 날짜, 학생일지들(이름, 생년월일, 출결)
	private ArrayList<StudentLog> slogs = new ArrayList<StudentLog>();
	private String date;
	
	public Log(ArrayList<Student> stds, String date) {
		this.date = date;
		for(Student std : stds) {
			StudentLog slog = new StudentLog(std, null);
			slogs.add(slog);
		}
	}
}
