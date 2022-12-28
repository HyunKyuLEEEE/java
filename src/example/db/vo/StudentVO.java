package example.db.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {
	private String st_num;
	private String st_name;
	private int st_semester;
	private String st_state;
	private String st_pr_num;
	
	public StudentVO(String st_name, int st_semester, String st_state, String st_pr_num) {
		this.st_name = st_name;
		this.st_semester = st_semester;
		this.st_state = st_state;
		this.st_pr_num = st_pr_num;
	}

	public StudentVO(String st_num, int st_semester, String st_state) {
		super();
		this.st_num = st_num;
		this.st_semester = st_semester;
		this.st_state = st_state;
	}
	
	
}
