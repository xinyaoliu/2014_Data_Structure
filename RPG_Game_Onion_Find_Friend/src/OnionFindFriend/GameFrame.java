package OnionFindFriend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author XinyaoLIU QiuyingXIE WenlongZHENG
 */

// 主面板类

public class GameFrame extends JFrame implements ActionListener {
	static int gamer=1;
	Music music;
	public Player player = new Player("葱葱男神");

	MapPanel mappanel;
	StatePanel statepanel1 = new StatePanel(player);
	StatePanelCopy statepanel2 = new StatePanelCopy(player);
	JButton close = new JButton("离开游戏");
	JButton test = new JButton("新成员加入队伍");
	JButton musicc = new JButton("更换背景音乐");
	JButton musicone =new JButton("背景音乐1");
	JButton musictwo =new JButton("背景音乐2");
	JButton musicthree =new JButton("背景音乐3");
	

	public GameFrame() {

		ChooseDialog choose = new ChooseDialog("             是否要从上次存档的地方继续开始？");

		if (choose.getI() == 1)
			player.load();

		mappanel = new MapPanel(statepanel1, player);
		if (choose.getI() == 0) {
			{new TextDialog("葱葱男神的好朋友柯南要过生日\n");
	         new TextDialog( "于是葱葱男神准备去找柯南庆祝生日。");
	         
	         new TextDialog(player.name+"出发。\n");
	        }

		}

		this.setLayout(null);
		this.setBounds(300, 100, 600+200, 635);//窗口大小
		this.add(mappanel);
		
		this.add(statepanel1);//右边界面
		statepanel1.setBounds(600, 0, 200, 550);
/*
		this.add(musicc);
		musicc.setBounds(625, 440, 150, 30);//更换音乐窗口大小
		musicc.addActionListener(this);
*/		
		this.add(musicone);
		musicone.setBounds(625, 400, 150, 20);//更换音乐窗口大小
		musicone.addActionListener(this);
		
		this.add(musictwo);
		musictwo.setBounds(625, 430, 150, 20);//更换音乐窗口大小
		musictwo.addActionListener(this);
		
		this.add(musicthree);
		musicthree.setBounds(625, 460, 150, 20);//更换音乐窗口大小
		musicthree.addActionListener(this);
		
		this.add(test);
		test.setBounds(625, 500, 150, 30);//加入新成员窗口大小
		test.addActionListener(this);
	
		this.add(close);
		close.setBounds(625, 560, 150, 30);//离开游戏窗口大小
		close.addActionListener(this);
		


		

		this.addKeyListener(mappanel);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==close) {
			ChooseDialog choose = new ChooseDialog("             是否确认关闭游戏？");
			
			if (choose.getI() == 1) {
				player.save();
				music.Close();
				this.dispose();
			}
				
			if (choose.getI() == 0) 
				this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			    close.setFocusable(false);

		}
		
		if(e.getSource()==test) {
			if(GameFrame.gamer==2) {
			this.add(statepanel2);
			statepanel2.setBounds(600, 0, 200, 550);
			}
			
			else if(GameFrame.gamer==1) {
				new TextDialog("没有新成员可以加入队伍哟!");
				test.setFocusable(false);
			}
		}
		if(e.getSource()==musicone) {
			music.Close();
			music = new Music("./util/游戏配乐1.au");
			music.Open();
			musictwo.setFocusable(false);
		}
		if(e.getSource()==musictwo) {
			music.Close();
			music = new Music("./util/游戏配乐2.au");
			musictwo.setFocusable(false);
			
		}
		if(e.getSource()==musicthree) {
			music.Close();
			music = new Music("./util/游戏配乐3.au");
			musicthree.setFocusable(false);
		}
		/*if(e.getSource()==musicc) {
			new ChangeMusic();
			int temp=ChangeMusic.getSong();
			if(temp==2||temp==3)
				music.Close();
			musicc.setFocusable(false);
		}
	*/
}
	
	
}
