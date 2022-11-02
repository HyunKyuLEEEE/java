package day08;

import java.util.Arrays;
import java.util.Scanner;

public class MethodLottoEx01 {
	// 메소드를 만드는 이유
	// 1. 재사용을 통해 코드의 길이를 줄임
	// 2. 기능의 유지보수가 쉬어짐
	// 3. 구조적으로 분석하기 쉬어짐

	public static void main(String[] args) {
		int min = 1, max = 45;
		int size = 6;
		//로또 번호 생성
		int lotto[] = createRandomArray(1,45,6);
		//로또 번호 정렬
		Arrays.sort(lotto);
		//로또 번호 출력
		printArray(lotto);
		//보너스 번호 생성
		int bonus;
		do {
			bonus = random(min, max);
		}while(contains(lotto, bonus));
		System.out.println("보너스 번호 : " + bonus);
		
		//로또 번호 입력
		int [] user = new int[size];
		System.out.print("입력 번호 : ");
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < user.length; i++) {
			user[i] = sc.nextInt();
		}
		sc.close();
		
		/*
		//번호가 일치하는지 확인
		switch(countLotto2(lotto, user)) {
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
			
		}*/
		
		//당첨 등수를 알려주는 코드를 작성하세요. 단, 메소드를 이용할 것
		int rank = getRank(lotto, bonus, user);
		printRank(rank);
	}
	
	/* 기능 : 로또 번호(보너스 번호 포함)와 입력번호가 주어지면 등수를 알려주는 메소드
	 * 매개변수 : 로또번호, 입력번호 => int []lotto, int bonus, int []user
	 * 리턴타입 : 등수 => 정수 => int
	 * 메소드명 : getRank
	 * */
	
	public static int getRank(int []lotto, int bonus, int []user) {
		int count = countLotto1(lotto, user);
		switch(count) {	// break가 필요없는 이유는 return이 있어서
		case 6 :	
			return 1;
		case 5 :	
			return contains(user, bonus) ? 2 : 3;
		case 4 : 	
			return 4;
		case 3 : 	
			return 5;
		default:	
			return -1;
		}
	}
	
	/* 기능 : 등수가 주어지면 등수를 콘솔에 출력하는 메소드
	 * 매개변수 : 등수 => 정수 => int rank
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printRank
	 * */
	public static void printRank(int rank) {
		switch(rank) {
		case 1:		System.out.println("1등!"); break;
		case 2:		System.out.println("2등!"); break;
		case 3:		System.out.println("3등!"); break;
		case 4:		System.out.println("4등!"); break;
		case 5:		System.out.println("5등!"); break;
		case -1:	System.out.println("꽝!"); break;
		}
	}
	
	/* 기능 : 주어진 두 배열에서 일치하는 숫자의 개수를 알려주는 메소드
	 * 매개변수 : 로또와 유저가 입력한 숫자 배열 => lotto[] user[]
	 * 리턴타입 : 숫자의 갯수 => 정수 => int
	 * 메소드명 : countLotto
	 * */
	
	public static int countLotto1(int []arr1, int []arr2) {
		if(arr1 == arr2) {
			return 0;
		}
		int count = 0;
		for(int temp : arr1) {
			if(contains(arr2, temp)) {
				count++;
			}
		}
		return count;
	}
	
	/* 기능 : 주어진 두 배열에서 일치하는 숫자의 개수를 알려주는 메소드
	 * 매개변수 : 로또와 유저가 입력한 숫자 배열 => lotto[] user[]
	 * 리턴타입 : 숫자의 갯수 => 정수 => int
	 * 메소드명 : countLotto
	 * */
	
	/*
	public static int countLotto2(int lotto[], int user[]) {
		int sameCount = 0;
		for(int i = 0; i <lotto.length; i++) {
			for(int j = 0 ; j <user.length; j++) {
				if(lotto[i] == user[j]) {
					sameCount++;
				}
			}
		}
		return sameCount;
	}
	*/
	public static void printArray(int arr[]) {
		// 참조변수는 기본적으로 주소로 저장해야한다. null
		if(arr == null) {	//참조변수들
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	// ex) min 1 , max , size 4 <= 못 만듬 중복되면 null로 리턴
	public static int[] createRandomArray(int min, int max, int size) {
		if(max - min + 1 <= size) {
			return null;
		}
		int arr[] = new int[size];
		//i는 0부터 i가 배열의 크기보다 작을 때까지 1씩증가
		// => i는 0부터 i가 배열의 크기보다 작을 때까지
		for(int i = 0; i < arr.length;) {
			//랜덤한 수를 배열 i번제이 저장
			//=>랜덤한 수를 r에 저장
			int r = random(min, max);
			//배열에 r이 없으면 [배열 i번지에 저장한 후, i를 1증가]
			if(!contains(arr, r)) {
				arr[i] = r;
				i++;
			}
			
		}
		return arr;
	}
	
	public static int random(int min, int max) {
		if(min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return (int)(Math.random()*(max - min +1) + min);
	}
	
	public static boolean contains(int [] arr, int num) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		for(int temp : arr) {
			if(num == temp) {
				return true;
			}
		}
		return false;
	}
	

	
}
