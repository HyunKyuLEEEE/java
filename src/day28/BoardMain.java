package day28;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class BoardMain {

	/* 게시글 관리 프로그램
	 * - 회원가입
	 * 	 - 처음 가입한 회원이 관리자, 그외 회원인 일반 회원
	 * - 로그인
	 * - 게시글 등록/수정/삭제 => 회원만 가능
	 * - 카테고리 관리(공지, 자유)
	 * - 카테고리 추가/수정/삭제(관리자만 가능)
	 * 
	 * - 기능
	 * 	- 회원관리
	 * 	  - 로그인
	 * 	  - 회원가입
	 * 	- 게시글 관리
	 * 	  - 게시글 등록 (회원만)
	 *    - 게시글 수정 (회원 + 작성자 본인)
	 *    - 게시글 삭제 (회원 + 작성자 본인)
	 *    - 게시글 목록 
	 *    	- 게시글 검색(검색 번호는 게시글 번호로)
	 *    	- 게시글 확인
	 *  - 카테고리 관리(회원 + 관리자만)
	 *    - 카테고리 추가
	 *    - 카테고리 수정
	 *    - 카테고리 삭제
	 *    
	 * */
	private static Scanner sc = new Scanner(System.in);
	private static List<Member> memberList = new ArrayList<Member>();
	private static List<Board> boardList = new ArrayList<Board>();
	private static List<String> categoryList = new ArrayList<String>();
	private static Member user;
	public static void main(String[] args) {
		int menu = -1;
		loadMember("member.txt");
		loadCategory("category.txt");
		loadBoard("board.txt");
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine();//위에서 입력한 엔터를 비움
				printBar();
				runMenu(menu);
			} catch(InputMismatchException e){
				sc.nextLine();//잘못된 문자열들을 비워줌
				printStr("숫자를 입력하세요.");
			} catch(Exception e) {
				printStr(e.getMessage());
			}
		}while(menu != 4);
		saveMember("member.txt");
		saveCategory("category.txt");
		saveBoard("board.txt");
	}
	
	private static void loadBoard(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			int count = ois.readInt();
			Board.setCount(count);
			while(true) {
				Board board = (Board)ois.readObject();
				boardList.add(board);
			}
		} catch(EOFException e) {
			printStr("불러오기 성공");
		} catch(IOException e) {
			printStr("불러오기 실패");
		} catch(ClassNotFoundException e) {
			printStr("불러오기 실패");
		} 
	}
	
	private static void saveBoard(String fileName) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeInt(Board.getCount());
			for(Board board  : boardList) {
				oos.writeObject(board);
			}
			printStr("저장 완료");
		} catch(IOException e) {
			printStr("저장 실패");
		}
	}
	
	private static void saveCategory(String fileName) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			for(String category  : categoryList) {
				oos.writeObject(category);
			}
			printStr("저장 완료");
		} catch(IOException e) {
			printStr("저장 실패");
		}
	}
	private static void loadCategory(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			while(true) {
				String category = (String)ois.readObject();
				categoryList.add(category);
			}
		} catch(EOFException e) {
			if(categoryList.size() == 0)
				categoryList = new ArrayList<String>(Arrays.asList("공지", "자유"));
			printStr("불러오기 성공");
		} catch(IOException e) {
			printStr("불러오기 실패");
		} catch(ClassNotFoundException e) {
			printStr("불러오기 실패");
		} 	
	}
	private static void saveMember(String fileName) {
		if(memberList.size() == 0)
			return;
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			for(Member member : memberList) {
				oos.writeObject(member);
			}
			printStr("저장 완료");
		} catch(IOException e) {
			printStr("저장 실패");
		}
	}
	private static void loadMember(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			while(true) {
				Member member = (Member)ois.readObject();
				memberList.add(member);
			}
		} catch(EOFException e) {
			printStr("불러오기 성공");
		} catch(IOException e) {
			printStr("불러오기 실패");
		} catch(ClassNotFoundException e) {
			printStr("불러오기 실패");
		} 	
	}
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	private static void printBar() {
		System.out.println("===================");
	}
	private static void printMenu() {
		System.out.println("========메뉴========");
		System.out.println("1.회원 관리");
		System.out.println("2.게시글 관리");
		System.out.println("3.카테고리 관리");
		System.out.println("4.프로그램 종료");
		System.out.println("===================");
		System.out.print("메뉴 선택 : ");
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			memberMenu();
			break;
		case 2:
			boardMenu();
			break;
		case 3:
			categoryMenu();
			break;
		case 4:
			printStr("프로그램 종료!");
			break;
		default:
			throw new RuntimeException("잘못된 메뉴를 선택했습니다.");
		}
	}
	private static void categoryMenu() {
		//관리자 체크 => 관리자가 아니면 메인 메뉴로
		if(!isAdmin()) {
			return;
		}
		int subMenu = -1;
		do {
			//서브 메뉴를 출력
			printSubMenu(3);
			//서브 메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행
			subMenu = sc.nextInt();
			sc.nextLine();
			printBar();
			runCategoryMenu(subMenu);
		}while(subMenu != 5);
	}
	private static void runCategoryMenu(int subMenu) {
		switch(subMenu) {
		//1. 카테고리 추가
		case 1:
			insertCategory();
			break;
			//2. 카테고리 수정
		case 2:
			updateCategory();
			break;	
		//3. 카테고리 삭제
		case 3:
			deleteCategory();
			break;
		//4. 카테고리 확인
		case 4:
			printCategory();
			break;
		//5. 이전
		case 5:
			printStr("이전 메뉴로 돌아갑니다.");
			break;
		default:
			printStr("잘못된 메뉴를 선택했습니다.");
		}
		
	}
	private static void printCategory() {
		//모든 카테고리 출력
		if(categoryList.size() == 0) {
			printStr("등록된 카테고리가 없습니다.");
			return;
		}
		for(int i = 0; i < categoryList.size(); i++) {
			System.out.println(i+1+". " + categoryList.get(i));
		}
	}
	private static void deleteCategory() {
		//삭제할 카테고리명 입력
		System.out.print("카테고리명 : ");
		String category = sc.nextLine();
		printBar();
		//기존 카테고리에 있으면 삭제
		if(categoryList.remove(category)) {
			printStr("카테고리를 삭제했습니다.");
			return;
		}
		printStr("등록되지 않은 카테고리입니다.");
	}
	private static void updateCategory() {
		//수정할 카테고리명 입력
		System.out.print("카테고리명 : ");
		String category = sc.nextLine();
		printBar();
		//기존 카테고리에 없으면 
		if(!categoryList.contains(category)) {
			printStr("등록되지 않은 카테고리입니다.");
			return;
		}
		//새 카테고리명 입력
		System.out.print("카테고리명 : ");
		String newCategory = sc.nextLine();
		printBar();
		//기존 카테고리에 있는지 확인하여 없으면 수정
		if(!categoryList.contains(newCategory)) {
			categoryList.remove(category);
			categoryList.add(newCategory);
			printStr("카테고리 수정에 성공했습니다.");
			return;
		}

		printStr("이미 등록된 카테고리입니다.");
	}
	private static void insertCategory() {
		//새 카테고리명 입력
		System.out.print("카테고리명 : ");
		String category = sc.nextLine();
		printBar();
		//기존 카테고리에 있는지 확인하여 없으면 추가
		if(categoryList.indexOf(category) == -1) {
			categoryList.add(category);
			printStr("새 카테고리를 추가했습니다.");
			return;
		}
		printStr("이미 있는 카테고리입니다.");
	}
	
	private static boolean isAdmin() {
		if(user == null || user.getAuthority() != Authority.ADMIN) {
			printStr("관리자가 아닙니다. 해당 기능을 이용할 수 없습니다.");
			return false;
		}
		return true;
	}
	private static void boardMenu() {
		int subMenu = -1;
		do {
			//서브 메뉴를 출력
			printSubMenu(2);
			//서브 메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행
			subMenu = sc.nextInt();
			sc.nextLine();
			printBar();
			
			runBoardMenu(subMenu);
				
		}while(subMenu != 5);
	}
	
	private static void runBoardMenu(int subMenu) {
		switch(subMenu) {
		//1. 게시글 등록
		case 1:
			insertBoard();
			break;
		//2. 게시글 수정
		case 2:
			updateBoard();
			break;
		//3. 게시글 삭제
		case 3:
			deleteBoard();
			break;
		//4. 게시글 목록
		case 4:
			printBoard();
			break;
		//5. 이전
		case 5:
			printStr("이전 메뉴로 돌아갑니다.");
			break;
		default:
			printStr("잘못된 메뉴를 선택했습니다.");
		}
		System.out.println(boardList);
	}
	private static void printBoard() {
		int detailMenu = -1;
		do {
		//디테일 메뉴 출력
		printDetailMenu();
		//디테일 메뉴 선택 및 기능 실행
		detailMenu = sc.nextInt();
		sc.nextLine();
		printBar();
		runPrintMenu(detailMenu);
		}while(detailMenu != 4);
	}
	
	private static void runPrintMenu(int detailMenu) {
		switch(detailMenu){
		//1. 게시글 목록 확인
		case 1:
			//모든 게시글 확인
			printBoardListAll();
			break;
		//2. 게시글 검색
		case 2:
			//검색어 입력 후 게시글 확인
			printBoardSearch();
			break;
		//3. 게시글 확인
		case 3:
			//게시글 번호를 입력
			printBoardDetail();
			//입력한 게시글이 있으면 확인
			break;
		//4. 이전
		case 4:
			printStr("이전 메뉴로 돌어갑나다.");
			break;
		default:
			printStr("잘못된 메뉴를 선택했습니다.");
		}
	}
	private static void printBoardDetail() {
		//게시글 번호 입력
		System.out.print("게시글 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		int index = boardList.indexOf(new Board(num));
		//해당 게시글이 존재하지 않거나 작성자가 회원과 같지 않으면 삭제 불가
		if(index == -1) {
			printStr("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		Board board = boardList.get(index);
		int views = board.getViews();
		board.setViews(views+1);
		board.print();
		printBar();
	}
	private static void printBoardSearch() {
		System.out.print("검색어 : ");
		String search = sc.nextLine();
		printBoardList(s->s.getTitle().contains(search.trim()));
	}
	private static void printBoardListAll() {
		printBoardList(s->true);
	}
	
	private static void printBoardList(Predicate<Board> p) {
		if(boardList.size() == 0) {
			printStr("등록된 게시글이 없습니다.");
			return;
		}
		for(Board temp : boardList) {
			if(p.test(temp))
				System.out.println(temp);
		}
	}
	private static void printDetailMenu() {
		System.out.println("=====게시글목록메뉴====");
		System.out.println("1.게시글 목록 확인");
		System.out.println("2.게시글 검색");
		System.out.println("3.게시글 확인");
		System.out.println("4.이전");
		printBar();
		System.out.print("메뉴 선택 : ");
	}
	private static void deleteBoard() {
		//회원 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
		if(checkLogin(false)) {
			return;
		}
		//삭제할 게시글 번호 입력
		System.out.print("게시글 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		int index = boardList.indexOf(new Board(num));
		//해당 게시글이 존재하지 않거나 작성자가 회원과 같지 않으면 삭제 불가
			//작성자 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
		if(index == -1) {
			printStr("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		Board board = boardList.get(index);
		if(!board.getWriter().equals(user.getId())) {
			printStr("작성자가 아닌 사용자는 수정할 수 없습니다.");
			return;
		}
		//해당 게시글을 삭제
		boardList.remove(index);
		printStr("게시글 삭제가 완료됐습니다.");
	}
	private static void updateBoard() {
		//회원 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
		if(checkLogin(false)) {
			return;
		}
		//수정할 게시글 번호 입력
		System.out.print("게시글 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		int index = boardList.indexOf(new Board(num));
		//해당 게시글이 존재하지 않거나 작성자가 회원과 같지 않으면 수정 불가
			//작성자 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
		if(index == -1) {
			printStr("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		Board board = boardList.get(index);
		if(!board.getWriter().equals(user.getId())) {
			printStr("작성자가 아닌 사용자는 수정할 수 없습니다.");
			return;
		}
		//게시글 정보(제목, 내용) 입력
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		printBar();
		//게시글을 수정
		board.update(title, content);
		printStr("게시글 수정이 완료됐습니다.");
	}
	private static void insertBoard() {
		//회원 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
		if(checkLogin(false)) {
			return;
		}
		//게시글 정보(제목, 내용, 카테고리) 입력
		printCategory();
		printBar();		
		System.out.print("카테고리 : ");
		String category = null;
		do{
			if(category != null)
				printStr("등록되지 않은 카테고리입니다.");
			category = sc.nextLine();
		}while(!categoryList.contains(category));
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		printBar();
		//게시글을 등록
		Board board = new Board(title, content, user.getId(), category);
		boardList.add(board);
		printStr("게시글 등록이 완료됐습니다.");
	}
	private static void memberMenu() {
		//로그인 체크 => 로그인 한 사람은 로그인/회원가입 시도를 할 수 없게 하기 위해
		if(checkLogin(true))
			return;
		int subMenu = -1;
		do {
			//서브 메뉴를 출력
			printSubMenu(1);
			//서브 메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행 => 반복
			subMenu = sc.nextInt();
			sc.nextLine();
			subMenu = runMemberMenu(subMenu);
		}while(subMenu != 3);
	}
	
	private static int runMemberMenu(int subMenu) {
		switch(subMenu) {
		//1. 회원 가입
		case 1:
			signup();
			break;
		//2. 로그인
		case 2:
			login();
			//로그인 성공하면 서브 메뉴를 3으로 수정하여 자동으로 메인으로 이동하게 함
			if(user != null)
				return 3;
			break;
		//3. 이전
		case 3:
			printStr("이전 메뉴로 돌어갑나다.");
			break;
		default:
			printStr("잘못된 메뉴를 선택했습니다.");
		}
		return subMenu;
	}
	private static void login() {
		//회원 정보 입력(아이디,비밀번호)
		System.out.println("로그인 정보 입력");
		Member member = inputMember();
		//일치하는 회원이 있으면 회원 정보를 가져옴(로그인 성공)
		int index = memberList.indexOf(member);
		if(index == -1) {
			printStr("로그인 실패");
			return;
		}
		user = memberList.get(index);
		printStr("로그인 성공");
			
		
	}
	private static void signup() {
		//회원 정보 입력
		System.out.println("회원 정보 입력");
		Member member = inputMember();
		//가입된 아이디인지 체크
		if(isMember(member)) {
			printStr("이미 가입된 아이디입니다.");
			return;
		}
		//가입된 아이디가 아니면 회원 가입 진행
		memberList.add(member);
		printStr("회원 가입이 완료되었습니다.");
	}
	private static boolean isMember(Member member) {
		if(member == null)
			return false;
		if(memberList == null)
			memberList = new ArrayList<Member>();
		if(memberList.size() == 0)
			return false;
		for(Member temp : memberList) {
			if(temp.getId().equals(member.getId())) {
				return true;
			}
		}
		return false;
	}
	private static Member inputMember() {
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String pw = sc.nextLine();
		Authority authority = memberList.size() == 0 ? Authority.ADMIN : Authority.MEMBER;
		return new Member(id, pw, authority);
	}
	private static void printSubMenu(int menu) {
		switch(menu) {
		case 1:
			System.out.println("======회원관리메뉴=====");
			System.out.println("1.회원 가입");
			System.out.println("2.로그인");
			System.out.println("3.이전");
			break;
		case 2:
			System.out.println("=====게시글관리메뉴=====");
			System.out.println("1.게시글 등록");
			System.out.println("2.게시글 수정");
			System.out.println("3.게시글 삭제");
			System.out.println("4.게시글 목록");
			System.out.println("5.이전");
			break;
		case 3:
			System.out.println("=====카테고리관리메뉴====");
			System.out.println("1.카테고리 등록");
			System.out.println("2.카테고리 수정");
			System.out.println("3.카테고리 삭제");
			System.out.println("4.카테고리 확인");
			System.out.println("5.이전");
			break;
		}
		printBar();
		System.out.print("메뉴 선택 : ");
		
	}
	private static boolean checkLogin(boolean res) {
		if(user != null && res) {
			printStr("로그인한 사용자는 해당 기능을 이용할 수 없습니다.");
			return true;
		}
		if(user == null && !res){
			printStr("로그인 하지 않은 사용자는 해당 기능을 이용할 수 없습니다.");
			return true;
		}
		return false;
	}

	

}
