package day07;

public class MethodArrayEx02 {

	public static void main(String[] args) {
		/* 1~9 사이의 랜덤한 수를 배열에 3개 저장하는 코드를 작성하세요
		 * 메소드를 이용할 것
		 * */
		int min = 1; int max = 9;
		int arr1[] = new int[3];
		createRandomArray1(arr1, min, max);	//밖에서 배열을 만들어 줘야한다.
		printArray(arr1);
		
		int arr2[] = createRandomArray2(min, max, 3);
		printArray(arr2);
		
		
		
		int arr[] = new int[3];
		printRandomArray(arr);
		System.out.println();
		
		for(int i = 0; i < arr.length ; i++) {
			methodArray(1, 9, arr);
			System.out.print(arr[i] + " ");
		}

		
	}
	
	public static void printArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	/* 기능 : 최소값과 최대값 사이의 랜덤한 수를 주어진 배열에 저장하는 메소드
	 * 매개변수 : 최소값, 최대값, 배열 => int arr[], int min, int max
	 * 리턴타입 :	없읍 => void
	 * 메소드명 : createRandomArray1
	 * */
	
	public static void createRandomArray1(int arr[], int min, int max) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random(min, max);
		}
	}
	
	
	/* 기능 : 최소값과 최대값 사이의 랜덤한 수를 size개 만들어 배열에 저장한 후,
	 * 		 저장된 배열을 반환하는 메소드
	 * 매개변수 : 최소값, 최대값, 만들 갯수 => int min, int max, int size
	 * 리턴타입 : 랜덤한 수가 저장된 배열 => int[]
	 * 메소드명 : createRandomArray2
	 * */
	
	public static int[] createRandomArray2(int min, int max, int size) {
		int arr[] = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random(min, max);
		}
		return arr;
	}
	
	/* 기능 : 최소값과 최대값 사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 매개변수 : 최소값, 최대값 => int min, int max
	 * 리턴타입 : 랜덤한 수 => 정수 => int
	 * 메소드명 : random
	 * */
	public static int random(int min, int max) {
		return (int)(Math.random()*(max - min +1) + min);
	}
	
	
	/* 기능 : 1~9 사이의 랜덤한 수를 배열에 3개 저장하여 출력
	 * 매개변수 : 정수 배열 => int arr[]
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printArray
	 * */
	
	public static void printRandomArray(int arr[]) {
		int min = 1, max = 9;
		for(int i = 0; i < 3; i++) {
			arr[i] = (int)(Math.random()*(max - min + 1)+min);
			System.out.print(arr[i] + " ");
		}
	}
	
	/* 기능 : 처음 숫자1에서 끝 정수9 사이의 랜덤한 수를 배열에 3개 저장하는 메소드
	 * 매개변수 : 첫 숫자, 끝 숫자, 정수의 배열 => int start , int end, int arr[]
	 * 리턴타입 : 배열 => int[]
	 * 메소드명 : methodArray
	 * */
	
	public static int[] methodArray(int start, int end, int arr[]) {
		for(int i = 0; i < 3; i++) {
			arr[i] = (int)(Math.random()*(start - end + 1)+end);
		}
		
		return arr;
	}
	
}
