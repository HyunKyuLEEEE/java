package day03;

import java.util.Scanner;

public class IfEx07 {

	public static void main(String[] args) {
		/* 두 정수와 문자를 입력 받아 산술 연산자이면 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * 예시
		 * 두 정수와 문자를 입력하세요(예: 1 + 2) : 1 /2
		 * 1 / 2 = 0.5
		 * 예시
		 * 두 정수와 문자를 입력하세요(예: 1 + 2) : 1 ? 2
		 * ?는 산술연산자가 아닙니다.
		 * 
		 * 두 정수 num1과 num2, 문자 ch를 입력받고
		 * ch가 '+'와 같다면 num1 + num2의 출력하고
		 * ch가 '-'와 같다면 num1 - num2의 출력하고
		 * ch가 '*'와 같다면 num1 * num2의 출력하고
		 * ch가 '/'와 같다면 num1 / num2의 출력하고
		 * ch가 '%'와 같다면 num1 % num2의 출력하고
		 * ch가 산술연산자가 아니라면 산술연산자가 아님을 출력
		 * */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수와 문자를 입력하세요 (예 : 1 + 2) :");
		int num1 = sc.nextInt();
		char ch = sc.next().charAt(0);
		int num2 = sc.nextInt();
		if(ch == '+') {
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		}else if(ch == '-') {
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		}else if(ch == '*') {
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		}else if(ch == '/') {
			System.out.println(num1 + " / " + num2 + " = " + (num1 / (double)num2));
		}else if(ch == '%') {
			System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
		}else {
			System.out.println(ch + "는 산술연산자가 아닙니다.");
		}
	}

}
