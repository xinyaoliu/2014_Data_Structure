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

//״̬��2

public class StatePanelCopy extends JPanel{

    public Player player;  
    Image image = (new ImageIcon("./pic/����ͷ��.jpg")).getImage();//����ͷ��ͼ��
    Image image2= (new ImageIcon("./pic/����ƽ��ͷ��.png")).getImage();
    
    public StatePanelCopy(Player player){
        this.player = player;
        this.setSize(200, 600);
    }
    
    protected void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 200, 600);
        g.fillRect(0, 300, 200, 600);
        g.setColor(Color.BLACK);
        g.drawImage(image, 45, 0, this);
        g.drawImage(image2,15,200, this);
        g.drawString("���֣� "+player.name, 10, 150);//����
        g.drawString("���֣� "+"����ƽ��", 10, 350);//����
     
    }
    

}
