package vooban.challenge2.parentheses.util;

import javax.swing.JOptionPane;

import vooban.challenge2.parentheses.ParenthesesOutputInterface;

public class AlertWindowOutput implements ParenthesesOutputInterface {

	@Override
	public void PrintOutput(String finalOutput) {
		
		JOptionPane.showMessageDialog(null, finalOutput);

	}

}
