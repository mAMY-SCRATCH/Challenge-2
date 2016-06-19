package vooban.challenge2.main;

import vooban.challenge2.parentheses.ParenthesesInputInterface;
import vooban.challenge2.parentheses.ParenthesesOutputInterface;
import vooban.challenge2.parentheses.util.AlertWindowOutput;
import vooban.challenge2.parentheses.util.ConsoleOutput;
import vooban.challenge2.parentheses.util.TxtFileReader;


public class ParenthesesCounter {
	
	private static boolean firstTimeNegative = false;
	private static int parenthesesValidatorCounter = 0;
	private static StringBuilder output = new StringBuilder();
	public static String newline = System.getProperty("line.separator");
	
	public static void main(String... args)
	{
		ParenthesesInputInterface parenthesesExtraction = new TxtFileReader();
		ParenthesesOutputInterface parenthesesOutput = new AlertWindowOutput();
		
		String parentheses = parenthesesExtraction.ExtractParentheses();
		
		for (int i = 0; i < parentheses.length(); i++) {
			if(parentheses.charAt(i) =='(') {parenthesesValidatorCounter++;}
			
			else if(parentheses.charAt(i) ==')'){
				parenthesesValidatorCounter--;
				FirstTimeNegativeValue(i);
			}
		}
		FinalResult();
		parenthesesOutput.PrintOutput(output.toString());
	}
	private static void FirstTimeNegativeValue(int position){
		if(parenthesesValidatorCounter < 0 && !firstTimeNegative){
			output.append("First time there is more closing parentheses then opening one at position : " + Integer.toString(position) + newline);
			firstTimeNegative = true;
		}
	}
	private static void FinalResult(){
		if(parenthesesValidatorCounter == 0){
			output.append("Everything is fine in these parentheses.");
		}
		else if(parenthesesValidatorCounter > 0){
			output.append("Too much opening parentheses.");
		}
		else{
			output.append("Too much closing parentheses.");
		}
	}
}
