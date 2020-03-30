package carPackage;

public class Car {
	private String color;
	private String type;
	
	public Car(String carColor, String carType) {
		this.color = carColor;
		this.type = carType;
	}
	
	public void consoleLogCarData() {
		System.out.println("The car is a: " + color + " " + type );
	}

	public String getColor() {
		return color;
	}

	public void setColor(final String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}
	
	
}
