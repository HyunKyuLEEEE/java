package day04;

public class BreakLCMEx01 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 * 2의 배수 : 2,4,6,8,10,...
		 * 3의 배수 : 3,6,9,12...
		 * 2와 3의 공배수는 : 6,12,18,....
		 * 2와 3의 최소 공배수는 : 6
		 * 반복 횟수 : i는 num1 부터 num1* num2까지 num1씩 증가 ex) i = 2 i <= 6 i+=2
		 * 규칙성 : i가 num1과 num2의 배수이면 i를 출력 후 반복문 종료
		 * => i가 num1의 배수이고, i가 num2의 배수이면 i를 출력 후 반복문 종료
		 * => i를 num1으로 나누었을 때 나머지가 0과 같고,
		 * 	  i를 num2로 나누었을 때 나머지가 0과 같다면
		 * 	  i를 출력 후 반복문 종료
		 * => i를 num1으로 나누었을 때 나머지가 0과 같다 &&
		 * 	  i를 num2로 나누었을 때 나머지가 0과 같다
		 * => i % num1 == 0 && i % num2 == 0;
		 * 반복문 종료 후 : 없음
		 * */
		
		int num1 = 8, num2 = 12;
		int i;
		for(i = num1; i <= num1*num2; i += num1) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(i);
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		int i,num1,num2;
		num1 = 2;
		num2 = 3;
		
		for(i = num1 ; i <= num1*num2 ; i+=num1) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(i);
			break;
			}
		}
		*/
	}

}
