package day30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardMain {
	private static List<Board> boardlist = new ArrayList<Board>();
	private static List<Comment> commentList = new ArrayList<Comment>();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/* 기능
		 * - 게시글 등록
		 * - 게시글 수정
		 * - 게시글 삭제
		 * - 게시글 목록
		 * - 게시글 확인
		 * 	 - 댓글 등록
		 * 	 - 댓글 확인
		 * 	 - 이전
		 * - 프로그램 종료
		 * */
		//메뉴를 출력하고, 
		//메뉴를 입력받아 메뉴가 프로그램 종료가 아니면 반복하는 코드를 작성
		int menu = -1;
		while(menu != 6) {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}
	}
	/** 메뉴를 출력하는 메소드
	 * 1. 게시글 등록
	 * 2. 게시글 수정
	 * 3. 게시글 삭제
	 * 4. 게시글 목록
	 * 5. 게시글 확인
	 * 6. 프로그램 종료
	 * */
	private static void printMenu() {
		System.out.println("======메뉴======");
		System.out.println("1.게시글 등록");
		System.out.println("2.게시글 수정");
		System.out.println("3.게시글 삭제");
		System.out.println("4.게시글 목록");
		System.out.println("5.게시글 확인");
		System.out.println("6.프로그램 종료");
		System.out.println("===============");
		System.out.print("메뉴 선택 :");
	}

	/** runMenu
	 * 메뉴가 주어지면 주어진 메뉴에 맞는 기능을 출력하는 메소드
	 * @param menu 선택된 메뉴로 정수 
	 * */
	private static void runMenu(int menu) {
		switch(menu){
			case 1:
				insertBoard();
				break;
			case 2:
				updateBoardList();
				break;
			case 3:
				deleteBoardList();
				break;
			case 4:
				printBoardList();
				break;
			case 5:
				printBoard();
				break;
			case 6:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	/** insertBoard
	 * 게시글 정보를 입력받아 게시글을 출력하는 메소드 
	 * 메소드 구현에 필요한 필드를 추가해도 됨
	 * */
	private static void insertBoard() {
		sc.nextLine();
		int num = inputBoardNum();
		
		Board board = inputBoard(num);
		if(boardlist.contains(board)) {
			System.out.println("이미 등록된 게시글 번호입니다.");
			return;
		}
		
		boardlist.add(board);
	}

	/** inputBoardNum : Scanner를 통해 번호를 입력받아 알려주는 메소드
	 * @return 입력받은 게시글 번호
	 * */
	private static int inputBoardNum() {
		System.out.print("번호 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
	
	/**inputBoard : 게시글 번호가 주어지면 제목,내용, 작성자 내용을 입력하여
	 * 				게시글 객체를 리턴하는 메소드
	 * @param num(게시글 번호)
	 * @return 개시글 객체
	 * */
	private static Board inputBoard(int num) {
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		
		return new Board(title, content, writer, num);
		
	}
	
	/**updateBoard : 게시글 리스트에 주어진 게시글을 수정하는 메소드로 수정하면 true를 실패하면 false를 리턴한다
	 * @param boardList 게시글 리스트
	 * @param board 수정할 게시글
	 * @return 수정 성공 true, 실패 false
	 * */
	private static boolean updateBoard(List<Board> boardList, Board board) {
		if(boardlist.size() == 0)
			return false;
		int index = boardlist.indexOf(board);
		if(index == -1)
			return false;
		boardlist.set(index, board);
		return true;
	}
	
	
	/** updateBoardList : 게시글 정보를 입력받아 수정하는 메소드
	 * */
	public static void updateBoardList() {
		int num = inputBoardNum();
		Board board = inputBoard(num);
		updateBoard(boardlist, board);
		if(updateBoard(boardlist, board)) {
			System.out.println("게시글을 수정했습니다.");
		}else {
			System.out.println("게시글을 수정하지 못했습니다.");
		}
	}

	/** deleteBoard : 게시글 리스트에 주어진 게시글을 수정하는 메소드
	 * @param boardList 게시글 리스트
	 * @param num 삭제할 게시글 번호
	 * @return 삭제 성공 true, 실패 false
	 * */
	private static boolean deleteBoard(List<Board> boardList, int num) {
		Board board = new Board(num);
		return boardList.remove(board);
	}
	
	/** deleteBoardList : 게시글 번호를 입력받아 삭제하는 메소드
	 * */
	private static void deleteBoardList() {
		int num = inputBoardNum();
		if(deleteBoard(boardlist, num))
			System.out.println("게시글을 삭제했습니다.");
		else
			System.out.println("게시글을 삭제하지 못했습니다.");
	}
	
	/** printBoardList : 게시글 전체를 출력하는 메소드
	 * */
	private static void printBoardList() {
		boardlist.forEach(b->System.out.println(b));
	}
	
	/** printSubMenu : 게시글 확인에 필요한 서브메뉴를 출력
	 * */
	private static void printSubMenu() {
		System.out.println("=====서브메뉴=====");
		System.out.println("1.댓글 등록");
		System.out.println("2.댓글 확인");
		System.out.println("3.이전");
		System.out.println("===============");
		System.out.print("메뉴 선택 :");
	}
	
	/** runPrintSubMenu : 선택한 서브메뉴를 실행하는 메소드
	 * 					  우선은 서브메뉴를 선택하면선택한 서브메뉴를
	 * 					  콘솔에 출력하는 기능으로 일단 구현
	 * @param subMenu 선택한 서브 메뉴
	 * @param boardNum  선택한 게시글 번호
	 * */
	private static void runPrintSubMenu(int subMenu, int boardNum) {
		switch(subMenu) {
		case 1:
			insertCommentList(boardNum);
			break;
		case 2:
			printCommentList(boardNum);
			break;
		case 3:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	/** printBoard : 게시글 번호를 입력받고 입력받은 게시글을 출력하고 서브메뉴를 출력하고, 서브메뉴를 선택하면
	 * 				 선택한 서브 메뉴를 실행하는 메소드
	 * */
	private static void printBoard() {
		int num = inputBoardNum();
		Board board = new Board(num);
		int index = boardlist.indexOf(board);
		if(index == -1) {
			System.out.println("등록되지 않았거나 삭제된 게시글입니다.");
			return;
		}
		board = boardlist.get(index);
		board.print();
		int subMenu = -1;
		do {
			printSubMenu();
			subMenu = sc.nextInt();
			sc.nextLine();
			runPrintSubMenu(subMenu,num);
		}while(subMenu != 3);
	}
	
	/** insertComment : 댓글을 댓글 리스트에 추가하는 메소드
	 * @param commentList 댓글 리스트
	 * @param comment 댓글
	 * @return 댓글 추가 여부 성공 true, 실패 false
	 * */
	private static boolean insertComment(List<Comment> commentList, Comment commnet) {
		int index = commentList.indexOf(commnet);
		if(index != -1) {
			return false;
		}
		commentList.add(commnet);
		System.out.println("댓글 등록이 완료됐습니다.");
		return true;
	}
	
	/** insertCommentList : 댓글 정보를 입력받아 댓글을 추가하는 메소드
	 * @param boardNum 선택한 게시글 번호
	 * */
	private static void insertCommentList(int boardNum) {
		int num = inputBoardNum();
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		System.out.print("내용 : ");
		String contents = sc.nextLine();
		
		Comment comment = new Comment(num, contents, writer, boardNum);
		if(insertComment(commentList, comment)) {
			System.out.println("댓글 등록이 완료됐습니다.");
		}else {
			System.out.println("이미 등록된 댓글 번호입니다.");
		}
	}
	
	/** printCommentList : 선택한 게시글에 있는 댓글들을 확인하는 메소드
	 * @param boardNum 게시글 번호
	 * */
	private static void printCommentList(int boardNum) {
		if(commentList.size() == 0) {
			System.out.println("등록된 댓글이 없습니다.");
			return;
		}
		commentList.forEach(c->{
			if(c.getBoardNum() == boardNum) {
				System.out.println(c);
			}
		});
	}
	
}
