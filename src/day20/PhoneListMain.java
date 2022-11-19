package day20;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneListMain {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/* 전화번호를 관리하는 프로그램을 작성하세요.
		 * 1. 전화번호 추가(성, 이름, 직장, 전화번호들) 집 02~, 훈대전화 010~...
		 * 2. 전화번호 수정
		 * 		- 이름으로 검색(성 + 이름)
		 * 		- 검색된 사람들 중에서 선택
		 * 		- 성, 이름을 수정할 건지,
		 * 		  기존 등록된 전화번호를 수정할건지,
		 * 		  새 전화번호를 등혹할 건지를 선택하여 동작
		 * 3. 전화번호 삭제
		 * 		- 이름으로 검색(성 + 이름)
		 * 		- 검색된 사람들 중에서 선택
		 * 		- 선택된 사람의 연락처 삭제
		 * 4. 전화번호 조회
		 * 		- 이름으로 검색
		 * 		- 검색된 사람들 중에서 선택
		 * 		- 선택된 사람들의 연락처를 출력
		 * */
		//반복
			//메뉴출력
			
			//메뉴선택
		
			//선택한 메뉴에 대한 기능 실행
				//1. 번호 추가
					//성명, 직장 입력
					//반복
						//전화번호를 입력(전화번호의 이름 : 전화번호) => PhoneNumber
						//전화번호를 더 입력할건지 물어봄
					//전화번호부에 추가 => PhoneBook 개체를 생성(이름,직장)(클래스)
				//2. 번호 수정
					//이름을 입력
					//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
					//수정할 전화번호부를 선택 
					//서브 메뉴 출력
					//서브 메뉴 선택
					//서브 메뉴 실행
						//1.이름, 직장 수정
							//이름 직장 입력
							//이름,직장 수정
						//2.기본 전화번호 수정
							//기존 전화번호들을 출력
							//수정할 번호를 선택
							//이름, 번호 입력
							//선택한 전화번호 이름, 번호를 수정
						//3.새 전화번호 추가
							//이름 번호를 입력
							//새 전화번호를 추가
				//3. 번호 삭제
					//이름을 입력
					//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
					//삭제할 전화번호부를 선택 
					//전화번호를 삭제(.remove사용)
				//4. 번호 조회
					//이름을 입력
					//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
					//조화할 전화번호부를 선택 
					//전화번호 조회
				//5. 프로그램 종료
		int menu = -1;
		ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>();
		ArrayList<PhoneBook> listBook = new ArrayList<PhoneBook>();
		//반복
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = sc.nextInt();
			//선택된 메뉴 기능 실행
			String lastName, firstName, company, phoneNum, phoneName;
			switch(menu) {
			case 1:
				//1. 번호 추가
				//성명, 직장 입력
				sc.nextLine();
				System.out.print("성 : ");
				lastName = sc.next();
				System.out.print("이름 : ");
				firstName = sc.next();
				System.out.print("회사 : ");
				company = sc.next();
				//반복
				char yN = 'n';
				do {
					//전화번호를 입력(전화번호의 이름 : 번호) => PhoneNumber
					sc.nextLine();
					System.out.print("전화번호 타입 : ");
					phoneName = sc.next(); 
					
					System.out.print("전화번호 : ");
					phoneNum = sc.nextLine();
					
					sc.nextLine();
					//전화번호를 더 입력할건지 물어봄
					System.out.println("더 추가하시겠습니가? (Y/N)");
					yN = sc.next().charAt(0);
					
				}while(yN != 'n' && yN != 'N');
				PhoneBook phoneBook = new PhoneBook(phoneNum, phoneName);
				listBook.add(phoneBook);
				//전화번호부에 추가 => PhoneBook 개체를 생성(이름,직장)(클래스)
				sc.nextLine();
				PhoneNumber phoneNumber = new PhoneNumber(phoneNum, phoneName, lastName, firstName, company, listBook);
				//연락처 목록에 새 연락처 추가
				list.add(phoneNumber);
				System.out.println(list);
				
				break;
			case 2:
				System.out.println("수정 예정");
				break;
			case 3:
				System.out.println("삭제 예정");
				break;
			case 4:
				System.out.println("조회 예정");
				// 이름으로 검색
				sc.nextLine();
				System.out.print("성 : ");
				lastName = sc.next();
				System.out.print("이름 : ");
				firstName = sc.next();
				
				
				// 검색된 사람들 중에서 선택
				// 선택된 사람들의 연락처를 출력
				
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 5);
	}
	
	
	public static void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
	}
}
