package day06;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortEx01 {

	public static void main(String[] args) {
		// 버블 정렬을 이용한 배열 정렬
		int arr[] = {1,9,5,7,2,8,6,3};
		for(int i = 0; i < arr.length - 1; i++) {	//2개씩 비교해서 배열의 길이에 -1을 한다. 
			for(int j = 0 ; j < arr.length - 1 - i; j++) {// 그리고 확정될 때 마다 비교할 필요가 없어서 -i를 추가(없어도 됨)
				// 두 수를 바꾸는 코드 (중요)
				if(arr[j] > arr[j+1]) { 	//j가 j다음 것보다 작다면
					int temp = arr[j];
					arr[j] = arr[j+1];	
					arr[j+1] = temp;	
					
				}
			}
			for(int temp : arr) {
				System.out.print(temp + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
		int arr2 [] = {9,8,7,6,5,4,3,2};
		Arrays.sort(arr2);
		for(int temp : arr2) {
			System.out.print(temp + " ");
			
		}
		System.out.println();
		System.out.println("------------------");
		
		Integer arr3 [] = {9,8,7,6,5,4,3,2};
		Arrays.sort(arr3, Collections.reverseOrder()); // 역순
		for(int temp : arr3) {
			System.out.print(temp + " ");
		}
	}

}
