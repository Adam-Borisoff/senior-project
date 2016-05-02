package Blocks;

import java.awt.Graphics;

public abstract class Block {
protected int x, y, w, h;
protected boolean removed=false;

public Block(int x, int y, int w, int h){
this.x=x;
this.y=y;
this.w=w;
this.h=h;
}
public void draw(Graphics g){
	
}
public int getX(){return x;}
public int getY(){return y;}
public int getW(){return w;}
public int getH(){return h;}
}
