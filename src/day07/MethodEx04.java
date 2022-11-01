package day07;

public class MethodEx04 {

	public static void main(String[] args) {
		int num = 10;
		Test t = new Test();
		printNum(num);
		printNum(num);
		printTest(t);
		printTest(t);
	}
	// main에 있는 num와 printNum에 있는 num는 서로 다른 변수
	// 값을 복사해서 가져온다.
	// 매개변수가 기본 자료형인 경우, printNum에서 숫자를 바꿔도 main에서 num는 안 바뀐다.
	// 매개변수가 참조 변수인 경우, 다른 곳에서 숫자를 바꾸면 main에 있는 값도 바뀔 수 있다.	(원본 값이 바뀔 수 있다)
	public static void printNum(int num) {	//main의 num과 메소드안의 num은 이름 같고 다른 변수
		System.out.println(num);			//main의 값을 메소드의 num에 준다는 의미
		num = 20;
	}
	// 매개변수가 참조 변수인 경우, printTest에서 숫자를 바꾸면 main에 있는 값도 바뀔 수 있다.
	public static void printTest(Test t){
		System.out.println(t.a);
		t.a = 20;
	}
}
class Test{
	int a;
}