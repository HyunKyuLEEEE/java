package day07;

public class MethodEx07 {

	public static void main(String[] args) {
		int [] arr = {1,3,5};
		test(arr);
		for(int temp : arr) {
			System.out.print(temp + " ");
		}

	}

	public static void test(int []arr) {
		arr = new int[3];	//이 코드에 의해 main에 있는 arr이 바뀌지 않음
		//main과 공유하던 배열을 끊고 새 배열을 만들어서 사용하기 떄문에
		arr[0] = 10;
	}
}
