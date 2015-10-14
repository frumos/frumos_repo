package book.learn.powerOfJavaLambdas.resources;

@FunctionalInterface
public interface UseInstanse<T, X extends Exception> {
	void accept(T instance) throws X;
}
