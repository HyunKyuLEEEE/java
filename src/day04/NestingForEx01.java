package day04;

public class NestingForEx01 {

	public static void main(String[] args) {
		/* 구구단 3단을 출력하는 코드를 작성하세요.
		 *  
		 * */
		
		int num = 3, i;
		for(num = 2; num <= 9; num++) {
			for(i=1; i <= 9; i++) {
				System.out.println(num + " X " + i + " = " + num*i);	
			}
		}
		
		
		
		/*
		for(int i = 3; i < 10; i++) {
			System.out.println("구구단 3단");
			for(int j = 1; j < 10; j++ ) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
		}*/

	}

}
