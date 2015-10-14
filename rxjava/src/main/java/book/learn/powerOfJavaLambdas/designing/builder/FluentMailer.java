package book.learn.powerOfJavaLambdas.designing.builder;

import java.util.function.Consumer;

/**
 * Chain builder pattern
 * @author frum
 *
 */
public class FluentMailer {
	
	private FluentMailer(){};
	
	public FluentMailer withFrom(String from) {
		// set from field
		return this;
	}
	
	public FluentMailer withTo(String to) {
		// set to field
		return this;
	}
	
	public FluentMailer withSubject(String subject) {
		// set subject field
		return this;
	}
	
	public FluentMailer withBody(String body) {
		// set body field
		return this;
	}
	
	public static void send(final Consumer<FluentMailer> block) {
		final FluentMailer fm = new FluentMailer();
		block.accept(fm);
		System.out.println("Building / sending ...");
	}
	
	public static void main(String[] args) {
		FluentMailer.send(builder ->
		 builder.withBody("Some body")
		 .withFrom("From Dima")
		 .withSubject("Important subject")
		 .withTo("To all"));
	}
	

}
