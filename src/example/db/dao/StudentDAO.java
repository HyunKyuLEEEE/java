package example.db.dao;

import java.util.ArrayList;

import example.db.vo.StudentVO;
import example.db.vo.StudentVO2;

public interface StudentDAO {
	
	
	ArrayList<StudentVO> selectAllStudent();

	public void selectStudent();

	int insertStudent(StudentVO std);

	int updateStudent(StudentVO std);

	StudentVO selectStudent(String st_num);

	ArrayList<StudentVO2> selectAllStudent2();

}
