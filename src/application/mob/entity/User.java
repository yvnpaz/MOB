package application.mob.entity;

public class User {

	private int number;
	
	public User(int number) {
		this.number = number;
	}

	public User() {
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "User [number=" + number + "]";
	}
	
}
