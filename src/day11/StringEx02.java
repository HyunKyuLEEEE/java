package day11;

public class StringEx02 {

	public static void main(String[] args) {
		/* 문자열 str에 search가 몇번 등장하는지 확인하는 코드를 작성하세요.*/
		String str = "Hello Wolrd! My name is Hong";
		String search = "o";

		//str에서 search가 있는 위치를 찾음
		// -1이 아니면 부분문자열을 추출하고,count 1를 증가
		// -이면 반복분 종료
		String temp = str;
		int count = 0;
		while(true) {
			System.out.println(temp);
			int index = temp.indexOf(search);
			if(index == -1) {
				break;
			}
			temp = temp.substring(index + search.length());
			count++;
		}
		System.out.println(str + "에는 " + search + "가 " + count + "번 있습니다.");
		
	}

}
