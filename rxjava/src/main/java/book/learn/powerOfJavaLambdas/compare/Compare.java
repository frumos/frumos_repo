package book.learn.powerOfJavaLambdas.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Compare {
	
	
	public static void main(String[] args) {
		
		final List<Person> people = Arrays.asList(
				new Person("John", 20),
				new Person("Sara", 21),
				new Person("Jane", 21),
				new Person("Greg", 35));
		
		System.out.println("Sorting people by age in ASC");
		
		System.out.println("Sorted in ascending order of age: \n" + 
		people.stream()
			.sorted((p1, p2) -> p1.ageDifference(p2))
			.map(Person::toString)
			.collect(Collectors.joining("\n")));
		
		System.out.println("------------------------------------------");
		System.out.println("Sorting people by age in ASC with method-reference!");		
		
		System.out.println("Sorted in ascending order of age: \n" + 
		people.stream()
			.sorted(Person::ageDifference)
			.map(Person::toString)
			.collect(Collectors.joining("\n")));
		
		
		System.out.println("--------------------------------------------------------");
		System.out.println("Sorting people by age in DESC by swapping args in lambda");
		
		System.out.println("Sorted in ascending order of age: \n" + 
		people.stream()
			.sorted((p1, p2) -> p2.ageDifference(p1))
			.map(Person::toString)
			.collect(Collectors.joining("\n")));
		
		System.out.println("-------------------------");
		System.out.println("Reusing comparators");
		
		Comparator<Person> ageAsc = (p1, p2) -> p1.ageDifference(p2);
		Comparator<Person> ageDesc = ageAsc.reversed();
		
		System.out.println(
				people.stream()
					.sorted(ageAsc)
					.map(p -> p.toString())
					.collect(Collectors.joining(", "))
				);
		
		System.out.println(
				people.stream()
					.sorted(ageDesc)
					.map(p -> p.toString())
					.collect(Collectors.joining(", "))
				);
		
		System.out.println("--------------------");
		System.out.println("Youngest/oldes with comparator");
		
		people.stream()
			.min(Person::ageDifference)
			.ifPresent(result -> System.out.println("Youngest: " + result));
		
		people.stream()
			.max(Person::ageDifference)
			.ifPresent(result -> System.out.println("Oldest: " + result));
	
		
		System.out.println("--------------------");
		System.out.println("Multiple comparision");
		
		Function<Person, Integer> byAge = p -> p.getAge();
		Function<Person, String> byName = p -> p.getName();
		
		System.out.println("Multiple comparision by Age and then by Name\n" +
			people.stream()
				.sorted(Comparator.comparing(byAge)
					.thenComparing(byName))
				.map(p -> p.toString())
				.collect(Collectors.joining(", ")));
			
	}
	

}
