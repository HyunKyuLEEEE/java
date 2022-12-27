package db.day03.service;

import java.util.Scanner;

import db.day03.DBConnector;
import db.day03.dao.*;
import db.day03.vo.*;

public class ProfessorServiceImp implements ProfessorService{

	private ProfessorMapper professorDao;
	private StudentMapper studentDao;
	private Scanner sc = new Scanner(System.in);
	
	public ProfessorServiceImp(DBConnector dbConnector) {
		professorDao = new ProfessorMapper(dbConnector);
		studentDao = new StudentMapper(dbConnector);
	}

	public void insertProfessor() {
		System.out.println("추가할 교수 정보를 입력하세요.");
		System.out.print("교번 : ");
		String pr_num = sc.nextLine();
		System.out.print("이름 : ");
		String pr_name = sc.nextLine();
		System.out.print("상태 : ");
		String pr_state = sc.nextLine();
		System.out.print("학부번호 : ");
		String pr_de_num = sc.nextLine();
		System.out.print("전호번호 : ");
		String pr_tel = sc.nextLine();
		ProfessorVO professorVO = new ProfessorVO(pr_num, pr_name, pr_state,
				pr_de_num, pr_tel);
		
		professorDao.insertProfessor(professorVO);
	}

	public void updateProfessor() {
		System.out.println("수정할 교수 정보를 입력하세요.");
		System.out.print("교번 : ");
		String pr_num = sc.nextLine();
		System.out.print("이름 : ");
		String pr_name = sc.nextLine();
		System.out.print("상태 : ");
		String pr_state = sc.nextLine();
		System.out.print("학부번호 : ");
		String pr_de_num = sc.nextLine();
		System.out.print("전호번호 : ");
		String pr_tel = sc.nextLine();
		ProfessorVO professorVO = new ProfessorVO(pr_num, pr_name, pr_state,
				pr_de_num, pr_tel);
		
		professorDao.updateProfessor(professorVO);
		
	}

	public void updateAdvisor() {
		System.out.print("교수번호 : ");
		String st_pr_num = sc.nextLine();
		System.out.print("학번 : ");
		String st_num = sc.nextLine();
		
		StudentVO std = studentDao.selectStudent(st_num);
		if(std == null) {
			System.out.println("학번이 존재하지 않아 지도 교수 수정에 실패했습니다.");
			return;
		}
		std.setSt_pr_num(st_pr_num);
		studentDao.updateStudent(std);
	}
}
