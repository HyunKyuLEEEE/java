package day25;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	/* 정수를 5번 입력하여 배열/리스트에 저장하는 코드를 작성하세요
	 * 정수가 홀수이면 그대로 저장, 정수가 짝수이면 -를 붙여서 저장
	 * */
	public static void main(String[] args) {
		int size = 5;
		int []arr1 = new int[size];  //방법 1: 배열 이용
		ArrayList<Integer> list = new ArrayList<Integer>();//방법 2 : 리스트 이용
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < size; i++) {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			if(num % 2 != 0) {
				arr1[i] = num; //방법 1: 배열 이용
				list.add(num);//방법 2 : 리스트 이용
				
			}else {
				arr1[i] = -num;//방법 1: 배열 이용
				list.add(-num);//방법 2 : 리스트 이용
			}
		}
		//for(int num : arr1) {
		for(int num : list) {
			System.out.print(num + " ");
		}
		
		
	}

}
