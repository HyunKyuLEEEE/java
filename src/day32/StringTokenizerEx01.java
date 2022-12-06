package day32;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		String str = "abc,def,.ghi";
		//정규표현식으로 적용 ,와 문자하나(.)를 구분자로 본다.
		String [] arr = str.split(",.");	
		for(String temp : arr) {
			System.out.println(temp);
		}
		System.out.println("===============================");
		//. 또는 ,를 구분자로 본다.
		StringTokenizer st = new StringTokenizer(str, ".,");
		System.out.println("개수 : " + st.countTokens());
		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			System.out.println(temp);
		}
		System.out.println("===============================");
		st = new StringTokenizer(str, ".,", true);
		System.out.println("개수 : " + st.countTokens());
		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			System.out.println(temp);
		}
	}

}
