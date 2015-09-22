package book.learn.powerOfJavaLambdas.compare;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;



public class Collect {
	
	public static void main(String[] args) {
		
		final List<Person> people = Arrays.asList(
				new Person("John", 20),
				new Person("Sara", 21),
				new Person("Jane", 21),
				new Person("Greg", 35));
		
		
		System.out.println("-------------------------");
		System.out.println("Older then 20");
		
		
		/**
		 * There are 3 things to do to create own collector
		 * 
		 * 1. How to make a result container (for example, using the ArrayList::new method)
		   2. How to add a single element to a result container (for example, using the
              ArrayList::add method)
           3. How to merge one result container into another (for example, using the
           ArrayList::addAll method)
		 * 
		 */
		
		people.stream()
		.filter(person -> person.getAge() > 20)
		.collect(toList()).forEach(System.out::println);
		
		// This is bug in Ecipse and this bellow line shows error
//		.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		System.out.println("-------------------------");
		System.out.println("GroupBy by age and collect");
		
		Map<Integer, List<Person>> result = people.stream()
			.collect(groupingBy(p -> p.getAge()));
		
		System.out.println("Result of groupBy by age is: " + result);
		
		System.out.println("-------------------------");
		System.out.println("GroupBy by age and collect names only");
		
		Map<Integer, List<String>> resultNames = people.stream()
				.collect(groupingBy(p -> p.getAge(), mapping(p -> p.getName(), toList())));
		
		System.out.println("Result of groupBy by age and collectin names is: " + resultNames);
				
	}

}
