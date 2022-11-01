package day06;

import java.util.Arrays;

public class ArrayCopyEx02 {

	public static void main(String[] args) {
		//깊은 복사 예제
		int arr1[] = new int[] {1,2,3};
		int arr2[];
		
		//깊은 복사 예제1
		/*
		arr2 = new int[arr1.length];
		for(int i = 0 ; i < arr1.length ; i++) {
			arr2[i] = arr1[i];
		}*/
		
		
		
		//깊은 복사 예제2
		// 해당 배열값을 그대로 복수해서 그대로 가져옴
		// 할당을 하고 넣어줌
		/*
		arr2 = new int[arr1.length];
		System.arraycopy(arr1, 0, arr2, 0, arr1.length); 
		*/
		
		//깊은 복사 예제3
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		/* 깊은 복사 예제3을 풀어 쓴 것
		int tempArr[] = new int[arr1.length];
		for(int i = 0 ; i < arr1.length ; i++) {
			tempArr[i] = arr1[i];
		}
		arr2 = tempArr;
		*/
		
		
		//arr1과 arr2 값 확인
		for(int i = 0; i < arr1.length; i++) {
			System.out.println("arr1["+i+"] = " + arr1[i] + " , arr2[" + i + 
					"] = " + arr2[i] );
		}
		arr1[0] = 10; // arr1의 값만 10으로 변경
		System.out.println("-------------");
		//arr1 과 arr2 값 확인 , arr1만 10이 출력
		for(int i = 0; i < arr1.length; i++) {
			System.out.println("arr1["+i+"] = " + arr1[i] + " , arr2[" + i + 
					"] = " + arr2[i] );
		}
	}

}
