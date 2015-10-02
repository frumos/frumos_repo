package book.learn.powerOfJavaLambdas.designing.decorator;

import java.awt.Color;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Decorator pattern
 * 
 * @author frum
 *
 */
@SuppressWarnings("unchecked")
public class Camera1 {
	private Function<Color, Color> filter;
	
	public Camera1() {
		setFilters();
	}
	
	public Color capture(final Color inputColor) {
		final Color processedColor = filter.apply(inputColor);
		// ... more processing of color...
		return processedColor;
	}
	
	
	public void setFilters(final Function<Color, Color>...filters) {
		filter = Stream.of(filters)
			.reduce((filter, next) -> filter.compose(next))
			.orElse(color -> color);		
	}
		
	public static void main(String[] args) {
		Camera1 camera = new Camera1();
		
		Consumer<String> cons = (result) ->
			System.out.println(String.format("with %s: %s", result,
					camera.capture(new Color(200, 100, 200))));
			
		cons.accept("no filter");
		
	    camera.setFilters(Color::brighter);
	    cons.accept("brighter filter");

	    camera.setFilters(Color::darker);
	    cons.accept("darker filter");
	    
	    camera.setFilters(Color::brighter, Color::darker);
	    cons.accept("brighter, then darker filters");    
		
	}
}
