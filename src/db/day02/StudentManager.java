package db.day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	
	Connection con;
	static Scanner sc = new Scanner(System.in);
	static StudentDAOImp studentDao;
	public static void main(String[] args) {
		StudentManager sm = new StudentManager();
		
		String url = "jdbc:mysql://localhost/university";
		String id = "root", pw = "root";
		
        try {
			sm.connect(url, "root", "root");
			studentDao = new StudentDAOImp(sm.con);
			
			int menu = -1;
			do {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine();
				runMenu(menu);
				
			}while(menu != 5);
		
        } catch(Exception e) {
        	System.out.println("예외 발생 : 프로그램 종료.");
        	e.printStackTrace();
        }finally {
        	sm.closeConnect();
        }
	}
	
	private static void runMenu(int menu) throws Exception {
		switch(menu) {
		case 1:
			printStudentList();
			break;
		case 2:
			insertStudent();
			break;
		case 3:
			updateStudent();
			break;
		case 4:
			deleteStudent();
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
	}

	private static void updateStudent() {
		int subMenu = -1;
		printSubMenu();
		subMenu = sc.nextInt();
		sc.nextLine();
		System.out.println("학번 : ");
		String st_num = sc.nextLine();
		String st_name = null, st_state = null, st_pr_num = null;
		int st_semester = 0;
		switch(subMenu) {
		case 1:
			System.out.println("이름 : ");
			st_name = sc.nextLine();
			break;
		case 2:
			System.out.println("학기 : ");
			st_semester = sc.nextInt();
			break;
		case 3:
			System.out.println("상태 : ");
			st_state = sc.nextLine();
			break;
		case 4:
			System.out.println("지도교수번호 : ");
			st_pr_num = sc.nextLine();
			break;
		case 5:
			System.out.println("취소합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
		StudentVO1 std = new StudentVO1(st_num, st_name, st_semester, st_state, st_pr_num);
		studentDao.updateStudent(std, subMenu);
	}

	private static void printSubMenu() {
		System.out.println("수정 메뉴");
		System.out.println("1. 이름 수정");
		System.out.println("2. 학기 수정");
		System.out.println("3. 상태 수정");
		System.out.println("4. 지도 교수 수정");
		System.out.println("5. 취소");
		System.out.print("메뉴 선택 : ");
		
	}

	private static void deleteStudent() {
		System.out.println("학번 : ");
		String st_num = sc.nextLine();
		if(studentDao.deleteStudent(st_num))
			System.out.println("학생을 삭제했습니다.");
		else
			System.out.println("학생을 삭제하지 못했습니다.");
	}

	private static void insertStudent() {
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
		if(studentDao.insertStudent(new StudentVO1(st_num, st_name, st_semester, st_state, st_pr_num)))
			System.out.println("학생을 추가했습니다.");
		else
			System.out.println("학생을 추가하지 못했습니다.");
		
		
	}

	private static void printStudentList() throws Exception {
		List<StudentVO1> list = studentDao.selectAllStudent();
		if(list.size() == 0) {
			System.out.println("등록된 학생이 없습니다.");
		}else {
			for(StudentVO1 temp : list)
				System.out.println(temp);
		}
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 조회 (전체)");
		System.out.println("2. 학생 추가");
		System.out.println("3. 학생 수정");
		System.out.println("4. 학생 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

	public void connect(String url, String id, String pw) throws SQLException {
		con = DriverManager.getConnection(url, id, pw);
	}
	
	public void closeConnect() {
		try{
            if( con != null && !con.isClosed()){
                con.close();
            }
            
        }
        catch( SQLException e){
            e.printStackTrace();
        }
	}


}
