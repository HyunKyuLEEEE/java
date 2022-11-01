package day04;

public class ForSumEx01 {

	public static void main(String[] args) {
		/* 1부터 10사이의 짝수의 합을 구하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : i가 짝수이면 sum += i를 실행
		 * */
		
		int i, sum =0;
		for(i = 0; i < 11; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("1부터 10까지 짝수 합 : " + sum);
	}

}
