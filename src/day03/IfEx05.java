package day03;

public class IfEx05 {

	public static void main(String[] args) {
		/* 정수 num가 2의 배수이면 2의 배수라고 출력하고
		 * 3의 배수이면 3의 배수라고 출력하고
		 * 6의 배수이면 6의 배수라고 출력하고
		 * 2,3,6의 배수가 아니면 2,3,6의 배수가 아니라고 출력하는 코드 작성
		 * 단, 6의 배수는 6의 배수라고만 출력
		 */
		
		
		int num = 5;
		if(num % 6 == 0) {
			System.out.println("6의 배수");
		}else if(num % 3 == 0) {
			System.out.println(num + "는 3 배수입니다.");
		}else if(num % 2 == 0) {
			System.out.println(num + "는 2의 배수입니다.");
		}else {
			System.out.println("2,3,6의 배수가 아닙니다.");
		}
		
		
		if(num % 2 == 0 && num % 3 != 0) {
			System.out.println(num + "는 2의 배수입니다.");
		}else if(num % 3 == 0 && num % 2 != 0) {
			System.out.println(num + "는 3 배수입니다.");
		}else if(num % 6 == 0) {
			System.out.println("6의 배수");
		}else {
			System.out.println("2,3,6의 배수가 아닙니다.");
		}


	}

}
