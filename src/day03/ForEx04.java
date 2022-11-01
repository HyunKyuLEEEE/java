package day03;

public class ForEx04 {

	public static void main(String[] args) {
		/* 1부터 10 사이의 짝수를 출력하는 코드를 작성하세요.
		 * 2
		 * 4
		 * 6
		 * 8
		 * 10
		 * */
		/* 방법 1
		 * 반복횟수 : i는 i부터 5까지 1씩증가
		 * 규칙성 : 2* i를 출력
		 */
		/* 방법 2
		 * 반복횟수 : i는 2부터 10까지 2씩 증가
		 * 규칙성 : i를 출력
		 */
		/* 방법 3
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : i가 짝수이면 i를 출력
		 */
		int i;
		
		for(i = 1; i <= 5; i++) {
			System.out.println(2*i + "는 짝수입니다.");
		}
		System.out.println("--------------------------");
		
		for(i = 2; i <= 10; i += 2) {
			System.out.println(i+ "를 출력");
		}
		System.out.println("--------------------------");
		
		
		for(i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				System.out.println(i + "는 짝수입니다.");
			}
		}

	}

}
