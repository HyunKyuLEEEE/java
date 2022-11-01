package day07;

public class MethodEx05 {

	public static void main(String[] args) {
		//1부터 10까지 합을 구하는 코드를 작성하세요. 단, 메소드를 이용할 것
		int start = 1, end = 10;
		
		printSum1(0);
		printSum2(1, 10);
		System.out.println(sum3(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println(start + "부터 " + end + "까지의 합 : " + sum1(1, 10));
		System.out.println(start + "부터 " + end + "까지의 합 : " + sum2(end, start));
	}

	/* 기능 : 시작숫자부터 끝숫자 사이의 모든 정수를 더하고, 더한 결과를 알려주는 메소드
	 * 매개변수 : 시작 숫자, 끝숫자 => int start, int end
	 * 리턴타입 : 더한 결과 => 정수=> int
	 * 메소드명 : sum
	 * */
	public static int sum1(int start, int end) {
		int sum = 0;
		for(int i =0; i <= 10; i++) {
			sum += i;
		}
		return sum;
	}
	
	/* 기능 : 시작숫자부터 끝숫자 사이의 모든 정수를 더하고, 더한 결과를 알려주는 메소드
	 * 매개변수 : 시작 숫자, 끝숫자 => int start, int end
	 * 리턴타입 : 더한 결과 => 정수=> int
	 * 메소드명 : sum
	 * */
	public static int sum2(int start, int end) {
		if(start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		return sum;
	}
	
	
	
// 내가 한 코드
	/* 기능 : 정수 1부터 정수 10까지의 정수 합을 출력하는 메소드
	 * 매개변수 : 1부터 10까지의 정수의 합 => 정수 => sum
	 * 리턴타입 : 출력 => 없음 => void
	 * 메소드명 : printSum1
	 * */
	public static void printSum1(int sum) {
		for(int i = 0; i < 11; i++) {
				sum += i;
		}
		System.out.println("1부터 10까지 짝수 합 : " + sum);
	}
	
	/* 기능 : 시작숫자 1부터 끝 숫자 10까지의 정수 합을 출력하는 메소드
	 * 매개변수 : 합, 시작숫자,끝 숫자 =>int start, int end
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printSum2
	 * */
	public static void printSum2(int start, int end) {
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		System.out.println("1부터 10까지 짝수 합 : " + sum);
	}
	
	/* 기능 : 정수 1부터 10까지 합을 구하는 코드를 구하는 메소드
	 * 매개변수 : int num1...num10
	 * 리턴타입 : int
	 * 메소드명 : sum1
	 * */
	public static int sum3(int num1,int num2,int num3,int num4,int num5,int num6
			,int num7,int num8,int num9,int num10) {
		return num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9 + num10;
	}
	
}
