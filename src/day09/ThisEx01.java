package day09;

public class ThisEx01 {

	public static void main(String[] args) {
		Test03 t1 = new Test03();
		t1.print();
		Test03 t2 = new Test03(10);
	}

}
/* this : 객체 본인을 나타내는 참조변수
 *  - 주로 매개변수의 이름과 멤버변수(필드)의 이름이 같으면서 메소드안에서 같이 사용되는 경우 사용
 *  	=> 메소드에서 매개변수의 이름과 멤버변수(필드)의 이름이 같으면 변수를 호출했을 때 매개변수가 불려짐
 *  - 메소드명이 길때 자동완성을 위해서 사용
 *  this() : 해당 클래스의 생성자를 호출하고, 생성자에서 첫번째 줄에 추가한다.
 * */
class Test03{
	private int num;
	// 매개변수와 필드의 이름이 같은경우에 사용
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return this.num;
	}
	public void print() {
		System.out.println(this.getNum());
	}
	public Test03() {
		this(10);
		num = 20;
	}
	public Test03(int num) {
		this.num = num;
	}
}