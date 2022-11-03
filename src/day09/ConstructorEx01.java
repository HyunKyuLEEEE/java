package day09;

import java.util.Scanner;

public class ConstructorEx01 {

	public static void main(String[] args) {
		Test01 t1 = new Test01();
		//Test02클래스는 기본생성자가 없기 때문에 기본 생성자로 초기화 할 수 없다.
//		Test02 t2 = new Test02();//에러발생 
		Test02 t2 = new Test02(10); //괄호 안에 숫자를 넣으면 사용 가능
		// Scanner클래스는 기본 생성자를 구현하지 않았기 떄문에 기본 생성자를 이용하여
		// 초기화 할 수 없다.
//		Scanner sc = new Scanner(); 
		
	}

}
class Test02{
	private int num;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public Test02(int num1) {
		this.num = num1;
	}
}
/* 클래스에 생성자를 하나도 구현하지 않으면 기본 생성자가 자동으로 추가가 된다.
 * 클래스에 생성자가 하나라도 있으면 기본 생성자가 자동으로 추가되지 않음
 * */
class Test01{
	private int num;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}