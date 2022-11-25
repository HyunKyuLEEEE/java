package day25;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Ex04_3 {

	/* 컴퓨터와 가위, 바위, 보를 하는 프로그램을 작성하세요.
	 * 	- 사용자가 연속 3번 이길때까지 반복(비거나 지면 다시)
	 * 예:
	 * 사용자 : 가위
	 * 컴퓨터 : 보
	 * 사용자 : 가위
	 * 컴퓨터 : 주먹
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		do {
			try {
				System.out.print("사용자 : ");
				RSP user = RSP.valueOf(sc.next());
				RSP com = randomRSP();
				System.out.println("컴퓨터 : " + com);
				State state = resultState(user, com);
				printState(state);
				count = state == State.WIN ? count+1 : 0;
			} catch(IllegalArgumentException e) {
				System.out.println("입력을 잘못하셨습니다.");
			}
		}while(count != 3);
		
		sc.close();
	}

	private static void printState(State state) {
		switch(state) {
		case WIN:
			System.out.println("사용자가 이겼습니다.");
			break;
		case LOSE:
			System.out.println("컴퓨터가 이겼습니다.");
			break;
		default:
			System.out.println("비겼습니다..");
		}
		
	}

	private static State resultState(RSP user, RSP com) {
		if(user == com)
			return State.DRAW;
		switch(user) {
		case 가위:
			return com == RSP.보 ? State.WIN : State.LOSE;
		case 바위:
			return com == RSP.가위 ? State.WIN : State.LOSE;
		default:
			return com == RSP.바위 ? State.WIN : State.LOSE;
		}
	}

	private static RSP randomRSP() {
		RSP [] rsps = RSP.values();
		int r = (int)(Math.random()*3);
		return rsps[r];
	}
}
