package day02;

import java.util.Scanner;

public class ScannerEx03 {	
	
	public static void  main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 콘솔에서 한 단어 이상을 입력하고 next(), nextLine()순으로 동작을 하면
		// nextLune에는 콘솔에서 따로 입력하지 않아도 앞에서 입력한 값이 들어간다.
		
		// 단어가 먼저 입력인 경우 "안녕하세요. 제 이름은 이현규입니다." 를 작성했을때
		// 안녕하세요를 sc.next() 에서 가져가고 공백 후에 뒤에 문장을 nextLine()에서 가져감
		System.out.println("한 단어를 입력하세요 :");
		String str2 = sc.next();
		System.out.println(str2);
		
		sc.nextLine(); // nextLine();을 한번 더 주어서 남은 문장을 버려준다.
					   // 입력 버퍼에 남아 있는 문자열과 공백을 제거
		
		System.out.println("한 문장을 입력하세요 : ");
		String str1 = sc.nextLine();
		System.out.println(str1);
		
		sc.close();
	}
}
