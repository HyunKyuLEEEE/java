package day04;

public class ForPrimeNumberEx01 {

	public static void main(String[] args) {
		/* 정수의 num가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수는 약수가 1과 자기뿐인 수 => 약수의 개수가 2개인 수
		 * 1은 소수가 아님
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 count(약수의 갯수)를 1증가
		 * 			num를 i로 나누었을 때 나머지가 0과 같다면 count를 1증가
		 * 반복문 종료 후 : count가 2이면 소수라고 출력하고 2보다 크면 소수가 아님이라고 출력
		 * */
		
		int num = 3,i,count;
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
		
		
		
		/* 내가함 (실패)
		int num = 5;
		int count = 0;
		for(int i = 1; i <= num; i++ ) {
			if(num % i == 0) {
				System.out.println(count + "는 소수임");
			}else if(num % i == 1 && num % i != 0) {
				System.out.println(count +"는 소수가 아님");
			}
			count++;

		}*/

}
