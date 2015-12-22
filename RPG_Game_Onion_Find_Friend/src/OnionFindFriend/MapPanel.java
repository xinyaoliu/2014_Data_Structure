package OnionFindFriend;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author XinyaoLIU QiuyingXIE WenlongZHENG
 */

// 地图类

public class MapPanel extends JPanel implements KeyListener {
	int[][] map = new int[20][20];// 地图数组
	String face = "面";// 人物的方向

	int mapnumber = 0;// 地图编号
	int nextright = 1;// 向右一张地图的在文件位置
	int nextleft = 1;// 向左一张地图的在文件位置
	int nextup = 1;// 向上一张地图的在文件位置
	int nextdown = 1;// 向下一张地图的在文件位置
	int fazhan = 0;// 控制剧情发展
	Image image = (new ImageIcon("./pic/" + "人物" + face + ".png")).getImage();
	Image image0 = (new ImageIcon("./pic/草地.png")).getImage();
	Image image1 = (new ImageIcon("./pic/沙漠.png")).getImage();
	Image image2 = (new ImageIcon("./pic/众山.png")).getImage();
	Image image3 = (new ImageIcon("./pic/森林.png")).getImage();
	Image image4 = (new ImageIcon("./pic/海洋.png")).getImage();
	Image image5 = (new ImageIcon("./pic/城镇.png")).getImage();
	Image image6 = (new ImageIcon("./pic/花.png")).getImage();
	Image image11 = (new ImageIcon("./pic/树桩.png")).getImage();
	Image image8 = (new ImageIcon("./pic/浅草.png")).getImage();
	Image image9 = (new ImageIcon("./pic/板蓝根.png")).getImage();
	Image image10 = (new ImageIcon("./pic/服部平次.png")).getImage();
	Image image7 = (new ImageIcon("./pic/板蓝根1.png")).getImage();

	int x = 5, y = 5; // 人物图标的坐标

	StatePanel statepanel;
	Player player;

	public MapPanel(StatePanel statepanel, Player player) {
		this.player = player;
		x = player.x;
		y = player.y;
		mapnumber = player.mapnumber;
		map = this.getMap(player.mapnumber);

		setLocation();// 确定主角坐标

		this.statepanel = statepanel;
		this.setBounds(0, 0, 600, 600);
	}

	public void paintComponent(Graphics g) {
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				switch (map[i][j]) {
				case 0:
					g.drawImage(image0, i * 30, j * 30, this);
					break;
				case 1:
					g.drawImage(image1, i * 30, j * 30, this);
					break;
				case 2:
					g.drawImage(image2, i * 30, j * 30, this);
					break;
				case 3:
					g.drawImage(image3, i * 30, j * 30, this);
					break;
				case 4:
					g.drawImage(image4, i * 30, j * 30, this);
					break;
				case 5:
					g.drawImage(image5, i * 30, j * 30, this);
					break;
				case 6:
					g.drawImage(image6, i * 30, j * 30, this);
					break;
				case 7:
					g.drawImage(image7, i * 30, j * 30, this);
					break;
				case 8:
					g.drawImage(image8, i * 30, j * 30, this);
					break;
				case 9:
					g.drawImage(image9, i * 30, j * 30, this);
					break;
				case 10:
					g.drawImage(image10, i * 30, j * 30, this);
					break;
				case 11:
					g.drawImage(image11, i * 30, j * 30, this);
					break;
				}
		g.drawImage(image, x * image.getWidth(this), y
				* (image.getHeight(this) - 30) - 30, this);

	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {

		case KeyEvent.VK_DOWN:
			y++;
			if (y * (image.getHeight(this) - 30) > 570) {
				if (nextdown != 0) {
					y -= 20;
					face = "面";
					image = (new ImageIcon("./pic/" + "人物" + face + ".png"))
							.getImage();
					map = this.getMap(nextdown);
				}// 换地图
				else
					y--;
			} else if (map[x][y] != 0/*
									 * &&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10
									 */) {
				y--;
				break;
			} else {
				face = "面";
				image = (new ImageIcon("./pic/" + "人物" + face + ".png"))
						.getImage();
			}
			break;

		case KeyEvent.VK_UP:
			y--;
			if (y < 0) {
				if (nextup != 0) {
					y += 20;
					face = "背";
					image = (new ImageIcon("./pic/" + "人物" + face + ".png"))
							.getImage();
					map = this.getMap(nextup);
				}// 换地图
				else
					y++;
			} else if (map[x][y] != 0/*
									 * &&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10
									 */) {
				y++;
				break;
			} else {
				face = "背";
				image = (new ImageIcon("./pic/" + "人物" + face + ".png"))
						.getImage();
			}

			break;

		case KeyEvent.VK_RIGHT:
			x++;
			if (x * image.getWidth(this) > 570) {
				if (nextright != 0) {
					x -= 20;
					face = "右";
					image = (new ImageIcon("./pic/" + "人物" + face + ".png"))
							.getImage();
					map = this.getMap(nextright);
				}// 换地图
				else
					x--;
			} else if (map[x][y] != 0/*
									 * &&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10
									 */) {
				x--;
				break;
			} else {
				face = "右";
				image = (new ImageIcon("./pic/" + "人物" + face + ".png"))
						.getImage();
			}
			break;

		case KeyEvent.VK_LEFT:
			x--;
			if (x < 0) {
				if (nextleft != 0) {
					x += 20;
					face = "左";
					image = (new ImageIcon("./pic/" + "人物" + face + ".png"))
							.getImage();
					map = this.getMap(nextleft);
				}// 换地图
				else
					x++;
			} else if (map[x][y] != 0) {
				x++;
				break;
			} else {
				face = "左";
				image = (new ImageIcon("./pic/" + "人物" + face + ".png"))
						.getImage();
			}
			break;

		case KeyEvent.VK_ENTER:
			setEnter();

		}

		setLocation();
		this.repaint();

	}

