package OnionFindFriend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;


/**
*
*  @author XinyaoLIU QiuyingXIE WenlongZHENG
*/

//�����

public class Player extends Character{


    int i = -1;//��Ϸ����
    int j = 0;//��Ϸ����
    int m = 0;//��Ϸ����
    
    

    //�������� 
    int x=5,y=5;
    //�������ڵĵ�ͼ
    int mapnumber = 1;
    
    public Player(){
        image = (new ImageIcon("./pic/����ͷ��.jpg")).getImage();
      //  name = "�д�";

}
   
    public Player(String name){
        
        image = (new ImageIcon("./pic/����ͷ��.jpg")).getImage();
        
        this.name = name;
 
    
       
}  
   
    void save() {
            try { 
            	FileWriter fw = new FileWriter("./util/player.txt"); 
            	BufferedWriter buffw=new BufferedWriter(fw);
            	PrintWriter pw=new PrintWriter(buffw);
                     pw.println();
                     pw.println(name);
                     pw.println(x);
                     pw.println(y);
                     pw.println(mapnumber);
                     pw.println(i);
                     pw.println(j);
                     pw.println(m);
                     pw.close();
                     buffw.close();
                     fw.close(); 
    }
            catch(Exception e) { 
} 

    }
    
    public void load(){
           try {
              BufferedReader input;
              FileReader reader=null;
              reader = new FileReader("./util/player.txt");
              input=new BufferedReader(reader);
              input.readLine();
              name = input.readLine();
              System.out.println(name);
              x = Integer.parseInt(input.readLine());
              y = Integer.parseInt(input.readLine());
              mapnumber = Integer.parseInt(input.readLine());
              i = Integer.parseInt(input.readLine());
              j = Integer.parseInt(input.readLine());
              m = Integer.parseInt(input.readLine());


              reader.close();
              input.close();
            }catch (FileNotFoundException ex) {
            }catch (IOException ex) {}
    }

 
     
}
