package day07;

public class ClassTestEx01 {

	public static void main(String[] args) {
		/* 인스턴스화 방법 - 객체를 만든다
		 * 클래스명 객체명 = new 클래스명();
		 * */
		
		String str = new String("abc");
		Person person1 = new Person();
		// pNo에 private을 추가하기 전에는 외부에서 접근이 가능했지만
		// 캡슐화를 통해 pNo의 접근제한자를 private으로 설정하면 직접 접근이 불가능하다. => 에러발생
		//person1.pNo = "000101-4123456";
				
		//캡슐화된 pNo에 접근하려면 getter와 setter를 통해 접근해야합니다.
		person1.setpNo("000101-4123456");
		//System.out.println("주민번호 : " + person1.pNo);
		System.out.println("주민번호 : " + person1.getpNo());
		System.out.println(str.charAt(0));	//함수는 그 자체로 출력
		
	}

}

/*
class 클래스명{
	접근제한자 자료형 변수명;	//멤버변수

}
*/

/* 접근제한자 종류
 * - private	: 본인 클래스 => 사용가능 
 * - (default)	: 본인 클래스 + 같은 패키지 => 사용 가능(아무것도 안쓴걸 default라고 함)
 * - protected	: 본인 클래스 + 같은 패키지 + 자식 클래스 => 사용가능
 * - public		: 본인 클래스 + 같은 패키지 + 자식 클래스 + 외부클래스 => 전부 사용가능
 * 
 * 	일반적으로 멤버변수들은 private를 씀
 *  */

class Person{
	private String pNo;
	private String name;
	private char gender;
	private String address;
	private String phone;
	private int age;
	
	/*
	// 외부에서 접근해줄 수 있는 코드
	public void setPNo(String personNumber) {	// 멤버변수의 값을 설정해주는 것 
		pNo = personNumber;
	}
	
	public String getPNo() {	//
		return pNo;
	}
	*/
	
	
	
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}