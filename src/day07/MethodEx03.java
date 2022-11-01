package day07;

public class MethodEx03 {

	public static void main(String[] args) {
		/* 주어진 정수 num가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 단, 메소드를 이용
		 * */
		printPrimeNumber(11);
		System.out.println(isPrimeNumber(11));
		
		
		//primeNumber(17,1,1);
	}
	/* 기능 : 정수가 주어지면 소수인지 아닌지 출력하는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 출력 => 없음 => void
	 * 메소드명 : printPrimeNumber
	 * */
	public static void printPrimeNumber(int num) {
		int i,count;
		for(i = 1, count = 0; i <= num; i++) {
			if(num % i == 0) {
				count++;
			}
		}
		if(count == 2) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수가 아님");
		}
	}
	
	/* 기능 : 정수가 주어지면 소수인지 아닌지 알려주는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => boolean
	 * 메소드명 : isPrimeNumber
	 * */
	
	public static boolean isPrimeNumber(int num) {
		
		for(int i = 2; i < num; i++) {
			//1과 num를 제외한 약수
			if(num % i == 0) {
				return false;
			}
		}
		return num <= 1 ? false : true;
	}
	
	
	
	/* 내가 한것
	 * 기능 : 주어진 정수 num를 판별하기 위해 i로 나누었을때 약count(1과 num)으로 나오면 출력
	 * 		 소수가 아닐 시 출력
	 * 매개변수 : 주어진 정수 => int num , 판별하기위해 나누는 수 => int i, 소수 => int count
	 * 리턴타입 : void
	 * 메소드명 : primeNumber
	 * 
	
	public static void primeNumber(int num,int count,int i) {
		for(i = 1, count = 0; i <= num; i++) {
			if(num % i == 0) {
				count++;
			}
		}
		if(count == 2) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수가 아님");
		}
	}
	 */
	
}
