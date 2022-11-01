package day06;

import java.util.Scanner;

public class ArrayLottoEx01 {

	public static void main(String[] args) {
		/* 로또 번호를 랜덤으로 생성하고, 당첨번호를 입력하여 몇등 당첨됬는지 출력하는 코드를
		 * 작성하세요.
		 * 숫자 범위 : 1 ~ 45 중 6개
		 * 1등 : 6개
		 * 2등 : 5개 + 보너스번호
		 * 3등 : 5개
		 * 4등 : 4개
		 * 5등 : 3개
		 * 로또 번호 : 번호 6개와 보너스 번호 1개 => 총 7개
		 * */

		// 랜덤으로 6개의 로또 번호 생성
		int size = 6;
		int lotto[] = new int[size]; 	// 랜덤 수를 저장한 배열
		int count = 0; 				// 저장된 랜덤 수의 갯수
		int min = 1, max = 45; 		// 랜덤 수 범위		
		while(count < size) {			// 저장된 숫자가 3보다 작을 때까지
			// 랜덤한 수 생성
			int r = (int)(Math.random()*(max - min + 1)+min);
			
			boolean isDuplicated = false;
			for(int i =0 ; i < count; i++) {
				if(lotto[i] == r) {
					isDuplicated = true;
				}
			}
			if(isDuplicated) {
				continue;
			}
			lotto[count++] = r;		// lotto[count++] = r;
			
		}
		
		
		System.out.print("로또 번호 확인 : ");
		for(int temp : lotto) {
			System.out.print(temp + " ");
		}
		// 보너스 번호를 랜덤으로 생성(위에서 생성한 번호와 중복되지 않게)
		int bonus;
		while(true) {
			int r = (int)(Math.random()*(max - min + 1)+min);
			boolean isDuplicated = false;
			for(int i =0 ; i < lotto.length; i++) {
				if(lotto[i] == r) {
					isDuplicated = true;
				}
			}
			if(isDuplicated) {
				continue;
			}
			bonus = r;
			break;
		}
		System.out.println(" 보너스 : " + bonus);
		
		// 당첨번호 6개를 입력받음
		Scanner sc = new Scanner(System.in);
		System.out.print("\n당첨 번호 입력 : ");
		int user[] = new int[6];
		for(int i = 0; i < size; i++) {
			user[i] = sc.nextInt();				
		}
		sc.close();
		// 일치하는 번호 개수를 구함(보너스 번호 제외)
		int sameCount = 0;
		for(int i = 0; i <lotto.length; i++) {
			for(int j = 0 ; j <user.length; j++) {
				if(lotto[i] == user[j]) {
					sameCount++;
				}
			}
		}
		
		// 등수 판별
		switch(sameCount) {
		case 6:
			System.out.println("1등");
			break;
		case 5:
			boolean isDuplicated = false;
			for(int i =0 ; i < user.length; i++) {	//중복이 맞는지 확인하는 문구
				if(user[i] == bonus) {
					isDuplicated = true;
				}
			}
			if(isDuplicated) {
				System.out.println("2등");
			}else {
				System.out.println("3등");
			}
			break;
		case 4:
			System.out.println("4등");
			break;
		case 3:
			System.out.println("5등");
			break;
		default:
			System.out.println("꽝!");
			
		}
		
		/* 내가 한 잘못된것
		int size = 6;
		int lotto[] = new int[size]; 	// 랜덤 수를 저장한 배열
		int count = 0; 				// 저장된 랜덤 수의 갯수
		int min = 1, max = 45; 		// 랜덤 수 범위		
		
		while(count < size) {			// 저장된 숫자가 3보다 작을 때까지
			// 랜덤한 수 생성
			int r = (int)(Math.random()*(max - min + 1)+min);
			
			boolean isDuplicated = false;
			for(int i =0 ; i < count; i++) {
				if(lotto[i] == r) {
					isDuplicated = true;
				}
			}
			if(isDuplicated) {
				continue;
			}
			lotto[count] = r;		// arr[count++] = r;
			count++;			// continue가 있어서 이 두개가 실행이 안됨
		}
		System.out.println("이번 주 당첨번호는");
		for(int temp : arr) {
			System.out.print( temp + " " );
		}
		System.out.println();
		int num = 6;
		int num1[] = new int[num];
		Scanner sc = new Scanner(System.in);
		System.out.print("번호를 입력하세요 : ");
		for(int i = 0; i < arr.length - 1; i++) {
			num1[i] = sc.nextInt();
			if(arr[0] == num && arr[1] == num && arr[2] == num && arr[3] == num 
					&& arr[4] == num && arr[5] == num && arr[6] != num) {
				System.out.println("1등입니다.");
			}else if(arr[0] == num && arr[1] == num && arr[2] == num && arr[3] == num 
					&& arr[4] == num && arr[5] != num && arr[6] == num) {
				System.out.println("2등입니다.");
			}else if(arr[0] == num && arr[1] == num && arr[2] == num && arr[3] == num 
					&& arr[4] == num && arr[5] != num && arr[6] != num) {
				System.out.println("3등입니다.");
			}else if(arr[0] == num && arr[1] == num && arr[2] == num && arr[3] == num 
					&& arr[4] != num && arr[5] != num && arr[6] != num) {
				System.out.println("4등입니다.");
			}else if(arr[0] == num && arr[1] == num && arr[2] == num && arr[3] != num 
					&& arr[4] != num && arr[5] != num && arr[6] != num) {
				System.out.println("3등입니다.");
			}else {
				System.out.println("낙첨입니다.");
				break;
			}
			
		}
		*/	
	}

}
