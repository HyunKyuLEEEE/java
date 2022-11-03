package day09;

import java.util.Scanner;

public class BaseballManager {

	public static void main(String[] args) {
		/* 숫자 야구게임을 플레이한 후, 기록을 저장하는 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 1. 홍길동 2회
		 * 2. 임꺽정 3회
		 * 3. 이몽룡 3회
		 * 4. 춘향이 4회
		 * */
		
		// 메뉴 털력
		
		// 메뉴 선택
		//선택한 메뉴에 따른 기능 실행
			//1. 플레이
				// 컴퓨터가 랜덤으로 숫자 생성
				// 사용자가 숫자 입력 //사용자의 숫자와 판별을 3S까지 반복되어야한다.
				// 판별
				// 3S종료
				// [new] 횟수를 기록(최대 5등), 
				// 5등 기준으로 횟수가 동일한 경우 먼저 플레이한 사용자 기록을 유지
			//2. 기록확인
				//등록된 5위까지의 기록 확인
			//3. 종료
		// 반복문을 통해 메뉴 출력
		int menu;
		int min = 1, max = 9, size = 3;
		int []com = createRandomArray(min, max, size);
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = selectMenu();
			// 종료
			
		}while(menu != 3);
		
	}

	/**
	 * 메뉴를 출력하는 메소드
	 */
	public static void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 게임 플레이");
		System.out.println("2. 기록 확인");
		System.out.println("3. 게임 종료");
		System.out.println("---------------");
		System.out.print("메뉴를 선택하세요 : ");
	}
	
	/**
	 * 콘솔에서 입력받은 정수(메뉴)를 알려주는 메소드
	 * @return 입력받은 정수(메뉴)
	 */
	public static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();		
	}
	
	
	/**
	 * 메뉴에 맞는 기능을 실행하는 메소드
	 * @param menu 선택한 메뉴
	 */
	public static int runMenu(int menu, int [] user, int[] com, int gameCount) {
		int min = 1, max = 9, size = 3;
		createRandomArray(min, max, size);
		printArray(com);
		int strike = 0, ball;
		Scanner sc = new Scanner(System.in);
		switch(menu) {
		case 1:
			
			
			if(strike <3) {
			//2.사용자가 숫자를 선택
			System.out.print("입력 : ");
			scanArray(sc, size);
			
			//3.판별
			strike = getStrike(com, user);
			ball = getBall(com, user);
				
			printGame(strike, ball);
				//2~3을 반복(3S가 될때까지)
			
			}
			gameCount++;
			System.out.println("게임 종료.");
			
			break;
		case 2:
			// 기록 확인
			break;
		case 3:
			// 종료
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다..");
		}
		return gameCount;
	}

	
	/**
	 * 기능 : strike와 ball의 개수가 주어지면 콘솔에 결과를 출력하는 메소드
	 * @param strike 스트라이크 개수
	 * @param ball 볼의 개수
	 */
	public static void printGame(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike+"S ");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("OUT");
		}
		System.out.println();
	}

	/** 
	 * 기능 : 두 배열이 주어지면 같은 번지에 있는 수를 비교하여 일치하는 숫자들이 몇개 있는지
	 * 알려주는 메소드
	 * @param arr1 int[] : 첫번째 정수 배열
	 * @param arr2 int[] : 두번째 정수 배열
	 * @return 같은 번지에서 일치하는 숫자들의 개수 
	 */
	public static int getStrike(int []arr1, int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		int strike = 0;
		for(int i = 0; i<size; i++) {
			if(arr1[i] == arr2[i]) {
				strike++;
			}
		}
		return strike;
	}
	/**
	 * 기능 : 두 정수 배열이 주어지면 같은 숫자들 중에서 번지가 서로 다른 숫자들의 개수를
	 * 알려주는 메소드
	 * @param arr1 int[] : 첫번째 정수 배열
	 * @param arr2 int[] : 두번째 정수 배열
	 * @return 같은 숫자들 중에서 번지가 서로 다른 숫자들의 개수
	 */
	public static int getBall(int []arr1, int []arr2) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int ball = 0;
		int strike = getStrike(arr1, arr2);
		for(int num : arr1) {
			if(contains(arr2, num)) {
				ball++;
			}
		}
		return ball - strike;
	}
	/** 
	 * 기능 : Scanner가 주어지면 정수를 size개만큼 입력받아 배열에 저장하고,
	 * 	 	 저장된 배열을 돌려주는 메소드
	 * 매개변수 : Scanner, size개 => Scanner scan, int size
	 * 리턴타입 : 정수 배열 => int []
	 * 메소드명 : scanArray
	 * @param scan	Scanner
	 * @param size	입력받을 정수의 개수
	 * @return 입력받은 값들이 저장된 배열
	 * */
	public static int[] scanArray(Scanner scan, int size) {
		if(size <= 0) {
			return null;
		}
		int [] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		return arr;
	}
	
	public static int countArray(int []arr1, int []arr2) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int count = 0;
		for(int tmp : arr1) {
			if(contains(arr2, tmp)) {
				count++;
			}
		}
		return count;
	}
	
	public static void printArray(int arr[]) {
		if(arr == null) {
			return;
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int [] createRandomArray(int min, int max, int size) {
		if(max - min + 1 <= size) {
			return null;
		}
		int arr[] = new int[size];
		//i는 0부터 i가 배열의 크기보다 작을 때까지 1씩 증가
		//=> i는 0부터 i가 배열의 크기보다 작을 때까지
		for(int i = 0; i<arr.length; ) {
			//랜덤한 수를 배열 i번지에 저장
			//=>랜덤한 수를 r에 저장
			int r = random(min, max);
			//배열에 r이 없으면 [배열 i번지에 r을 저장한 후, i를 1증가]
			if(!contains(arr, r)) {
				arr[i] = r;
				i++;
			}
		}
		return arr;
	}
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max - min + 1) + min);
	}
	public static boolean contains(int []arr, int num) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		for(int tmp : arr) {
			if(num == tmp) {
				return true;
			}
		}
		return false;
	}
	
}
