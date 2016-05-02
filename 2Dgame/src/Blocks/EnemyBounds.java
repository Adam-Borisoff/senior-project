package Blocks;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Entities.Enemy;
import Entities.Player;
import Screens.Screen;

public class EnemyBounds extends Block{
	public URL placeholdera=Screen.class.getResource("/resources/PlaceHolder.gif");
	private ImageIcon placeholderb=new ImageIcon(placeholdera);
public  int wallnumber=9999;
protected boolean t, b;

private Screen screen;

public EnemyBounds(int x, int y, int w, int h,Screen s){
	super(x, y, w, h);
	screen = s;
}
public void move(){
	checkCollisions();
}
public Rectangle getBounds(){
	return new Rectangle(x+screen.spritex, y+screen.spritey, 60, 60);
	
}
public void draw(Graphics2D g)
{
	g.draw(getBounds());
g.drawImage(placeholderb.getImage(), x+screen.spritex, y+screen.spritey, w,h, null);
}

public void checkCollisions(){
	ArrayList<Enemy> enemies =screen.getEnemyList();
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
}

}
