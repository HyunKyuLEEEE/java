package day20;

import lombok.Data;

@Data
public class PhoneBook {
		
	private String phoneNum, phoneName;

	public PhoneBook(String phoneNum, String phoneName) {
		this.phoneNum = phoneNum;
		this.phoneName = phoneName;
	}

	@Override
	public String toString() {
		return "[" + phoneNum + " | " + phoneName + "]";
	}
	
}
