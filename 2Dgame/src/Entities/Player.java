package Entities;

import gameelements.ImageSheet;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import Screens.MainScreen;
import Screens.Run;
import Screens.Screen;

public class Player extends Entity
{
	public static ImageSheet test = new ImageSheet("pikachu.gif");
	private int xD, yD;
	private Screen screen;
	
	public Player(int x, int y, int w, int h, Screen s){
		super(x, y, w, h);	
		screen=s;
		
	}
	
	public void draw(Graphics2D g)
	{
	//	g.draw(getBoundsHead());
//	g.draw(getBounds());
		g.draw(getBoundsFeet()); 
		
	g.drawImage(test.grabImage(screen.playerdirectionx,screen.playerdirectiony), x, y, w,h, null);
	
	}
	public void move() throws IOException, InterruptedException{
		x+=xD;
		y+=yD;
		checkCollisions();
	}
	public void setXD(int value){
		xD=value;
	}
	public void setYD(int value){
		yD=value;
	}
	public int getYD(){
		return yD;
	}
	public Rectangle getBoundsDeath(){
		return new Rectangle(x+20, y+25, w-59,h-48);
	}
	public Rectangle getBounds(){
		return new Rectangle(x+15, y, w-35,h);
	}
	public Rectangle getBoundsKill(){
		return new Rectangle(x+20, y+35, w-48,h-48);
	}
	public Rectangle getBoundsFeet(){
		return new Rectangle(x+15, y+59, w-35,h-51);
	}
	
	public Rectangle getBoundsHead(){
		return new Rectangle(x+20, y-1, w-48,h-48);
	}
	public void checkCollisions() throws IOException, InterruptedException{
		
		ArrayList<Enemy> enemies =screen.getEnemyList();
		for(int i =0; i<enemies.size(); i++){
			for(int x =0; x<screen.players.size(); x++){
			Enemy tempenemy = enemies.get(i);
			Player tempplayer=screen.players.get(x);
			if(getBoundsKill().intersects(tempenemy.getBounds())&&getBoundsDeath().intersects(tempenemy.getBounds())==false){
			screen.removeEnemy(tempenemy);
			}
			if(getBoundsDeath().intersects(tempenemy.getBounds())){
				screen.removePlayer(tempplayer);
				Run.a.remove(screen);
				Run.a.add(new Screen());
				
			}
			}
		}
	}


}