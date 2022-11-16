package day18;

import java.util.Scanner;

public class EnumEx02 {

	public static void main(String[] args) {
		/* 오늘의 요일을 영어로 입력받아 한글로 출력하는 코드를 작성하세요.
		 * 예)
		 * 요일 : WEDNESDAY
		 * 수요릴
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("요일 : ");
		String today = sc.next();
		
		switch(today){
			case "MONDAY":
				System.out.println("월요일");
				break;
			case "TUSEDAY":
				System.out.println("호요일");
				break;
			case "WEDNESDAY":
				System.out.println("수요일");
				break;
			case "THURSDAY":
				System.out.println("목요일");
				break;
			case "FRIDAY":
				System.out.println("금요일");
				break;
			case "SATURDAY":
				System.out.println("토요일");
				break;
			case "SUNDAY":
				System.out.println("일요일");
				break;
			default: System.out.println("잘못 입력했습니다.");
		}
		
		try {//enum은 default가 안되기때문에 예외처리를 해야함
			Week week = Week.valueOf(today);
			switch(week) {
			case MONDAY:
				System.out.println("월요일");
				break;
			case TUSEDAY:
				System.out.println("호요일");
				break;
			case WEDNESDAY:
				System.out.println("수요일");
				break;
			case THURSDAY:
				System.out.println("목요일");
				break;
			case FRIDAY:
				System.out.println("금요일");
				break;
			case SATURDAY:
				System.out.println("토요일");
				break;
			case SUNDAY:
				System.out.println("일요일");
				break;	
			}		
		}catch(Exception e) {
			System.err.println("잘못 입력했습니다.");
		}
		
	}
}
enum Week{
	MONDAY, TUSEDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
