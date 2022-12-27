package db.day03.service;

import java.util.Scanner;

import db.day03.DBConnector;
import db.day03.dao.StudentMapper;
import db.day03.vo.StudentVO;

public class StudentServiceImp implements StudentService{

	private StudentMapper studentDao;
	private Scanner sc = new Scanner(System.in);
	
	public StudentServiceImp(DBConnector dbConnector) {
		studentDao = new StudentMapper(dbConnector);
	}

	public void insertStudent() {
		System.out.println("추가할 학생 정보를 입력하세요.");
		System.out.print("학번 : ");
		String st_num = sc.nextLine();
		System.out.print("이름 : ");
		String st_name = sc.nextLine();
		System.out.print("학기 : ");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.print("상태 : ");
		String st_state = sc.nextLine();
		System.out.print("지도교수번호 : ");
		String st_pr_num = sc.nextLine();
		StudentVO std = new StudentVO(st_num, st_name, st_semester, st_state, st_pr_num);
		studentDao.insertStudent(std);
	}

	public void updateStudent() {
		System.out.println("수정할 학생 정보를 입력하세요.");
		System.out.print("학번 : ");
		String st_num = sc.nextLine();
		System.out.print("이름 : ");
		String st_name = sc.nextLine();
		System.out.print("학기 : ");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.print("상태 : ");
		String st_state = sc.nextLine();
		System.out.print("지도교수번호 : ");
		String st_pr_num = sc.nextLine();
		StudentVO std = new StudentVO(st_num, st_name, st_semester, st_state, st_pr_num);
		studentDao.updateStudent(std);
		
	}

}
