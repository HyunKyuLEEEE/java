package day27;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {

	/* 게시글 관리 프로그램
	 * - 회원가입
	 * 	 - 처음 가입한 회원이 관리자, 그외 회원인 일반 회원
	 * - 로그인
	 * - 게시글 등록/수정/삭제 => 회원만 가능
	 * - 카테고리 관리(공지, 자유)
	 * - 카테고리 추가/수정/삭제(관리자만 가능)
	 * */
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<User> userList = new ArrayList<User>();
		int menu = -1;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu, userList);
		}while(menu != 3);

	}
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	private static void printBar() {
		System.out.println("=================");
	}
	private static void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("3.종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
		
	}
	private static void printSubMenu() {
		System.out.println("=====서브 메뉴=====");
		System.out.println("1.게시글");
		System.out.println("2.카테고리");
		System.out.println("3.취소");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
	}
	private static void runMenu(int menu, ArrayList<User> userList) {
		switch(menu) {
		case 1:
			if(addUser(userList)) {
				printStr("회원정보가 추가되었습니다.");
			}else {
				printStr("이미 등록된 아이디입니다.");
			}
			break;
		case 2:
			if(login(userList) == null) {
				break;
			}else {
				printSubMenu();
				int subMenu = sc.nextInt();
				runSubMenu(subMenu);
			}
			break;
		case 3:
			printStr("프로그램 종료!");
			break;
		default:
			printStr("잘못된 메뉴입니다.");
		}
	}
	private static void runSubMenu(int subMenu) {
		switch(subMenu) {
		case 1:
			//boardManager();
			break;
		case 2:
			//kategorieManager();
			break;
		case 3:
			printStr("취소되었습니다.");
			break;
		default:
			printStr("잘못된 메뉴입니다.");
		}
	}
	private static boolean addUser(ArrayList<User> userList) {
		sc.nextLine();
		printStr("회원정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("주민번호 : ");
		String residentNumber = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		User user = new User(id, pw, name, residentNumber, age);
		
		if(userList.contains(user))
			return false;
		
		userList.add(user);
		return true;
	}
	private static User login(ArrayList<User> userList) {
		sc.nextLine();
		System.out.println("======로그인======");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		User user = new User(id, pw);
		
		int index = userList.indexOf(user);
		if(index == -1)
			return null;
		User temp = userList.get(index);
		
		if(temp.getPw().equals(user.getPw()))
			return null;
		return temp;
	}
}
