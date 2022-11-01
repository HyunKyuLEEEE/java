package day03;

import java.util.Scanner;

public class SwitchEx02 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력 받아 산술 연산 결과를 하는 코드를 switch문을 작성하세요.
		 * 
		 * - break가 없으면 다음 case의 실행문으로 이동(다음 case의 값과 달라도 이동)
		 * - 여러 경우를 같이 처리하고 싶으면
		 * 	 case 값1, 값2, 값3: 
		 * */

		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수와 문자를 입력하세요(예: 1 + 2) : ");
		int num1 = sc.nextInt();
		char ch = sc.next().charAt(0);
		int num2 = sc.nextInt();
		
		switch(ch) {
		case '+':
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
			break;
		case '-':
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
			break;
		case '*':
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
			break;
		case '/':
			System.out.println(num1 + " / " + num2 + " = " + ((double)num1 / num2));
			break;
		case '%':
			System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
			break;
		default:
			System.out.println(ch + "는 산술연산자가 아닙니다.");
		}
	}

}
