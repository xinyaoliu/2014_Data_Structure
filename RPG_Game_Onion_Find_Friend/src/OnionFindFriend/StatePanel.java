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

//״̬��

public class StatePanel extends JPanel{

    public Player player;  
    Image image = (new ImageIcon("./pic/����ͷ��.jpg")).getImage();//����ͷ��ͼ��
    Image image2= (new ImageIcon("./pic/����ƽ��ͷ��.png")).getImage();
    
    public StatePanel(Player player){
        this.player = player;
        this.setSize(200, 600);
    }
    
    protected void paintComponent(Graphics g){
 
    		g.setColor(Color.WHITE);
            g.fillRect(0, 0, 200, 200);
           g.setColor(Color.BLACK);
            g.drawImage(image, 45, 0, this);
           g.drawString("���֣� "+player.name, 10, 150);//����
    	
        

    }
    

}
