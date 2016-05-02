package Screens;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import Blocks.EnemyBounds;
import Blocks.WallBlock;
import Entities.Enemy;
import Entities.Player;
import gameelements.*;

public class Screen extends JPanel implements ActionListener {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	LinkedList<ImageIcon> images = new LinkedList<ImageIcon>();
	LinkedList<ImageIcon> images2 = new LinkedList<ImageIcon>();
	LinkedList<ImageIcon> images3 = new LinkedList<ImageIcon>();
	LinkedList<Integer> locationsx = new LinkedList<Integer>();
	LinkedList<Integer> locationsy = new LinkedList<Integer>();
	LinkedList<Integer> locationsx2 = new LinkedList<Integer>();
	LinkedList<Integer> locationsy2 = new LinkedList<Integer>();
	public boolean game = true;
	WallBlock temp = new WallBlock(60, 60, 60, 60, false, false, false, true,
			this);
	public int spritex = 0;

	public int spritey = 0; /* /Can't make not static/ */
	boolean jumping;
	public boolean upheld;
	public ArrayList<Boolean> lefttest = new ArrayList<Boolean>(); /*
																	 * /Can't
																	 * make not
																	 * static/
																	 */
	public ArrayList<Boolean> bottomtest = new ArrayList<Boolean>(); /*
																	 * /Can't
																	 * make not
																	 * static/
																	 */
	public ArrayList<Boolean> righttest = new ArrayList<Boolean>(); /*
																	 * /Can't
																	 * make not
																	 * static/
																	 */
	public ArrayList<Boolean> toptest = new ArrayList<Boolean>(); /*
																 * /Can't make
																 * not static/
																 */
	/*********************************************** FOREGROUND/ ***********************************************/
	public Timer t = new Timer(100, this);
	boolean jumped = false;
	int down;
	int up;
	int getindex = -1;
	int timetrack = 0;
	int getindex2 = -1;
	int enemyx = 0, enemyy = 0;
	public URL pipetopa = Screen.class.getResource("/resources/pipetop.gif");
	private ImageIcon pipetopb = new ImageIcon(pipetopa);

	public URL pipea = Screen.class.getResource("/resources/Pipe.gif");
	private ImageIcon pipeb = new ImageIcon(pipea);

	public URL qma = Screen.class.getResource("/resources/Question.gif");
	private ImageIcon qmb = new ImageIcon(qma);

	public URL grassa = Screen.class.getResource("/resources/grass.gif");
	private ImageIcon grassb = new ImageIcon(grassa);

	public int playerdirectionx = 0;/* /Can't make not static/ */
	public int playerdirectiony = 0;/* /Can't make not static/ */

	public int origy;
	public int curry = 960;

	public boolean jumptrue;
	public URL placeholdera = Screen.class
			.getResource("/resources/PlaceHolder.gif");
	public URL gphr = Screen.class.getResource("/resources/gphr.gif");
	public URL gphl = Screen.class.getResource("/resources/gphl.gif");
	private ImageIcon placeholderb = new ImageIcon(placeholdera);
	private ImageIcon removeplaceholder = new ImageIcon(placeholdera);

	private ImageIcon goombaplaceholderleft = new ImageIcon(gphl);
	private ImageIcon playerplaceholder = new ImageIcon(gphl);
	private ImageIcon goombaplaceholderright = new ImageIcon(gphr);
	private ImageIcon wallplaceholder = new ImageIcon(placeholdera);
	private ImageIcon enemywallplaceholder = new ImageIcon(placeholdera);
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public ArrayList<Player> players = new ArrayList<Player>(); /*
																 * /Can't make
																 * not static/
																 */
	public int enemydxl = 0, enemydxr = 0, enemydyr = 0, enemydyl = 1; /*
																		 * /Can't
																		 * make
																		 * not
																		 * static
																		 * /
																		 */
	ArrayList<WallBlock> walls = new ArrayList<WallBlock>(); 
		ArrayList<EnemyBounds> enemywalls = new ArrayList<EnemyBounds>(); 



	public int testing = 800;
	Random rand = new Random();
	int enemycount = 0;
	/*********************************************** Background/ ***********************************************/
	public URL skya = Screen.class.getResource("/resources/sky.gif");
	private ImageIcon skyb = new ImageIcon(skya);

	public int length = Map.LevelOneBackground[0].length - 1;
	public int width = Map.LevelOneBackground.length - 1;
	public int length2 = Map.LevelOne[0].length - 1;
	public int width2 = Map.LevelOne.length - 1;
	public int length3 = Map.LevelOneBlockPhysics[0].length - 1;
	public int width3 = Map.LevelOneBlockPhysics.length - 1;
	public int z = 0;
	public int x = 0;

	public Screen() throws IOException {
		t.start();
		addWalls();
		addBackgroundImage();
		addImage();
		repaint();
	}

