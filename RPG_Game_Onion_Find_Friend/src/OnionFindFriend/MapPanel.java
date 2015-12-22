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

// ��ͼ��

public class MapPanel extends JPanel implements KeyListener {
	int[][] map = new int[20][20];// ��ͼ����
	String face = "��";// ����ķ���

	int mapnumber = 0;// ��ͼ���
	int nextright = 1;// ����һ�ŵ�ͼ�����ļ�λ��
	int nextleft = 1;// ����һ�ŵ�ͼ�����ļ�λ��
	int nextup = 1;// ����һ�ŵ�ͼ�����ļ�λ��
	int nextdown = 1;// ����һ�ŵ�ͼ�����ļ�λ��
	int fazhan = 0;// ���ƾ��鷢չ
	Image image = (new ImageIcon("./pic/" + "����" + face + ".png")).getImage();
	Image image0 = (new ImageIcon("./pic/�ݵ�.png")).getImage();
	Image image1 = (new ImageIcon("./pic/ɳĮ.png")).getImage();
	Image image2 = (new ImageIcon("./pic/��ɽ.png")).getImage();
	Image image3 = (new ImageIcon("./pic/ɭ��.png")).getImage();
	Image image4 = (new ImageIcon("./pic/����.png")).getImage();
	Image image5 = (new ImageIcon("./pic/����.png")).getImage();
	Image image6 = (new ImageIcon("./pic/��.png")).getImage();
	Image image11 = (new ImageIcon("./pic/��׮.png")).getImage();
	Image image8 = (new ImageIcon("./pic/ǳ��.png")).getImage();
	Image image9 = (new ImageIcon("./pic/������.png")).getImage();
	Image image10 = (new ImageIcon("./pic/����ƽ��.png")).getImage();
	Image image7 = (new ImageIcon("./pic/������1.png")).getImage();

	int x = 5, y = 5; // ����ͼ�������

	StatePanel statepanel;
	Player player;

