package book.learn.powerOfJavaLambdas.compare;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilesListing {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Listing files in the current dir");
			
		Files.list(Paths.get("."))
		.forEach(System.out::println);
		
		System.out.println("------------------------------");
		System.out.println("Listing dirs in the current dir");
		
		Files.list(Paths.get("."))
		.filter(Files::isDirectory)
		.forEach(System.out::println);
		
		
		System.out.println("------------------------------");
		System.out.println("Listing with filter old way");
		
		String[] list = new File("./src/main/java/book/learn/powerOfJavaLambdas/compare").list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		
		System.out.println(Arrays.toString(list));
		
		
		System.out.println("------------------------------");
		System.out.println("Listing with filter new lambda way");
		
		Files.newDirectoryStream(Paths.get("./src/main/java/book/learn/powerOfJavaLambdas/compare"), 
				p -> p.toString().endsWith(".java")).forEach(System.out::println);
		
		
		System.out.println("------------------------------");
		System.out.println("Listing with filter another way");
		
		System.out.println(Arrays.toString(new File(".").listFiles(File::isHidden)));
		
	}

}
