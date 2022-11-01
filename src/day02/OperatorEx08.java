package day02;

import java.util.Scanner;

public class OperatorEx08 {

	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수가 홀수인지 짝수인지 출력하는 코드를 작성하세요.
		 * 예시
		 * 정수를 입력하세요 : 5
		 * 5는 홀수입니다.
		 * 짝수는 정수를 2로 나누었을 때 나머지가 0과 같은 수
		 * */
		// 선생님이 한거
		//정수를 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num = sc.nextInt();
		// 입력받은 정수를 2로 (나누었을 때 나머지)가 0과 (같은)지를 변수에 저장
		boolean isEven = num % 2 ==0;
		// 나머지가 0과 같으면 "짝수"를, 같이 않으면 "홀수"를 저장
		String result = isEven ? "짝수" : "홀수";
		//결과를 출력
		System.out.println(num + "는 " + result + "입니다.");
		sc.close();
		
		/*
		// 내가 한거
		//정수 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		//홀수인지 짝수인지
		String result = (num % 2 == 1) ? "홀수" : "짝수";
		
		//출력
		System.out.println(num + "은 " + result +"입니다.");
		*/
	}

}
