package day16;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx01 {
	public static void main(String[] args) {
		//map은 순서대로 정리하지 않음
		HashMap<String, String> userList = new HashMap<String, String>();
		userList.put("id1", "pw1");
		userList.put("id2", "pw2");
		userList.put("id3", "pw2");
		userList.put("id3", "pw3");
		System.out.println(userList);
		
		//방법1. keySet을 이용
		//keySet()은 map에 있는 key들을 하나의 set에 담아 반환하는 메소드
		Set<String> keySet = userList.keySet();
		for(String temp : keySet) {
			System.out.println(temp + " : " + userList.get(temp));
		}
		System.out.println();
		
		//방법2. EntrySet을 이용
		Set<Entry<String, String>> entrySet = userList.entrySet();
		for(Entry<String, String> temp : entrySet) {
			System.out.println(temp.getKey() + " : " + temp.getValue());
		}
	}
}
