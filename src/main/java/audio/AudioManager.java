package audio;

import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioManager {
	
	private static Clip clip;
	private static String path= "src/main/resources/";

	public static void play(String value){        
       try{
    	   AudioInputStream myInputStream = AudioSystem.getAudioInputStream(new File(path + value + ".wav"));
    	   clip=AudioSystem.getClip();
    	   clip.open(myInputStream);
    	   clip.start();
       } catch(Exception ex){
    	   System.err.println( ex.getMessage() );
       }
    }

}
