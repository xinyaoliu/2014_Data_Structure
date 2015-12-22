package OnionFindFriend;


import java.awt.*;

import javax.swing.*;



import java.awt.event.*;
import java.lang.*;
import java.util.*;

public class ChangeMusic extends JFrame{
	private Container contentPane;
	private JPanel upPanel;
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;
	private JPanel downPanel;
	private JPanel middlePanel;
	private JButton one;            
	private JButton two;         
	private JButton three;        
	private JButton yes;
	private JLabel b1;                //欢迎词
	private JLabel b2;
	static int i=1;
	
	public ChangeMusic() {
		
		super("更换背景音乐");
		//调用界面初始化函数
		frameInitnew();		
		
		//退出程序
		i=1;
		WindowListener w=new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				ChangeMusic.this.setVisible(false);
				//ChessFrame.this.dispose();
				//this.setVisibla(false);
				//System.exit(0);
				}
			
		};
		
		this.addWindowListener(w);
		
		//定义响应鼠标单击的事件
		
		ActionListener ch=new ActionListener(){
			public void actionPerformed(ActionEvent e){

		
				if(e.getSource()==one){         //歌曲1
					//调用内部函数，初始化棋盘
				    i=1;
    				
				}
				else if(e.getSource()==two){         //歌曲2
					i=2;
				}
				else if(e.getSource()==three){       //歌曲3
					i=3;
				}
				else if(e.getSource()==yes){       //歌曲3
					ChangeMusic.this.setVisible(false);
				}
				
			}//end actionPerformed
		};
		one.addActionListener(ch);
		two.addActionListener(ch);
		three.addActionListener(ch);
		yes.addActionListener(ch);
		
		this.setVisible(true);
	}//end changemusic
	
	public static int getSong() {
	return i;
	}
	private void frameInitnew(){
		contentPane=this.getContentPane();
		//界面的大小和位置
		this.setSize(500,500);
		this.setResizable(false);
		Dimension frameSize=this.getSize();
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		
		//面板北区
		b1=new JLabel("  请选择背景音乐>3<",JLabel.CENTER);
		b1.setFont(new java.awt.Font("Times",Font.PLAIN, 25));
		b1.setForeground(Color.black);
		upPanel=new JPanel();
		upPanel.setLayout(new GridLayout(3,1));
		upPanel.setPreferredSize(new Dimension(500, 80));
		upPanel.add(b1);
		contentPane.add(upPanel,BorderLayout.NORTH);
		
		//面板南区
		downPanel=new JPanel();
		downPanel.setPreferredSize(new Dimension(500, 60));
		downPanel.setLayout(new GridLayout(3,1));
		contentPane.add(downPanel,BorderLayout.SOUTH);
		
		//面板西区
		leftPanel=new JPanel();
		leftPanel.setPreferredSize(new Dimension(100, 60));
		leftPanel.setLayout(new GridLayout(8,1,0,15));
		contentPane.add(leftPanel,BorderLayout.WEST);

		
		//面板东区
		rightPanel=new JPanel();
		rightPanel.setPreferredSize(new Dimension(100, 360));
		rightPanel.setLayout(new GridLayout(8,1,0,15));
		//b2=new JLabel("              ",JLabel.CENTER);
		yes=new JButton("确定");
		yes.setFont(new java.awt.Font("Dialog", 0, 20));
		yes.setBorder(BorderFactory.createRaisedBevelBorder());
		yes.setEnabled(true);
		rightPanel.add(yes);
		contentPane.add(rightPanel,BorderLayout.EAST);		
		
		//面板中区
		middlePanel=new JPanel();
		middlePanel.setPreferredSize(new Dimension(100, 560));
		middlePanel.setLayout(new GridLayout(8,5,5,10));
		one=new JButton("歌曲1");
		one.setFont(new java.awt.Font("Dialog", 0, 26));
		one.setBorder(BorderFactory.createRaisedBevelBorder());
		two=new JButton("歌曲2");
		two.setFont(new java.awt.Font("Dialog", 0, 26));
		two.setBorder(BorderFactory.createRaisedBevelBorder());
		three=new JButton("歌曲3");
		three.setFont(new java.awt.Font("Dialog", 0, 26));
		three.setBorder(BorderFactory.createRaisedBevelBorder());
		middlePanel.add(one);
		middlePanel.add(two);
		middlePanel.add(three);
		contentPane.add(middlePanel,BorderLayout.CENTER);	
	}
	

		

		
	}


