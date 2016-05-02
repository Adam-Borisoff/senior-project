package gameelements;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import Screens.MainScreen;
import Screens.Run;
public class KeyInput implements KeyListener
	{
	

	
	public static boolean left;
	public static boolean right;
	public static boolean up;
	public static boolean down;
	public static boolean enter;
	
	public void keyPressed(KeyEvent e) 
		{
			int key = e.getKeyCode();
				if((key == KeyEvent.VK_ESCAPE))
				{
				
				System.exit(0);
				
				}
				if((key==KeyEvent.VK_RIGHT)){
					right=true;
				}
				if((key==KeyEvent.VK_LEFT)){
					left=true;
				}
				if((key==KeyEvent.VK_UP)){
					up=true;
					
				}
				if((key==KeyEvent.VK_DOWN)){
					down=true;
				}
				if((key==KeyEvent.VK_ENTER)){
					enter=true;
				}
				
			}
		
		public void keyReleased(KeyEvent e) {
			int key=e.getKeyCode();
		if((key==KeyEvent.VK_RIGHT)){
			right=false;
		}
		if((key==KeyEvent.VK_LEFT)){
			left=false;
		}
		if((key==KeyEvent.VK_UP)){
			up=false;
		}
		if((key==KeyEvent.VK_DOWN)){
			down=false;
		}
		if((key==KeyEvent.VK_ENTER)){
			enter=false;
		}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		}