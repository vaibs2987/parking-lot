package parking.lot.entity;

public class Car {
	private String registrationNo;
	private String color;

	public Car(String regNo, String color) {
		this.registrationNo = regNo;
		this.color = color;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public String getColor() {
		return color;
	}
}
