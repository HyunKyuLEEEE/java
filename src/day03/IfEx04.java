package day03;

public class IfEx04 {

	public static void main(String[] args) {
		// 정수 num가 3의 배수이면 3의 배수라고 출력하고 아니면 3의배수가 아닙니다를 출력하는
		// 코드를 작성하시오
		
		int num = 10;
		if(num % 3 == 0) {
			System.out.println(num + "은 3의 배수입니다.");
		}else {
			System.out.println(num + "은 3의 배수가 아닙니다.");
		}

	}

}
