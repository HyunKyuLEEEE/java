package day22;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Log {
	//일지 클래스 : 날짜, 학생일지들(이름, 생년월일, 출결)
	private ArrayList<StudentLog> slogs = new ArrayList<StudentLog>();
	private String date;
	
	public Log(ArrayList<StudentLog> stdLogs, String date) {
		this.date = date;
		this.slogs = stdLogs; // 원래는 깊은 복사를 해야 하는데 간단하게 얕은 복사를 이용
	}
}
