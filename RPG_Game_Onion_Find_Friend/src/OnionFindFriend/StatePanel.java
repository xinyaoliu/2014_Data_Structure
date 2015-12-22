package OnionFindFriend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



/**
*
*  @author XinyaoLIU QiuyingXIE WenlongZHENG
*/

//状态类

public class StatePanel extends JPanel{

    public Player player;  
    Image image = (new ImageIcon("./pic/主角头像.jpg")).getImage();//人物头像图标
    Image image2= (new ImageIcon("./pic/服部平次头像.png")).getImage();
    
    public StatePanel(Player player){
        this.player = player;
        this.setSize(200, 600);
    }
    
    protected void paintComponent(Graphics g){
 
    		g.setColor(Color.WHITE);
            g.fillRect(0, 0, 200, 200);
           g.setColor(Color.BLACK);
            g.drawImage(image, 45, 0, this);
           g.drawString("名字： "+player.name, 10, 150);//名字
    	
        

    }
    

}
