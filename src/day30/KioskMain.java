package day30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskMain {

	/* 제품을 관리하는 프로그램을 작성하세요.
	 * - 구매가격, 판매가격은 변동이 없음
	 * 기능
	 * - 제품 등록(분류(과자,학용품), 제품명, 수량, 구매가격, 판매가격)
	 * - 제품 수정
	 * - 제품 삭제
	 * - 제품 구메(관리자가 구매, 입고)
	 * - 제품 판매
	 * - 매출액 확인
	 * 	 - 년별
	 * 		- 제품별
	 * 		- 전체
	 * 	 - 월별
	 * 		- 제품별
	 * 		- 전체
	 * 	 - 일별
	 * 		- 제품별
	 * 		- 전체
	 * 예)
	 * 분류 : 식품
	 * 제품명 : 진라면
	 * 수량 : 0
	 * 구매가격 : 400원
	 * 판매가격 : 500원
	 * 진라면 100개 구매 => 진라면 수량 100개
	 * 진라면 10개 판매(날짜) => 진라면 수량 90개
	 * */
	
	private static List<Item> list = new ArrayList<Item>();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int menu = -1;
		//반복문
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = sc.nextInt();
			sc.nextLine();
			//선택된 메뉴 실행
			runMenu(menu);
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
		System.out.println("1.제품");
		System.out.println("2.매출");
		System.out.println("3.종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
	}
	private static void runMenu(int menu) {
		switch(menu) {
		//제품
		case 1:
			itemMenu();
				// 제품 등록(분류(과자,학용품), 제품명, 수량, 구매가격, 판매가격)
				// 제품 수정
				// 제품 삭제
				// 제품 구메 (메소드 - 분류(과자,학용품), 제품명, 수량, 구매가격)
				// 제품 판매 (메소드 - 분류(과자,학용품), 제품명, 수량, 판매가격, 날짜)
		break;
		//매출
		case 2:
			salesMenu();
			// 년별
				// 제품별
				// 전체
			// 월별
				// 제품별
				// 전체
			// 일별
				// 제품별
				// 전체
			break;
		//종료
		case 3:
			printStr("프로그램을 종료합니다.");
			break;
		default:
			printStr("잘못된 메뉴를 선택했습니다.");
		}
	}
	private static void salesMenu() {
		
	}
	private static void itemMenu() {
		int subMenu = -1;
		do {
			printSubMenu(1);
			subMenu = sc.nextInt();
			sc.nextLine();
			subMenu = runItemMenu(subMenu);
		}while(subMenu != 6);
	}
	private static int runItemMenu(int subMenu) {
		switch(subMenu) {
		// 제품 등록(분류(과자,학용품), 제품명, 수량, 구매가격, 판매가격)
		case 1:
			insertItem();
			break;
		// 제품 수정
		case 2:
			updateItem();
			break;
		// 제품 삭제
		case 3:
			deleteUpdate();
			break;
		// 제품 구메 (메소드 - 분류(과자,학용품), 제품명, 수량, 구매가격)
		case 4:
			break;
		// 제품 판매 (메소드 - 분류(과자,학용품), 제품명, 수량, 판매가격, 날짜)
		case 5:
			break;
		default:
		}
		return subMenu;
	}
	
	private static void deleteUpdate() {
		// TODO Auto-generated method stub
		
	}
	private static void updateItem() {
		
		
	}
	private static void insertItem() {
		// 제품 등록(분류(과자,학용품), 제품명, 수량, 구매가격, 판매가격)
		System.out.print("분류 : ");
		String category = sc.nextLine();
		System.out.print("제품명 : ");
		String name = sc.nextLine();
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		System.out.print("구매가격 : ");
		int buyPrice = sc.nextInt();
		System.out.print("판매가격 : ");
		int sellPrice = sc.nextInt();
		
		Item item = new Item(category, name, amount, buyPrice, sellPrice);
		
		list.add(item);
		
	}
	private static void printSubMenu(int menu) {
		switch(menu) {
		case 1:
			System.out.println("=====상품 메뉴=====");
			System.out.println("1.제품 등록");
			System.out.println("2.제품 수정");
			System.out.println("3.제품 삭제");
			System.out.println("4.제품 구매");
			System.out.println("5.제품 판매");
			System.out.println("6.이전");
			break;
		case 2:
			System.out.println("=====매출 메뉴=====");
			System.out.println("1.연별");
			System.out.println("2.월별");
			System.out.println("3.일별");
			System.out.println("4.이전");
			break;
		}
		printBar();
		System.out.print("메뉴 선택 : ");
	}

}
