package day17;

import java.util.HashMap;
import java.util.Scanner;

public class UserManagerMapMain {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int menu = -1;
		HashMap<String, Member> map = new HashMap<String, Member>();
		do {
			System.out.println("------메뉴------");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 종료");
			System.out.println("--------------");
			System.out.print("메뉴 선택 : ");
			
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				if(addMember(map)) {
					System.out.println("회원 정보가 추가됐습니다.");
				}else {
					System.out.println("이미 가입된 아이디입니다.");
				}
				break;
			case 2:
				if(!searchMember(map)) {
					System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
				}
				break;
			case 3:
				if(updateMember(map)) {
					System.out.println("회원 정보를 수정했습니다.");
				}else {
					System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
				}
				break;
			case 4:
				if(deleteMember(map)) {
					System.out.println("회원 정보를 삭제했습니다.");
				}else {
					System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}while(menu != 5);
	}
		
	public static boolean addMember(HashMap<String, Member> map) {
		if(map == null) {
			throw new RuntimeException("예외 발생 : Map이 null입니다.");
		}
		System.out.println("회원 정보를 입력하세요.");
		System.out.print("아이디 :");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주민번호 : ");
		String residentNumber = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		//map에 있는지 확인
		//id따로 나머지 회원정보들 따로 
		Member addTemp = map.get(id);	//get은 키값을 주는 것
		//있으면 건너뜀
		if(addTemp != null) {	//if(map.get(id) != null)
			return false;
		}
		//없으면 추가
		map.put(id, new Member(pw, name, residentNumber, age));
		return true;
	}
	
	public static boolean searchMember(HashMap<String, Member> map) {
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String pw = sc.next();
		//아이디를 이용하여 회원 정보를 가져옴
		//키값만 입력하면 벨류가 자동으로 searchTemp에 저장
		Member searchTemp = map.get(id);
		//일치하는 회원정보가 없으면 건너뜀 
		if(searchTemp == null) {
			return false;
		}
		//가져온 회원 정보애서 비밀번호가 같은지를 환인하여 같지 않으면 건너뜀
		if(!searchTemp.getPw().equals(pw)) {
			return false;
		}
		System.out.println(id + " : " + searchTemp);
		return true;
	}

	public static boolean updateMember(HashMap<String, Member> map) {
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String pw = sc.next();
		
		Member updateTemp = map.get(id);
		if(updateTemp == null || !updateTemp.getPw().equals(pw)) {
			return false;
		}
		
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("새로운 비밀번호 : ");
		String newPw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주민번호 : ");
		String residentNumber = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		updateTemp.update(newPw, name, residentNumber, age);
		return true;
	}
	
	public static boolean deleteMember(HashMap<String, Member> map) {
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String pw = sc.next();
		
		Member deleteTemp = map.get(id);
		if(deleteTemp == null || !deleteTemp.getPw().equals(pw)) {
			return false;
		}
		map.remove(id);
		return true;
	}
}
