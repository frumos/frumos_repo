package book.learn.powerOfJavaLambdas.resources;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Automatic resource closing
 * 
 * @author frum
 *
 */
public class FileWriterEAM {
	
	private final FileWriter writer;
	
	private FileWriterEAM(String fileName) throws IOException {
		writer = new FileWriter(fileName);
		
	}
	
	private void close() throws IOException {
		System.out.println("Closing automatically ...");
		writer.close();		
	}
	
	public void writeStuff(String line) throws IOException {
		writer.write(line);		
	}
	
	
	public static void use(String fileName, UseInstanse<FileWriterEAM, IOException> block) throws IOException {
		final FileWriterEAM eam = new FileWriterEAM(fileName);
		try {
			block.accept(eam);
		} finally {
			eam.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("//" + "Start EAM_USE_OUTPUT");
		FileWriterEAM.use("file1.txt", writerEAM ->
				writerEAM.writeStuff("Hello"));
		
		System.out.println("//" + "End EAM_USE_OUTPUT");
		
		FileWriterEAM.use("file2.txt", writerEAM -> {
			writerEAM.writeStuff("Hello");
			writerEAM.writeStuff("Again");
		});		
	}

}
