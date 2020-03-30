package carPackage;

public class CarMain {
	public static void main(String[] args) {
		Car car1 = new Car("Red", "volvo");
		car1.consoleLogCarData();
		Car car2 = new Car("Grey", "BMW");
		car2.consoleLogCarData();
	}
}
