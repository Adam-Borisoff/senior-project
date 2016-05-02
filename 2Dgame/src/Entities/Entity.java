package Entities;

import java.awt.Graphics;

public  abstract class Entity 
{
	protected int x, y, w, h;
	protected boolean removed=false;
	
	public Entity(int x, int y, int w, int h){
		this.x=x;
		this.y=y;
		this.h=h;
		this.w=w;
	}
	public void draw(Graphics g){
		
	}
	public int getX(){return x;}
	public int getY(){return y;}
	public int getW(){return w;}
	public int getH(){return h;}
}