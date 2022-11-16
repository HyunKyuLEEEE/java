package example.accountbook;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import jdk.jshell.spi.ExecutionControl.RunException;

public class AccountBook {
	ArrayList<Item> list = new ArrayList<Item>();
	AccountService accountService = new AccountServiceImp();
	Scanner sc;
	
	public void run() {
		System.out.println("가계부 프로그램 실행합니다.");
		int menu = 1;
		do {
			try {
				accountService.printMenu();
				menu = sc.nextInt();
				accountService.runMenu(list, menu, sc);
			}catch(ParseException e) {
				System.out.println("예외 발생 : 날짜 형태가 잘못되었습니다.");
			}catch(InputMismatchException e) {
				System.out.println("예외 발생 : 잘못된 타입을 입력했습니다.");
				sc.nextLine();
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}while(menu != 5);
		System.out.println("가계부 프로그램 종료합니다.");
	}
	
	public AccountBook(Scanner sc) {
		if(sc == null) {
			this.sc = new Scanner(System.in);
		}else {
			this.sc = sc;
		}
	}
}
