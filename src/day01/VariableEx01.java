package day01;

public class VariableEx01 {

	public static void main(String[] args) {
		/* 변수 선언
		 * 자료형 변수명;
		 * 자료형 변수명 = 초기값;
		 * - 자료형(Data Type)
		 */
		
		// 기본 자료형
		boolean isEven = false; 	// 참/거짓을 묻기때문에 질문형으로 변수명을 작성함 <-선언과 동시에 초기화
		char operator = '+';		// 캐릭터는 한 글자는 따옴표, 
		int age = 30;				// 정수형, 소수점이 찍힐 수 없음.
		float pi1 = 3.1415f;		// float은 접미사 F나 f를 반드시 붙어야한다.
		double pi2 = 3.1415;		//
		// 참조형 문자열
		String str = "Hi";			// "를 사용하면 공백, 한글자도 사용할 수 있다.
		
		
		//사과의 갯수를 저장하기 위한 변수
		int apple;
		
		
		//학생 평균 성적을 저장하기 위한 변수를 선언해 보세요
		double scoreAvg;
		
		int num;
//		int num;	// Duplicate local variable num : 중복된 변서 선언
		int NUM;	// 대소문자를 구분
		int num1;
//		int 1num;	// 숫자로 시작할 수 없다.
		int _num, $num;
//		int !num2;	// _와 $가 아닌 특수문자로 시작할 수 없다.
//		int int;	// 예약어를 변수명으로 사용할 수 없다.
		
		
		/* 관례 : 안지켜도 되지만 많은 개발자들이 지킴
		 *  - 변수는 소문자로 시작
		 *  - 카멜 표기법을 따라서 두번째 단어부터 첫 글자를 대문자로 사용
		 *  - 클래스와 인터페이스는 대문자로 시작한다.
		 */
	}

}
