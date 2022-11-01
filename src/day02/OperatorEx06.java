package day02;

public class OperatorEx06 {

	public static void main(String[] args) {
		/* 논리연사나자
		 * && : 둘다 참이면 참, 나머진 거짓
		 * 		~이고, ~라고
		 * || : 둘다 거짓잉면 거짓, 나머진 참
		 * 		~이거나 
		 * !  : 반대, ~가 아닌 
		 */
		int score = 85;
//		boolean isB = score가 80점 이상이고 score가 90점 미만인가
		boolean isB = score >= 80 && score < 90;
		System.out.println(score +"점은 B학점인가?" + isB);
	}

}
