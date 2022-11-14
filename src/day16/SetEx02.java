package day16;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx02 {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(11);
		for(Integer temp : set) {
			System.out.print(temp + " ");
		}
		System.out.println();
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer temp = it.next();
			System.out.print(temp + " ");
		}
		System.out.println();
	}
}
