package day12;

public class Test {

	public static void main(String[] args) {
	

	}
	//접근제한자 예약어 리턴타입 메소드명(매개변수);
	//추상 클래스를 상속받은 일반 클래스는 부모의 추상 메소드를 반드시 오버라이딩해야함
	//추상 클래스를 상속받은 추상 클래스는 부모의 추상 메소드를 반드시 오버라이딩해야하는 것은 아님
}

interface Calculator{
	int max = 30; // 자동으로 public static final이 붙여진다.
	int sum(int num1, int num2);
	int sub(int num1, int num2);
	int mul(int num1, int num2);
	double div(int num1, int num2);
	int mod(int num1, int num2);
	void run();
}

interface Test1{
	void print();
}

interface Test2{
	void print();
}

interface Test3 extends Test1, Test2{
	
}