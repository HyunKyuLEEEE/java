package day27;

import lombok.Data;

@Data
public class User {
	private String id, pw, name, residentNumber;
	private int age;
	
	public User(String id, String pw, String name, String residentNumber, int age) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.residentNumber = residentNumber;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
}
