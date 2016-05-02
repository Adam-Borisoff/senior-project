package Screens;

import gameelements.KeyInput;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	public static KeyInput k = new KeyInput();
	public static Screen screen;
	static Dimension dim = new Dimension(1920, 1080);

	public MainScreen(Double scale) throws IOException, InterruptedException {

		
		screen = new Screen();
		add(screen);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize((int)(dim.width*scale),(int)(dim.height*scale));
		System.out.println(dim.width + " ");
		setResizable(false);
		setVisible(true);
		addKeyListener(k);
		setFocusable(true);
	}
	
}
