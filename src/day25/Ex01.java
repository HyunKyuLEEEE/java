package day25;

import java.util.Scanner;

public class Ex01 {

	/* 정수르 입력받아 입력받은 정수가 0이상이면 0부터 입력받은 수까지 합을 구하고,
	 * 입력받은 정수가 0미만이면 0부터 입력받은 수까지 차를 구하는 코드르 작성하세요.
	 * 예 :
	 * 정수입력 : 3
	 * 0부터 3까지의 합 : 6
	 * 정수 입력 : -3
	 * 0부터 -3까지 누적 차 : 6
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, sum, num =0;
		sum = 0;
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		String str = "합";
		if(num >= 0) {
			for(i = 0; i <= num; i++) {
				sum += i;
			}		
		}else if(num < 0) {
			for(i = 0; i >= num; i--) {
				sum -= i;
				str = "차";
			}			
		}		
		System.out.println("0부터" + num + "까지 " + str + " : " + sum);
	}

}


