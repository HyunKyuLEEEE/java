package day20;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PhoneNumber extends PhoneBook{
	//필드
	private String lastName, firstName, company;
	private ArrayList<PhoneBook> PhoneBook = new ArrayList<PhoneBook>();		
	//생성자
	public PhoneNumber(String phoneNum, String phoneName, String lastName, String firstName, String company,
			ArrayList<PhoneBook> phoneBook) {
		super(phoneNum, phoneName);
		this.lastName = lastName;
		this.firstName = firstName;
		this.company = company;
		PhoneBook = phoneBook;
	}
	@Override
	public String toString() {
		return "PhoneNumber [lastName=" + lastName + ", firstName=" + firstName + ", company=" + company
				+ ", PhoneBook=" + PhoneBook +  "]";
	}
	
	//메소드
	
}
