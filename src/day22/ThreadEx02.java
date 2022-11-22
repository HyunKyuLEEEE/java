package day22;

public class ThreadEx02 {
	public static void main(String[] args) {
		//현재 기본적으로 실행되는 쓰레드의 정보를 가져오는 것
		Thread t = Thread.currentThread();
		System.out.println("현재 쓰레드명 : " + t.getName());
		//러너블 인터페이스는 직접 객체를 만들어주는게 아니라 
		//쓰레드의 생성자를 통해서 만들어준다.
		//Thread t2 = new Thread(new Thread02());
		Thread t2 = new Thread(()->{
			for(int i = 0; i < 10000; i++) {
				System.out.print("-");
			}
		});
		t2.start();
		for(int i = 0; i <10000 ;i++) 
			System.out.print("|");
		
	}
}

class Thread02 implements Runnable{
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.print("-");
		}
	}
}
