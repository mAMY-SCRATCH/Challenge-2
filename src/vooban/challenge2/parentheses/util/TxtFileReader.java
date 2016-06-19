package vooban.challenge2.parentheses.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import vooban.challenge2.parentheses.ParenthesesInputInterface;

public class TxtFileReader implements ParenthesesInputInterface{
	
	private final String txtFileName = "res/parentheses.txt";
	
	@Override
	public String ExtractParentheses(){
		
		StringBuilder parenthesesBuilder = new StringBuilder(64);
		
		Path file = Paths.get(txtFileName);
		
		try {
			for (String line : Files.readAllLines(file)) {
				parenthesesBuilder.append(line);
			}
		} catch (IOException e) {
			System.out.println("Could not read "+txtFileName+" file.");
		}
		
		return parenthesesBuilder.toString();
		
	}

}