	public void setEnter() {
		System.out.println(player.j);
		System.out.println(x + "   " + y + "    " + mapnumber);
		switch (map[x][y - 1]) {
		case 10:
			new TextDialog("服部平次：葱葱等等！");
			new TextDialog("服部平次：你也是去找柯南庆祝生日的吗？");
			new TextDialog("服部平次：我遇到了点小麻烦");
			new TextDialog("服部平次：我之前在森林中找到了一颗包治百病的板蓝根，想给柯南当做生日礼物");
			new TextDialog("服部平次：但是板蓝根趁我不注意逃走了，你能和我一起把板蓝根找回来吗？");
			new TextDialog("葱葱：当然能！");
			new TextDialog("服部平次：太好了，刚刚收集到线索说板蓝根最后出现在东北方的森林里，我们先去那里看看吧");
			new TextDialog("服部平次加入队伍");
			GameFrame.gamer=2;
			fazhan = 1;
			map[x][y - 1] = 0;
			break;
		case 0:
			if (map[x + 1][y] == 5 && fazhan == 3) {
				System.out.println(this.mapnumber);
				new TextDialog("你们经过了一番波折，终于去到了柯南家");
				new TextDialog("然后举行了热闹盛大的生日PARTY");
				new TextDialog("游戏结束，谢谢参与O(∩_∩)O~");
				new TextDialog("如果有意见，提了也没有用");
			} else if (map[x + 1][y] == 5)
				new TextDialog("这里是一片海洋。。。对面岛上就是柯南的家，就这么走去怎么可能是RPG故事！回头吧！");
			if (map[x + 1][y] == 10) {
				new TextDialog("服部平次：葱葱等等！");
				new TextDialog("服部平次：你也是去找柯南庆祝生日的吗？");
				new TextDialog("服部平次：我遇到了点小麻烦");
				new TextDialog("服部平次：我之前在森林中找到了一颗包治百病的板蓝根，想给柯南当做生日礼物");
				new TextDialog("服部平次：但是板蓝根趁我不注意逃走了，你能和我一起把板蓝根找回来吗？");
				new TextDialog("葱葱：当然能！");
				new TextDialog("服部平次：太好了，刚刚收集到线索说板蓝根最后出现在东北方的森林里，我们先去那里看看吧");
				new TextDialog("服部平次加入队伍");
				GameFrame.gamer=2;
				fazhan = 1;
				map[x + 1][y] = 0;
			}
			if (this.mapnumber == 11) {

				statepanel.repaint();

			}
			break;
		case 9:
			if (fazhan == 1) {
				new TextDialog("服部平次：就是这个板蓝根！！！");
				new TextDialog("板蓝根：！！！");
				new TextDialog("板蓝根：不约叔叔我们不约！！！！");
				new TextDialog("板蓝根消失了");
				map[x][y - 1] = 0;
				new TextDialog("。。。。。。");
				new TextDialog("。。。。。。。。。。。。。。。。");
				new TextDialog("服部平次：听说西南方的森林深处是板蓝根的家，去查看查看吧");
				fazhan = 2;
			} else
				new TextDialog("??：做坏事早晚都会被发现，所以要中午做_(:зゝ∠)_");
			break;
		case 7:
			if (fazhan == 2) {
				new TextDialog("板蓝根：你们居然能找到这里来");
				new TextDialog("板蓝根：那好吧，我们来下井字棋，如果你能赢了我就和你走");
				new ChessFrame();
				map[x][y - 1] = 0;
			} else
				new TextDialog("??:知道为什么长得丑的人有优先发言权吗？因为人们常说：我丑 话说在前面");
			fazhan=3;
			break;

		}

	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void setLocation() {
		this.player.x = x;
		this.player.y = y;
		this.player.mapnumber = mapnumber;
	}

	public int[][] getMap(int i) {
		int[][] maps = new int[20][20];
		int n = 1;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("./util/map.txt"));

			String stringmap = reader.readLine();
			StringTokenizer tokenizer = new StringTokenizer(stringmap);

			while (!stringmap.equals("")) {
				if (i == Integer.parseInt(tokenizer.nextToken())) {
					n = 0;
					break;
				}
				stringmap = reader.readLine();
				tokenizer = new StringTokenizer(stringmap);
			}
			try {
				reader.close();
			} catch (IOException ex) {
				Logger.getLogger(MapPanel.class.getName()).log(Level.SEVERE,
						null, ex);
			}

			if (n == 0) {
				mapnumber = i;
				nextup = Integer.parseInt(tokenizer.nextToken());
				nextdown = Integer.parseInt(tokenizer.nextToken());
				nextleft = Integer.parseInt(tokenizer.nextToken());
				nextright = Integer.parseInt(tokenizer.nextToken());
				for (int w = 0; w < 20; w++)
					for (int j = 0; j < 20; j++) {
						maps[j][w] = Integer.parseInt(tokenizer.nextToken());
					}

				return maps;
			} else {
				for (int w = 0; w < 20; w++)
					for (int j = 0; j < 20; j++)
						maps[j][w] = 0;
				return maps;
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(MapPanel.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IOException ex) {
			Logger.getLogger(MapPanel.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		for (int w = 0; w < 20; w++)
			for (int j = 0; j < 20; j++)
				maps[j][w] = 0;
		return maps;

	}

}
