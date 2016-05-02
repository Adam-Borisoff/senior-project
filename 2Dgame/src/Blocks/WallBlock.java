package Blocks;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Entities.Enemy;
import Entities.Player;
import Screens.Screen;

public class WallBlock extends Block{
	public URL placeholdera=Screen.class.getResource("/resources/PlaceHolder.gif");
	private ImageIcon placeholderb=new ImageIcon(placeholdera);
public  int wallnumber=9999;
protected boolean t, b;

private Screen screen;

public WallBlock(int x, int y, int w, int h, boolean r, boolean l, boolean t, boolean b, Screen s){
	super(x, y, w, h);
	this.t=t;
	this.b=b;
	screen = s;
}
public void move(){
	checkCollisions();
}
public Rectangle getBounds(){
	return new Rectangle(x+screen.spritex, y+screen.spritey, 60, 60);
	
}
public Rectangle getRightBounds(){
	return new Rectangle(x+59+screen.spritex, y+screen.spritey, 1, 60);
}
public Rectangle getLeftBounds(){
	return new Rectangle(x-1+screen.spritex, y+screen.spritey, 1, 60);
}
public Rectangle getTopBounds(){
	return new Rectangle(x+screen.spritex, y+59+screen.spritey, 60, 20);
}
public Rectangle getBottomBounds(){
	return new Rectangle(x+screen.spritex, y-13+screen.spritey, 60, 13);
}
public boolean getB(){
	return b;
}
public boolean getT(){
	return t;
}
public void setB(Boolean x){
	b=x;
}
public void setT(Boolean x){
	t=x;
}
public void draw(Graphics2D g)
{
	
//	g.draw(getTopBounds());
	//g.draw(getLeftBounds());
	//g.draw(getRightBounds());
	//g.draw(getBottomBounds());
	
g.drawImage(placeholderb.getImage(), x+screen.spritex, y+screen.spritey, w,h, null);
}

public void checkCollisions(){
	ArrayList<Enemy> enemies =screen.getEnemyList();
	ArrayList<Player> players =screen.getPlayerList();
	ArrayList<WallBlock>walls =screen.getWallList();
	ArrayList<Boolean> lefttest=screen.getLeftTest();
	ArrayList<Boolean> righttest=screen.getRightTest();
	ArrayList<Boolean> toptest = screen.getTopTest();
	ArrayList<Boolean> bottomtest = screen.getBottomTest();
	for(int i =0; i<enemies.size(); i++){
		Enemy tempenemy = enemies.get(i);
		if(getBounds().intersects(tempenemy.getBounds())){
			if(tempenemy.getXD()==-10){
			tempenemy.setDirection("right");
			
			}
			if(tempenemy.getXD()==10){
				tempenemy.setDirection("left");
			}
		}
	}
	
	for(int i =0; i<players.size();i++){
		for(int x =0; x<walls.size();x++){
		Player tempplayer = players.get(i);
		if(walls.get(x).getLeftBounds().intersects(tempplayer.getBounds())){
			lefttest.set(x, true);
		}
		if(walls.get(x).getRightBounds().intersects(tempplayer.getBounds())==true){
		righttest.set(x, true);
		}
		if(walls.get(x).getLeftBounds().intersects(tempplayer.getBounds())==false){
			lefttest.set(x, false);
		}
		if(walls.get(x).getRightBounds().intersects(tempplayer.getBounds())==false){
			righttest.set(x, false);
		}
		if(walls.get(x).getTopBounds().intersects(tempplayer.getBoundsHead())==true){
			walls.get(x).t=true;
			toptest.set(x, true);
		}
		if(walls.get(x).getTopBounds().intersects(tempplayer.getBoundsHead())==false){
			walls.get(x).t=false;
			toptest.set(x, false);
		}
		if(walls.get(x).getBottomBounds().intersects(tempplayer.getBoundsFeet())==true){
			walls.get(x).b=true;
			bottomtest.set(x, true);
		}
		if(walls.get(x).getBottomBounds().intersects(tempplayer.getBoundsFeet())==false){
			walls.get(x).b=false;
			bottomtest.set(x, false);
		}
	}
}
}

}
