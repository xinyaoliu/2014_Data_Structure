package OnionFindFriend;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
*
*  @author XinyaoLIU QiuyingXIE WenlongZHENG
*/

//人物类

public class Character {
	 Image image = (new ImageIcon("./pic/主角头像.jpg")).getImage();//人物头像
	    //状态最大值
	    String name;
	
	    
	    public Character(){
	        
	    }
	   
	    public Character(String name,int level){
	        
	     this.name = name;
	
	    }
	 

}