	private void addBackgroundImage() {
		int image;
		try {
			for (int y = 0; y <= width; y++) {
				for (int x = 0; x <= Map.LevelOneBackground[0].length - 1; x++) {
					image = Map.LevelOneBackground[y][x];
					switch (image) {
					case 0:
						images.add(skyb);
						break;
					}

				}
			}
		} catch (NumberFormatException e) {
			System.out
					.println("Sorry you can't store a word in a column that contains only numbers.");
		}
	}

	private void addWalls() {
		int image3;
		for (int y3 = 0; y3 <= width3; y3++) {
			for (int x3 = 0; x3 <= Map.LevelOneBlockPhysics[0].length - 1; x3++) {
				image3 = Map.LevelOneBlockPhysics[y3][x3];
				switch (image3) {
				case 0:
					images3.add(placeholderb);
					break;
				case 1:
					images3.add(wallplaceholder);
					break;
				case 2:
					images3.add(enemywallplaceholder);
					break;
				}
			}
		}
	}
	
	private void addImage() {
		int image2;
		try {
			for (int y2 = 0; y2 <= width2; y2++) {
				for (int x2 = 0; x2 <= Map.LevelOne[0].length - 1; x2++) {
					image2 = Map.LevelOne[y2][x2];
					switch (image2) {
					case 0:
						images2.add(placeholderb);
						break;
					case 1:
						images2.add(pipetopb);
						break;
					case 2:
						images2.add(pipeb);
						break;
					case 3:
						images2.add(qmb);
						break;
					case 4:
						images2.add(grassb);
						break;
					case 5:
						images2.add(goombaplaceholderleft);
						break;
					case 6:
						images2.add(goombaplaceholderright);
						break;
					case 7:
						images2.add(playerplaceholder);
					default:
						break;

					}

				}
			}
		} catch (NumberFormatException e) {
			System.out
					.println("Sorry you can't store a word in a column that contains only numbers.");
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		BufferedImage content = new BufferedImage(MainScreen.actual.height, MainScreen.actual.width,
//				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(Run.scale, Run.scale);
//		Graphics2D g2d = content.createGraphics();
		int sudox = 0;
		int x = 0;
		int y = 0;
		int sudox2 = 0;
		int sudox3 = 0;
		int x2 = 0;
		int y2 = 0;
		int x3 = 0;
		int y3 = 0;
		int lengthl = length + 1;
		int length3 = length2 + 1;
		for (ImageIcon img : images) {
			g.drawImage(img.getImage(), spritex + x, spritey + y, 60, 60, null);
			x += 60;
			sudox += 60;
			if (sudox % (lengthl * 60) == 0) {
				x = 0;
				y += 60;
			}
		}
		for (int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.draw(g2d);
		}
		for (int i = 0; i < players.size(); i++) {
			Player tempPlayer = players.get(i);
			tempPlayer.draw(g2d);
		}
		for (int i = 0; i < walls.size(); i++) {
			WallBlock tempwall = walls.get(i);
			tempwall.draw(g2d);
		}
		for (int i = 0; i < enemywalls.size(); i++) {
			EnemyBounds tempwall = enemywalls.get(i);
			tempwall.draw(g2d);
		}
		for (ImageIcon img2 : images2) {
			g.drawImage(img2.getImage(), spritex + x2, spritey + y2, 60, 60,
					null);
			getindex++;
			if (img2 == goombaplaceholderleft) {
				images2.set(getindex, removeplaceholder);
				locationsx.add(spritex + x2);
				locationsy.add(spritey + y2);
				addEnemy(new Enemy(locationsx.getLast(), locationsy.getLast(),
						60, 60, "goomba", "left", true, this));

			}
			if (img2 == goombaplaceholderright) {
				images2.set(getindex, removeplaceholder);
				locationsx.add(spritex + x2);
				locationsy.add(spritey + y2);
				addEnemy(new Enemy(locationsx.getLast(), locationsy.getLast(),
						60, 60, "goomba", "right", true, this));

			}
			if (img2 == playerplaceholder) {
				images2.set(getindex, removeplaceholder);
				locationsx.add(spritex + x2);
				locationsy.add(spritey + y2);
				addPlayer(new Player(locationsx.getLast(),
						locationsy.getLast(), 60, 60, this));
				origy = players.get(0).getY();
			}
			x2 += 60;
			sudox2 += 60;
			if (sudox2 % (length3 * 60) == 0) {
				x2 = 0;
				y2 += 60;
			}
		}
		for (int i = 0; i < Map.LevelOne.length; i++) {
			g.drawImage(grassb.getImage(), spritex - 60, spritey + 60 * i, 60,
					60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 2, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 3, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 4, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 5, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 6, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 7, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 8, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 9, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 10, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 11, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 12, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 13, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 14, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 15, spritey + 60 * i,
					60, 60, null);
			g.drawImage(grassb.getImage(), spritex - 60 * 16, spritey + 60 * i,
					60, 60, null);

		}

		for (ImageIcon img3 : images3) {
			g.drawImage(img3.getImage(), spritex + x3, spritey + y3, 60, 60,
					null);
			getindex2++;
			if (img3.equals(wallplaceholder)) {
				images3.set(getindex2, removeplaceholder);
				locationsx2.add(spritex + x3);
				locationsy2.add(spritey + y3);

				addWall(new WallBlock(locationsx2.getLast(),
						locationsy2.getLast(), 60, 60, false, false, false,
						false, this));
			}
			if (img3.equals(enemywallplaceholder)) {
				images3.set(getindex2, removeplaceholder);
				locationsx2.add(spritex + x3);
				locationsy2.add(spritey + y3);

				addEnemyWall(new EnemyBounds(locationsx2.getLast(),
						locationsy2.getLast(), 60, 60,this));
			}
			x3 += 60;
			sudox3 += 60;
			if (sudox3 % (length3 * 60) == 0) {
				x3 = 0;
				y3 += 60;
			}
			
		}
	}

	public void keys() {
		for (int i = 0; i < players.size(); i++) {

			if (lefttest.isEmpty() == false) {
				if (KeyInput.right == true && lefttest.contains(true) == false) {
					spritex -= 10;
					playerdirectiony = 0;
					playerdirectionx++;
					if (playerdirectionx == 2)
						playerdirectionx = 0;
				}
			}
			if (righttest.isEmpty() == false) {
				if (KeyInput.left == true && righttest.contains(true) == false) {
					spritex += 10;
					playerdirectiony = 1;
					playerdirectionx++;
					if (playerdirectionx == 2)
						playerdirectionx = 0;
				}
			}
			for (int z = 0; z < walls.size(); z++) {
				if (KeyInput.up == true && upheld == false
						&& walls.get(z).getT() == false && jumped == false
						&& players.get(0).getYD() == 0 && up == -10&&players.get(0).getY() != -40&& toptest.contains(true) == false) {
					upheld = true;
					jumped = true;
				}
			}
		}
		if (KeyInput.down == true) {

		}
		if (KeyInput.up == false) {
			upheld = false;
		}
		if (KeyInput.down == false) {
		}
	}

	public void actionPerformed(ActionEvent e) {
		keys();
		if (jumped == true) {
			if (players.isEmpty() == false)
				if (toptest.contains(true) == false)
					players.get(0).setYD(-20);
		}

		for (WallBlock w : walls) {
			w.move();
		}
		for (EnemyBounds w : enemywalls) {
			w.move();
		}
		for (int i = 0; i < enemies.size(); i++) {
			if (timetrack < 3)
				timetrack++;
			if (timetrack == 3) {
				if (enemies.get(i).getdirection() == "right") {
					if (enemydxr == 0)
						enemydxr++;
					else if (enemydxr == 1)
						enemydxr--;
				}
				if (enemies.get(i).getdirection() == "left") {

					if (enemydxl == 1)
						enemydxl--;
					else if (enemydxl == 0)
						enemydxl++;
				}
				timetrack = 0;
			}
			enemies.get(i).move();

		}
		for (int i = 0; i < players.size(); i++) {
			try {
				players.get(i).move();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		repaint();
		if (players.isEmpty() == false) {
			

			for (int i = 0; i < players.size(); i++) {
				curry = players.get(i).getY();
			}
			for (int x = 0; x < walls.size(); x++) {
				if (up>=156) {
					jumped = false;
				}
				if(up>=75)
					up++;
				if (walls.get(x).getB() == true) {
					temp = walls.get(x);
				}
				if (temp.getB()==true&&jumped==false) {
					players.get(0).setYD(0);
					origy = players.get(0).getY();
					up = -10;
					
				} else if (temp.getB()==false && up > 0) {
					players.get(0).setYD(20);
					temp.setB(false);
					up++;
				} else if (temp.getB() == false) {
					players.get(0).setYD(20);
					up++;
				}
				
			}
		}
	}

	public void addEnemy(Enemy e) {
		enemies.add(e);
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void addWall(WallBlock e) {
		walls.add(e);
		lefttest.add(null);
		righttest.add(null);
		toptest.add(null);
		bottomtest.add(null);
	}
	public void addEnemyWall(EnemyBounds e) {
		enemywalls.add(e);
	}

	public ArrayList<Enemy> getEnemyList() {
		return enemies;
	}

	public ArrayList<WallBlock> getWallList() {
		return walls;
	}
	public ArrayList<EnemyBounds> getEnemyWallList() {
		return enemywalls;
	}
	public ArrayList<Boolean> getLeftTest() {
		return lefttest;
	}

	public ArrayList<Boolean> getBottomTest() {
		return bottomtest;
	}

	public ArrayList<Boolean> getRightTest() {
		return righttest;
	}

	public ArrayList<Boolean> getTopTest() {
		return toptest;
	}

	public ArrayList<Player> getPlayerList() {
		return players;
	}

	public void removeEnemy(Enemy e) {
		enemies.remove(e);
	}

	public void removePlayer(Player p) {
		players.remove(p);
	}
}
