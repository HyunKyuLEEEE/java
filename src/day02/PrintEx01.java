package day02;

public class PrintEx01 {

	public static void main(String[] args) {
		/* println() :	 원하는 값을 출력한 후 엔터
		 * 				 () 안에 값을 생략 가능
		 * print()   : 	 원하는 값을 출력
		 * 				 () 안에 값을 생략할 수 없음
		 * 
		 * 문자열 + 정수 => 문자열
		 * 정수 + 문자열 => 문자열
		 * 문자 + 문자열 => 문자열
		 * 
		 * */
		String name = "홍길동";
		int age = 20;
		System.out.println(name + "의 나이는 " + age + "살 입니다.");
		
		int num1 = 10;
		int num2 = 20;
		char operator = '+';
		// 10+20
		System.out.println(num1 + " " +operator+ " " + num2);
		/* 정수 + 문자 => 정수 10 + 43 + 20 이 되기때문에 73이 된다.
		 * 그래서 문자열 ""을 추가하면 문자열로 나온다.
		 */
	}

}
