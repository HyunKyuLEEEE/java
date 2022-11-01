package day03;

import java.util.Scanner;

public class SwitchEx03 {

	public static void main(String[] args) {
		//IfEx06예제를 switch문으로 변경
		Scanner sc = new Scanner(System.in);
		System.out.println("산술 연산자를 입력하세요. : ");
		char ch= sc.next().charAt(0);
		
		switch(ch) {
		case '+','-','*','/','%':
			System.out.println(ch + "는 산술 연산자입니다.");
			break;
		default:
			System.out.println(ch + "는 산술 연산자가 아닙니다.");
		}

	}

}
