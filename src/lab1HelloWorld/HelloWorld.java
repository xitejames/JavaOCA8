package lab1HelloWorld;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println(Name());
		System.out.println("---------------------------------------");
		for(String test : args) {
			System.out.println(test);
		}
		System.out.println("---------------------------------------");
	}

	static String Name() {
		return "MY NAMES JEFF";
	}
	
}

 