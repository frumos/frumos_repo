package book.learn.powerOfJavaLambdas.collections;

import static book.learn.powerOfJavaLambdas.collections.Folks.*;

import java.util.stream.Collectors;

public class PickALongest {
	
	public static void main(String[] args) {
				
		System.out.println("Total # of letters " + 
		friends.stream()
			.mapToInt(e -> e.length())
			.sum());

		
		System.out.println("----------------------------------------------");
		System.out.println("Using reduce method with BinaryOperation param");
		
		/**
		 * As the reduce() method iterated through the collection, it called the lambda
		expression first, with the first two elements in the list. The result from the lambda
		expression is used for the subsequent call. In the second call name1 is bound to
		the result from the previous call to the lambda expression, and name2 is bound
		to the third element in the collection. The calls to the lambda expression continue
		for the rest of the elements in the collection.
		 */
		
		
		friends.stream()
		.reduce((name1, name2) 
				-> name1.length() >= name2.length() ? name1 : name2)
				.ifPresent(name -> System.out.println("The longest name: " + name));
	
	
		System.out.println("------------------------------");
		System.out.println("Collecting and joining element");
		
		System.out.println(friends.stream()
			.map(String::toUpperCase)
			.collect(Collectors.joining(", ")));
	
	
	}
	

}
