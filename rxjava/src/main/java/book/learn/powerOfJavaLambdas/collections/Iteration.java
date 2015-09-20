package book.learn.powerOfJavaLambdas.collections;

import static book.learn.powerOfJavaLambdas.collections.Folks.*;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Iteration {
	
	
	public static Predicate<String> startWithLetter(String letter) {
		return name -> name.startsWith(letter);
	}

	public static void main(String[] args) {		
		friends.forEach(System.out::println);
		
		friends.stream()
		.map(String::toUpperCase)
		.forEach(System.out::println);
		
		System.out.println("-------------------------");
		System.out.println("Itereting over collection");		
		
		System.out.println("Found: " +
				friends.stream()
		.filter(e -> e.startsWith("N"))
		.collect(Collectors.toList())
		.size() + " elements start with N");
		
		System.out.println("-------------------------------------");
		System.out.println("Reusing predicate with constant value");
		
		Predicate<String> startWithN = name -> name.startsWith("N");
		
		System.out.println(friends.stream()
			.filter(startWithN)
			.count());
		
		System.out.println(comrades.stream()
			.filter(startWithN)
			.count());
		
		System.out.println(editors.stream()
			.filter(startWithN)
			.count());
		
		System.out.println("---------------------------------");
		System.out.println("Reusing predicate with parameter");
		
		System.out.println(friends.stream()
				.filter(startWithLetter("N"))
				.count());
		
		System.out.println(friends.stream()
				.filter(startWithLetter("S"))
				.count());
		
		
		System.out.println("-----------------------------------");
		System.out.println("Defining clouser to reuse predicate");
		
		Function<String, Predicate<String>> startWithLetter = 
			input -> name -> name.startsWith(input);		
		 
		System.out.println(friends.stream()
				.filter(startWithLetter.apply("S"))
				.count());
		
		System.out.println(friends.stream()
				.filter(startWithLetter.apply("N"))
				.count());
		
		
		System.out.println("-------------------------------------------");
		System.out.println("Finding first occurance accordign condition");
		
		
		System.out.println("With ifPrecent expr");
		String let = "S";
		
		friends.stream()
				.filter(startWithLetter.apply(let))
				.findFirst()
				.ifPresent(name -> System.out.println(let + " was found in the " + name));
				
		System.out.println("With orElese expr");
		String let_1 = "A";
		
		Optional<String> findName_1 = friends.stream()
				.filter(startWithLetter.apply(let_1))
				.findFirst();
		
		System.out.println(String.format("A name with "
				+ "letter %s %s", let_1, findName_1.orElse("No name found")));
				
		
	}
	
	
}
