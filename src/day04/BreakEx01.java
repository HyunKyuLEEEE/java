package day04;

public class BreakEx01 {

	public static void main(String[] args) {
		
		// break를 만나면 증감식으로 가지 않고, 반복문을 빠져 나감
		// break를 포함하고 있는 반복문을 빠져나간다.
		// break와 가까운 반복문이 아님.
		for(int i = 1; i < 6; i++) {
			System.out.println("Hello World!");
			if( i == 3) {
				break;
			}
			
		}
		//B
	}

}
