package day07;

public class MethodEx01 {

	public static void main(String[] args) {
		/* 클래스
		 * - 멤버 변수		예) 모니터
		 * 	 - 속성		예) 제조사
		 * - 멤버 메소드	
		 * 	 - 기능		예) 명암조정,채도조정
		 * - 생성자		
		 * 	 - 초기화		예) 초기화
		 * 
		 *  생성자 : 멤버 변수들의 값들을 초기화(일반적으로 public)
		 *  기본생성자
		 *  public 클래스명() {
		 *  	초기화;
		 *  }
		 *  생성자
		 *  public 클래스명(자료형 변수명, 자료형 변수명 , ...){	//자료형 변수명으로 초기화해주세요 하는것
		 *  	초기화;									// 옵션이라고 생각하면 됨
		 *  }
		 *  복사 생성자
		 *  public 클래스명(클래스명 객체명){	// 남이 만든 객체를 가지고 초기화 괄호안에 클래스와 같은 객체
		 *  	초기화;
		 *  }
		 *  
		 *  메소드 : 기능
		 *  접근제한자 예약어 리턴타입 메소드명(매개변수들){
		 *  	구현;
		 *  }
		 *  메소드	: 	예) 음료수 자판기 (콜라, 사이다, 환타)
		 *  리턴타입	:	음료수
		 *  	- 기능이 끝나고 나서 돌려주는 정보의 자료형 예) 1 + 3 이 뭐나교 했을 때 4라는 "정수값"
		 *  매개변수	:	돈, 메뉴
		 *  	- 기능이 실행되기 위해 필요한 정보들(필수)
		 *  
		 *  메소드 호출
		 *  메소드명(매개변수/값)
		 * */
		
		System.out.println(sum1(1,2));
		int num1 = 1, num2 = 2;
		sum2(num1,num2);
	}

	/* 기능 		: 두 정수가 주어지면 두 정수의 합을 알려주는 메소드 
	 * 매개변수	: 두 정수 = > int num1, int num2
	 * 리턴타입 	: 두 정수의 합 => 정수 => int
	 * 메소드명 	: sum1
	 * */
	public static int sum1(int num1, int num2) {
		return num1 + num2;
		//main에서 sysout이 필요함
	}
	
	
	/* 기능 		: 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드 
	 * 매개변수	: 두 정수 = > int num1, int num2
	 * 리턴타입 	: 없음 => void
	 * 메소드명 	: sum2
	 * */
	public static void sum2(int num1, int num2) {
		System.out.println(num1 + num2);
		//지금 이 코드에서는 return이 필요없지만
		//void에서 return을 사용할 수 있다는걸 보여주기 위해 추가함
		return; 
		// 이미 sysout을 호출했기 때문에 따로 칠 필요 없음
		// sum2(num1,num2); 로 출력
	}
}
