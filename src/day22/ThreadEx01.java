package day22;

public class ThreadEx01 {

	public static void main(String[] args) {
		//현재 기본적으로 실행되는 쓰레드의 정보를 가져오는 것
		Thread t = Thread.currentThread();
		System.out.println("현재 쓰레드명 : " + t.getName());
		
		Thread01 t1 = new Thread01();
		t1.start();
		for(int i = 0; i <10000 ;i++) 
			System.out.print("|");
		
	}
}

class Thread01 extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.print("-");
		}
	}
}