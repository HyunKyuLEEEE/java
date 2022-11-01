package day03;

public class ForEx03 {

	public static void main(String[] args) {
		// 구구단 2단을 출력하는 코드를 작성하세요.
		
		for(int i = 1; i <= 2 ; i++) {
			for(int j = 1; j < 10; j++) {
				if(i % 2 == 0) {
					System.out.println(i + " X " + j + " = " + (i*j));
				
				}
			}	
		}
	}

}
