package day06;

import java.util.Scanner;

public class ArrayScoreEx01 {

	public static void main(String[] args) {
		/* 5명 학생의 국어, 영어, 수학 성적을 저장하기 위한 배열을 만들고
		 * Scanner를 이용하여 입력받아, 국어평균, 영어평균, 수학평군을 구하는 코드를
		 * 작성하세요.
		 * */
		
		int stdCount = 5;
		int kor[] = new int[stdCount];
		int eng[] = new int[stdCount];
		int math[] = new int[stdCount];		
		
		// 학생별 국어, 영어, 수학 성적을 입력하세요
		Scanner sc = new Scanner(System.in);
		
		
		for(int i = 0 ; i < stdCount ; i++ ) {
			System.out.print("학생" + (i+1) +"의 국어, 영어,수학 성적을 입력하세요 : ");
			kor[i] = sc.nextInt();
			eng[i] = sc.nextInt();
			math[i] = sc.nextInt();
		}
		
		// 과목별 합(총점)
		double korSum = 0, engSum = 0, mathSum = 0;
		for(int i = 0; i < stdCount ; i++) {
			korSum += kor[i];
			engSum += eng[i];
			mathSum += math[i];
		}
		
		
		// 과목별 평균
		System.out.println("국어 성적의 평균 : " + korSum / stdCount);
		System.out.println("영어 성적의 평균 : " + engSum / stdCount);
		System.out.println("수학 성적의 평균 : " + mathSum / stdCount);
		
		
		// 학생별 평균
		for(int i = 0; i < stdCount; i++) {
			double sum = kor[i] + eng[i] + math[i];
			System.out.println("학생" + (i+1) + "의 평균 : " + sum/3);
		}
				
		
		/*  내가 한것
		int kor[] = new int[5];
		int eng[] = new int[5];
		int math[] = new int[5];

		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < kor.length; i++) {
			System.out.print("국어 성적을 입력하세요 : ");
			kor[i] = sc.nextInt();
			System.out.println(kor[i] + "점 입니다.");
		}
		
		for(int i = 0; i < eng.length; i++) {
			System.out.print("영어 성적을 입력하세요 : ");
			eng[i] = sc.nextInt();
			System.out.println(eng[i] + "점 입니다.");
		}
		
		for(int i = 0; i < math.length; i++) {
			System.out.print("수학 성적을 입력하세요 : ");
			math[i] = sc.nextInt();
			System.out.println(math[i] + "점 입니다.");
		}
		
		int korSum = 0;
		for(int i = 0; i < kor.length; i++ ) {
			korSum += kor[i];
		}
		double korAvg = korSum / kor.length;
		System.out.println("국어 성적의 평균은 : " + korAvg + "입니다.");

		int engSum = 0;
		for(int i = 0; i < eng.length; i++ ) {
			engSum += eng[i];
		}
		double engAvg = engSum / eng.length;
		System.out.println("영어 성적의 평균은 : " + engAvg + "입니다.");
		
		int mathSum = 0;
		for(int i = 0; i < math.length; i++ ) {
			mathSum += math[i];
		}
		double mathAvg = mathSum / math.length;
		System.out.println("수학 성적의 평균은 : " + mathAvg + "입니다.");
		
		*/
	}
	

}
