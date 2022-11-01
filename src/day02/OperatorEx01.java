package day02;

public class OperatorEx01 {

	public static void main(String[] args) {
		// !(Not)연산자 : 참 또는 거짓이 값(변수,리터럴,조건식) 앞에 옵니다. 
		// 				정수,실수,문자,문자열 앞에 올 수 없다.
		//				자바에서는 참 또는 거짓에서만 올 수 있다.
		boolean isMale = true;
		boolean isFemale = false;
		System.out.println("남성입니까? : " + isMale + "," + isFemale);
		System.out.println("여성입니까? : " + !isMale + "," + isFemale);
		


	}

}
