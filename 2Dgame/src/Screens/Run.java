package Screens;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Run {
	public static MainScreen a;
	public static Double scale;
public static void main(String [] args) throws IOException, InterruptedException{
	String input = (String) JOptionPane.showInputDialog(new JFrame(), "Choose a scale:", "Game Start", JOptionPane.PLAIN_MESSAGE,null,null,null);
	scale = Double.parseDouble(input);
 a = new MainScreen(scale);
}
}
