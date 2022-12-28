package db.day04.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.day04.vo.CourseVO;
import db.day04.vo.StudentVO;

public interface StudentDAO {
	
	ArrayList<StudentVO> selectAllStudent();

	void insertStudent(@Param("std")StudentVO std);
	//param을 꼭쓰는 경우는 매개변수가 2개 이상인 경우 

	void insertCourse(CourseVO co);
}
