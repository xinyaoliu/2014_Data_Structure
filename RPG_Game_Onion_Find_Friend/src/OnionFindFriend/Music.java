package OnionFindFriend;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 *  @author XinyaoLIU QiuyingXIE WenlongZHENG
 */

//±≥æ∞“Ù¿÷¿‡

public class Music {

    boolean looping = false;
    File file1 = new File("./util/”Œœ∑≈‰¿÷3.au"); 
    AudioClip sound1; 
    AudioClip chosenClip; 

     public Music(){
        try {
            sound1 = Applet.newAudioClip(file1.toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
         chosenClip = sound1;
         looping = true;
         chosenClip.loop();
     }
     
     public Music(String string){
         file1 = new File(string); 
        try {
            sound1 = Applet.newAudioClip(file1.toURL());//deprecated « ≤√¥£ø£ø£ø
        } catch (MalformedURLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
         chosenClip = sound1;
         looping = true;
         chosenClip.loop();
     }
     public void Open() {
    	 chosenClip.play();
     }
     
     public void Close(){
         chosenClip.stop();
     }

}
