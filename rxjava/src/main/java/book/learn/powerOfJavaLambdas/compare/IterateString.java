package book.learn.powerOfJavaLambdas.compare;

public class IterateString {
	

	private static void printChar(int ch) {
		System.out.println((char)ch);
	}
	
	
	public static void main(String[] args) {
		final String str = "w00t";
		
		System.out.println("Simple iteration over chars of String");
		str.chars().forEach(System.out::println);
		
		System.out.println("--------------------------------------------");
		System.out.println("Iteration over chars of String with static method reference");
		str.chars().forEach(IterateString::printChar);
		
		System.out.println("--------------------------------------------");
		System.out.println("Iteration over chars and convering ints -> chars");
		
		str.chars()
			.mapToObj(ch -> (char)ch)
			.forEach(System.out::println);

		System.out.println("--------------------------------------------");
		System.out.println("Iteration filter out digits only");
		
		str.chars()
			.filter(Character::isDigit)
			.forEach(IterateString::printChar);
		
	}

}
