package day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BookManagerMain {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/* 도서 관리 프로그램을 작성하세요.
		 * 도서 정보 
		 * - 도서명, 저자(여러명, 엮은이, 옮긴이 다 포함), 가격, 출판사, 분류, ISBN
		 * 기능
		 * - 도서 추가
		 * 	- ISBN으로 정렬
		 * - 도서 조회
		 * 	- 도서 명으로 조회
		 * 	- 저자로 조회
		 * 	- 출판사로 조회
		 *  - 분류로 조회
		 * 
		 * */
		ArrayList<Book> list = new ArrayList<Book>();
		int menu = -1;
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(list, menu);
		}while(menu != 3);
	}

	private static void runMenu(ArrayList<Book> list, int menu) {
		switch(menu) {
		case 1:
			//도서 추가
			//프로그램에 도서 추가
			insertBook(list, inputBook(sc));
			break;
		case 2:
			//도서 조회
			//메뉴출력
			printSubMenu();
			//메뉴 입력
			int subMenu = sc.nextInt();
			//메뉴 선택에 다른 기능 실행
			runSubMenu(list, subMenu);
			break;
		case 3:
			break;
		default:
		}
		
	}

	private static void runSubMenu(ArrayList<Book> list, int subMenu) {
		switch(subMenu) {
		case 1:
			sc.nextLine();
			System.out.print("도서 명 : ");
			String bookName = sc.nextLine();
			
			//객체
			int index = list.indexOf(new Book(bookName));
			bookName.equals(bookName);
			if(index == -1) {
				System.out.println("없는 책 입니다.");
				return;
			}
			System.out.println(list.get(index).print());
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
		}
		
	}

	private static void printBook(ArrayList<Book> list) {
		if(list.size() == 0) {
			System.out.println("기록된 내역이 없습니다.");
			return;
		}
		for(Book book : list) {
			System.out.println(book);
		}
	}

	private static void printSubMenu() {
		 System.out.println("======조회 메뉴======");
		 System.out.println("1. 도서명 조회");
		 System.out.println("2. 저자 조회");
		 System.out.println("3. 출판사 조회");
		 System.out.println("4. 분류 조회");
		 System.out.println("==================");
		 System.out.print("메뉴 선택 : ");
		
	}

	public static Book inputBook(Scanner sc) {
		sc.nextLine();
		System.out.println("도서를 추가하세요.");
		System.out.print("도서명 : ");
		String bookName = sc.nextLine();
		System.out.print("저자 : ");
		String writter = sc.next();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("출판사 : ");
		String publisher = sc.next();
		System.out.print("분류(소설,에세이...) : ");
		String type = sc.next();
		
		return new Book(bookName, writter, publisher, type, price);
	}

	public static void insertBook(ArrayList<Book> list, Book book) {
		//내역에 리스트 추가
		list.add(book);
		//ISBN 순서로 정렬
		Collections.sort(list, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o2.getISBN() - o1.getISBN();
			}
		
		});
	}
	private static void printMenu() {
		System.out.println("======메뉴======");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 조회");
		System.out.println("3. 종료");
		System.out.println("===============");
		System.out.print("메뉴 입력 : ");
		
	}

}
