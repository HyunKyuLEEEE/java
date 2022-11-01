package day04;

public class NestingForStarEx01 {
	
	public static void main(String[] args) {
		/* *****
		 * *****
		 * *****
		 * *****
		 * *****
		 * */
		
		int i, j;
		for( i = 1; i <= 5; i++) {
			System.out.println("*****");
		}
		System.out.println("----------------------");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
