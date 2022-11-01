package day02;

import java.util.Scanner;

public class SacnnerEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 정수 입력
		System.out.println("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.println(num);	
		
		// 실수형 입력
		System.out.println("실수를 입력하세요 : ");
		double num2 = scan.nextDouble();
		System.out.println(num2);
		
		System.out.println("정수 A와 정수 B를 입력하세요 : ");
		int num3 = scan.nextInt();
		int num4 = scan.nextInt();
		System.out.println("정수 A : " + num3 + " 정수 B : " + num4);
		
		scan.close();	// 필수는 아님;
	}

}
