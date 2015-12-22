package OnionFindFriend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author XinyaoLIU QiuyingXIE WenlongZHENG
 */

// �������

public class GameFrame extends JFrame implements ActionListener {
	static int gamer=1;
	Music music;
	public Player player = new Player("�д�����");

	MapPanel mappanel;
	StatePanel statepanel1 = new StatePanel(player);
	StatePanelCopy statepanel2 = new StatePanelCopy(player);
	JButton close = new JButton("�뿪��Ϸ");
	JButton test = new JButton("�³�Ա�������");
	JButton musicc = new JButton("������������");
	JButton musicone =new JButton("��������1");
	JButton musictwo =new JButton("��������2");
	JButton musicthree =new JButton("��������3");
	

	public GameFrame() {

		ChooseDialog choose = new ChooseDialog("             �Ƿ�Ҫ���ϴδ浵�ĵط�������ʼ��");

		if (choose.getI() == 1)
			player.load();

		mappanel = new MapPanel(statepanel1, player);
		if (choose.getI() == 0) {
			{new TextDialog("�д�����ĺ����ѿ���Ҫ������\n");
	         new TextDialog( "���Ǵд�����׼��ȥ�ҿ�����ף���ա�");
	         
	         new TextDialog(player.name+"������\n");
	        }

		}

		this.setLayout(null);
		this.setBounds(300, 100, 600+200, 635);//���ڴ�С
		this.add(mappanel);
		
		this.add(statepanel1);//�ұ߽���
		statepanel1.setBounds(600, 0, 200, 550);
/*
		this.add(musicc);
		musicc.setBounds(625, 440, 150, 30);//�������ִ��ڴ�С
		musicc.addActionListener(this);
*/		
		this.add(musicone);
		musicone.setBounds(625, 400, 150, 20);//�������ִ��ڴ�С
		musicone.addActionListener(this);
		
		this.add(musictwo);
		musictwo.setBounds(625, 430, 150, 20);//�������ִ��ڴ�С
		musictwo.addActionListener(this);
		
		this.add(musicthree);
		musicthree.setBounds(625, 460, 150, 20);//�������ִ��ڴ�С
		musicthree.addActionListener(this);
		
		this.add(test);
		test.setBounds(625, 500, 150, 30);//�����³�Ա���ڴ�С
		test.addActionListener(this);
	
		this.add(close);
		close.setBounds(625, 560, 150, 30);//�뿪��Ϸ���ڴ�С
		close.addActionListener(this);
		


		

		this.addKeyListener(mappanel);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==close) {
			ChooseDialog choose = new ChooseDialog("             �Ƿ�ȷ�Ϲر���Ϸ��");
			
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
				new TextDialog("û���³�Ա���Լ������Ӵ!");
				test.setFocusable(false);
			}
		}
		if(e.getSource()==musicone) {
			music.Close();
			music = new Music("./util/��Ϸ����1.au");
			music.Open();
			musictwo.setFocusable(false);
		}
		if(e.getSource()==musictwo) {
			music.Close();
			music = new Music("./util/��Ϸ����2.au");
			musictwo.setFocusable(false);
			
		}
		if(e.getSource()==musicthree) {
			music.Close();
			music = new Music("./util/��Ϸ����3.au");
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
