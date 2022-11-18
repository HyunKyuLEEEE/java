package day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class BookManagerMain2 {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu = -1;
		ArrayList<Book> list = new ArrayList<Book>();
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = sc.nextInt();
			printBar();
			//선택한 메뉴에  따른 기능 실행
			runMenu(menu, list);
		}while(menu != 3);
		sc.close();
	}
	
	public static void printMenu() {
		System.out.println("=======메 뉴=======");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 조회");
		System.out.println("3. 종료");
		printBar();
		System.out.print("메뉴 선택 : ");
	}
	public static void printBar() {
		System.out.println("=================");
	}
	
	public static void runMenu(int menu, ArrayList<Book> list) {

		switch(menu) {
		case 1:
			//도서 정보를 입력받아 도서 객체를 생성
			Book book = createBook();

			if(!insertBook(list,book)) 
				System.out.println("이미 등록된 ISBN입니다.");
			else
				System.out.println("도서 추가가 완료됬습니다.");
			printBar();
			
			break;
		case 2:
			//서브 메뉴 출력
			printSearchMenu();
			//서브 메뉴 선택
			int subMenu = sc.nextInt();
			printBar();
			
			//선택한 서브 메뉴 실행
			runSearchMenu(subMenu, list);
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			printBar();
			break;	
		default:
			System.out.println("잘못된 메뉴입니다.");
			printBar();
		}
		
	}
	public static Book createBook() {
		sc.nextLine();//엔터 처리
		System.out.print("도서명  :");
		String title = sc.nextLine();
		System.out.print("저자   :");
		String author = sc.nextLine();
		System.out.print("가격   :");
		int price = sc.nextInt();
		sc.nextLine();//엔터 처리
		System.out.print("출판사  :");
		String publisher = sc.nextLine();
		System.out.print("장르   :");
		String genre = sc.nextLine();
		System.out.print("ISBN  :");
		String isbn = sc.next();
		printBar();
		//도서 목록에 새 도서를 추가
		//위에서 입력받은 도서 정보를 이용하여 도서 객체를 생성
		return new Book(title, author, publisher, genre, isbn, price);
	}
	public static boolean insertBook(ArrayList<Book> list, Book book) {
		if(list.contains(book)) {
			return false;
		}
		//중복되지 않으면 추가
		list.add(book);
		Collections.sort(list, (o1, o2)->o1.getIsbn().compareTo(o2.getIsbn()));
		return true;
	}
	public static void printSearchMenu() {
		System.out.println("=====조회 메뉴=====");
		System.out.println("1. 도서명");
		System.out.println("2. 저자");
		System.out.println("3. 출판사");
		System.out.println("4. 장르");
		System.out.println("5. 취소");
		printBar();
		System.out.print("조회 방법 선택 : ");
	}
	public static void runSearchMenu(int subMenu,ArrayList<Book> list) {
		String title, author, publisher, genre, isbn;
		int count = 0;
		switch(subMenu){
			//서브메뉴가 1이면 도서명으로 조회
			case 1:
				System.out.println("도서명 : ");
				sc.nextLine();//엔터 처리
				title = sc.nextLine();
				printBar();
				printBookList(list, b->b.getTitle().contains(title.trim()));
				break;
			//서브메뉴가 2이면 저자로 조회
			case 2:
				System.out.println("저자 : ");
				sc.nextLine();//엔터 처리
				author = sc.nextLine();
				printBar();
				printBookList(list, b->b.getAuthor().contains(author.trim()));
				break;
			//서브메뉴가 3이면 출판사로 조회
			case 3:
				System.out.println("출판사 : ");
				sc.nextLine();//엔터 처리
				publisher = sc.nextLine();
				printBar();
				printBookList(list, b->b.getPublisher().contains(publisher.trim()));
				break;
			//서브메뉴가 4이면 분류로 조회
			case 4:
				System.out.println("장르 : ");
				sc.nextLine();//엔터 처리
				genre = sc.nextLine();
				printBar();
				printBookList(list, b->b.getGenre().contains(genre.trim()));
				break;
			//서브메뉴가 5이면 조회 취소
			case 5:
				System.out.println("조회를 취소했습니다.");
				printBar();
				break;
			//잘못된 서브메뉴이면 잘못됐다고 출력
			default:
				System.out.println("잘못된 메뉴입니다.");
				printBar();
		}
	}
	public static void printBookList(ArrayList<Book> list, Predicate<Book> p) {
		int count = 0;
		for(Book temp : list) {
			if(p.test(temp)) {
				System.out.println(temp);
				count++; //카운트를 추가할때마다 
			}
		}
		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
			printBar();
		}
	}
}
