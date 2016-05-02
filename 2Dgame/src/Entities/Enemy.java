package Entities;

import gameelements.ImageSheet;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Screens.Screen;

public class Enemy extends Entity{
	public static ImageSheet test = new ImageSheet("teamrocket.gif");
	private int xD, yD;
	private Screen screen;
	private boolean exists;
	private String type, direction;
	public Enemy(int x, int y, int w, int h, String t, String d, boolean e, Screen s){
	super(x, y, w, h);
	exists=e;
	type=t;
	direction=d;
	screen=s;
	}
	public void draw(Graphics2D g)
	{
		
			if(this.direction=="left")
	g.drawImage(test.grabImage(screen.enemydxl,screen.enemydyl), x+screen.spritex, y+screen.spritey, w, h, null);

			if(this.direction=="right")
	g.drawImage(test.grabImage(screen.enemydxr,screen.enemydyr), x+screen.spritex, y+screen.spritey, w, h, null);

		}
	
	public void move(){
		
		AI();
		x+=xD;
		y+=yD;
		
	}

	public void setXD(int value){
		xD=value;
	}
	public int getXD(){
		return xD;
	}
	public void setYD(int value){
		yD=value;
	}
	public void setDirection(String value){
		direction=value;
	}
	public boolean getexists(){
		return exists;
	}
	
	public String getdirection(){
		return direction;
	}
	public Rectangle getBounds(){
		return new Rectangle(x+screen.spritex, y+screen.spritey, w,h);
	}
	public void AI(){
		if(type.equals("goomba")&&direction=="left"){
			setXD(-10);
		}
		if(type.equals("goomba")&&direction=="right"){
			setXD(10);
		}
		
	}
}