	public MapPanel(StatePanel statepanel, Player player) {
		this.player = player;
		x = player.x;
		y = player.y;
		mapnumber = player.mapnumber;
		map = this.getMap(player.mapnumber);

		setLocation();// ȷ����������

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
					face = "��";
					image = (new ImageIcon("./pic/" + "����" + face + ".png"))
							.getImage();
					map = this.getMap(nextdown);
				}// ����ͼ
				else
					y--;
			} else if (map[x][y] != 0/*
									 * &&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10
									 */) {
				y--;
				break;
			} else {
				face = "��";
				image = (new ImageIcon("./pic/" + "����" + face + ".png"))
						.getImage();
			}
			break;

		case KeyEvent.VK_UP:
			y--;
			if (y < 0) {
				if (nextup != 0) {
					y += 20;
					face = "��";
					image = (new ImageIcon("./pic/" + "����" + face + ".png"))
							.getImage();
					map = this.getMap(nextup);
				}// ����ͼ
				else
					y++;
			} else if (map[x][y] != 0/*
									 * &&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10
									 */) {
				y++;
				break;
			} else {
				face = "��";
				image = (new ImageIcon("./pic/" + "����" + face + ".png"))
						.getImage();
			}

			break;

		case KeyEvent.VK_RIGHT:
			x++;
			if (x * image.getWidth(this) > 570) {
				if (nextright != 0) {
					x -= 20;
					face = "��";
					image = (new ImageIcon("./pic/" + "����" + face + ".png"))
							.getImage();
					map = this.getMap(nextright);
				}// ����ͼ
				else
					x--;
			} else if (map[x][y] != 0/*
									 * &&map[x][y]!=5&&map[x][y]!=6&&map[x][y]!=10
									 */) {
				x--;
				break;
			} else {
				face = "��";
				image = (new ImageIcon("./pic/" + "����" + face + ".png"))
						.getImage();
			}
			break;

		case KeyEvent.VK_LEFT:
			x--;
			if (x < 0) {
				if (nextleft != 0) {
					x += 20;
					face = "��";
					image = (new ImageIcon("./pic/" + "����" + face + ".png"))
							.getImage();
					map = this.getMap(nextleft);
				}// ����ͼ
				else
					x++;
			} else if (map[x][y] != 0) {
				x++;
				break;
			} else {
				face = "��";
				image = (new ImageIcon("./pic/" + "����" + face + ".png"))
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
			new TextDialog("����ƽ�Σ��деȵȣ�");
			new TextDialog("����ƽ�Σ���Ҳ��ȥ�ҿ�����ף���յ���");
			new TextDialog("����ƽ�Σ��������˵�С�鷳");
			new TextDialog("����ƽ�Σ���֮ǰ��ɭ�����ҵ���һ�Ű��ΰٲ��İ�������������ϵ�����������");
			new TextDialog("����ƽ�Σ����ǰ��������Ҳ�ע�������ˣ����ܺ���һ��Ѱ������һ�����");
			new TextDialog("�дУ���Ȼ�ܣ�");
			new TextDialog("����ƽ�Σ�̫���ˣ��ո��ռ�������˵�������������ڶ�������ɭ���������ȥ���￴����");
			new TextDialog("����ƽ�μ������");
			GameFrame.gamer=2;
			fazhan = 1;
			map[x][y - 1] = 0;
			break;
		case 0:
			if (map[x + 1][y] == 5 && fazhan == 3) {
				System.out.println(this.mapnumber);
				new TextDialog("���Ǿ�����һ�����ۣ�����ȥ���˿��ϼ�");
				new TextDialog("Ȼ�����������ʢ�������PARTY");
				new TextDialog("��Ϸ������лл����O(��_��)O~");
				new TextDialog("��������������Ҳû����");
			} else if (map[x + 1][y] == 5)
				new TextDialog("������һƬ���󡣡������浺�Ͼ��ǿ��ϵļң�����ô��ȥ��ô������RPG���£���ͷ�ɣ�");
			if (map[x + 1][y] == 10) {
				new TextDialog("����ƽ�Σ��деȵȣ�");
				new TextDialog("����ƽ�Σ���Ҳ��ȥ�ҿ�����ף���յ���");
				new TextDialog("����ƽ�Σ��������˵�С�鷳");
				new TextDialog("����ƽ�Σ���֮ǰ��ɭ�����ҵ���һ�Ű��ΰٲ��İ�������������ϵ�����������");
				new TextDialog("����ƽ�Σ����ǰ��������Ҳ�ע�������ˣ����ܺ���һ��Ѱ������һ�����");
				new TextDialog("�дУ���Ȼ�ܣ�");
				new TextDialog("����ƽ�Σ�̫���ˣ��ո��ռ�������˵�������������ڶ�������ɭ���������ȥ���￴����");
				new TextDialog("����ƽ�μ������");
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
				new TextDialog("����ƽ�Σ��������������������");
				new TextDialog("��������������");
				new TextDialog("����������Լ�������ǲ�Լ��������");
				new TextDialog("��������ʧ��");
				map[x][y - 1] = 0;
				new TextDialog("������������");
				new TextDialog("��������������������������������");
				new TextDialog("����ƽ�Σ���˵���Ϸ���ɭ����ǰ������ļң�ȥ�鿴�鿴��");
				fazhan = 2;
			} else
				new TextDialog("??�������������ᱻ���֣�����Ҫ������_(:�٩f��)_");
			break;
		case 7:
			if (fazhan == 2) {
				new TextDialog("�����������Ǿ�Ȼ���ҵ�������");
				new TextDialog("���������Ǻðɣ��������¾����壬�������Ӯ���Ҿͺ�����");
				new ChessFrame();
				map[x][y - 1] = 0;
			} else
				new TextDialog("??:֪��Ϊʲô���ó���������ȷ���Ȩ����Ϊ���ǳ�˵���ҳ� ��˵��ǰ��");
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
