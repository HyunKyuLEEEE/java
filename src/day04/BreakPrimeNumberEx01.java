package day04;

public class BreakPrimeNumberEx01 {

	public static void main(String[] args) {
		// 나보다 작은 수부터 약수를 찾아서 처음 만나는 약수가 1이면 됨
		// 6 => 5부터 시작해서 약수인지 찾는다.
		// 6 => 5,4,3,
		// 7 => 6,5,4,3,2,1
		
		// break문을 이용하여 소수를 판별하는 예제
		int num = 13;
		int i;
		for(i = num-1; i > 0 ; i--) {
			if(num % i == 0) {
				break;
			}
		}
		if(i == 1) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수가 아님");
		}

	}

}
