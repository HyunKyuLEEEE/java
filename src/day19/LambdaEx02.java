package day19;

import java.util.function.Consumer;

public class LambdaEx02 {

	public static void main(String[] args) {
		/* 실행문이 하나일 경우 중괄호 생략
		 * void가 아닌 경우 리턴을 제거
		 * 매개변수가 하나인 경우 괄호 생략가능*/
		Sum sum = (a, b)-> a + b;
		System.out.println(sum.run(1,2));
		Print<String> print = num -> System.out.println(num);
		print.run("문자열");
		Consumer<String> print2 = str->System.err.println(str);
		print2.accept("컨슈머");
	}
}

interface Sum{
	double run(double a, double b);
}
interface Print<T>{
	void run(T num);
}