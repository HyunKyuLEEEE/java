package day19;

import lombok.Data;

/* 도서 관리 프로그램을 작성하세요.
 * 도서 정보 
 * - 도서명, 저자(여러명, 엮은이, 옮긴이 다 포함), 가격, 출판사, 분류, ISBN
 * 기능
 * - 도서 추가
 * 	- ISBN으로 정렬
 * - 도서 조회
 * 	- 도서 명으로 조회
 * 	- 저자로 조회
 * 	- 출판사로 조회
 *  - 분류로 조회
 * 
 * */

@Data
public class Book {
	private String bookName, writter, publisher, type;
	private int price, ISBN, num;
	
	public Book(String bookName, String writter, String publisher, String type, int price) {
		this.bookName = bookName;
		this.writter = writter;
		this.publisher = publisher;
		this.type = type;
		this.price = price;
		++ISBN;
		num = ISBN;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ISBN != other.ISBN)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (num != other.num)
			return false;
		if (price != other.price)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (writter == null) {
			if (other.writter != null)
				return false;
		} else if (!writter.equals(other.writter))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + num;
		result = prime * result + price;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((writter == null) ? 0 : writter.hashCode());
		return result;
	}
	

	@Override
	public String toString() {
		return bookName + " | " + writter + " | " + publisher + " | " + type
				+ " | " + price + " | " + ISBN;
	}
	
	public String print() {
		return "==================\n"
				+ "도서 명 : " + bookName + "\n"
				+ "저자 : " + writter + "\n"
				+ "출판사 : " + publisher + "\n"
				+ "분류 : " + type + "\n"
				+ "가격 : " + price + "\n"
				+ "ISBN : " + ISBN + "\n"
				+ "==================\n";
	}
	
	public Book(String bookName) {
		this.bookName = bookName;
	}
}
