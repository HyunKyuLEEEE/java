package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexPhoneNumberEx01 {

	public static void main(String[] args) {
		/* 전화번호 정규표현식을 작성하여 입력받은 번호가 전화번호가 맞는지 출력하는 코드를
		 * 작성하세요.
		 * 규칙
		 * 010-1234-5678 	[O]
		 * 01012345678		[X]
		 * 011-1234-5678	[X]
		 * 
		 * 010-[0-9]{4}-[0-9]{4}
		 * 010-\d{4}-\d{4}
		 * 010(-\d{4}){2}
		 * */

		String regex = "010(-\\d{4}){2}";
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(Pattern.matches(regex, str)) {
			System.out.println(str + "은 휴대폰 번호입니다.");
		}else {
			System.out.println(str + "은 휴대폰 번호 형식이 아닙니다.");
		}
		sc.close();
	}

}
