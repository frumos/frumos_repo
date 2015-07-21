package book.lean.rxjava.chapter08;

import java.nio.file.Path;
import java.nio.file.Paths;

import rx.Observable;
import rx.Observable.Transformer;

import book.lean.rxjava.chapter08.Lift.Indexed;
import book.lean.rxjava.common.CreateObservable;
import book.lean.rxjava.common.Helpers;
import book.lean.rxjava.common.Program;

/**
 * Example of implementing a {@link Transformer} and passing it to {@link Observable#compose}.
 * 
 * @author meddle
 */
public class Compose implements Program {
	
	public static class OddFilter<T> implements Transformer<T, T> {

		@Override
		public Observable<T> call(Observable<T> observable) {
			return observable
					.lift(new Indexed<T>(1L))
					.filter(pair -> pair.getLeft() % 2 == 1)
					.map(pair -> pair.getRight());
		}
		
	}

	@Override
	public String name() {
		return "Demonstration of the Observable.compose operator";
	}

	@Override
	public int chapter() {
		return 8;
	}

	@Override
	public void run() {
		Path path = Paths.get("src", "main", "resources", "letters.txt");
		Observable<?> indexedStrings = CreateObservable
				.fromViaUsing(path).compose(new OddFilter<String>());
		
		Helpers.subscribePrint(indexedStrings, "Indexed strings");
	}
	
	public static void main(String[] args) {
		new Compose().run();
	}

}
