package audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioManager {

	 private static Clip clip;
	 private static String path= "src/main/resources/";
	 private static String levelSuffix;

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
	
	public static void playForLevel(String value){
		String levelValue = value + levelSuffix;
		try{
	    	   AudioInputStream myInputStream = AudioSystem.getAudioInputStream(new File(path + levelValue + ".wav"));
	    	   clip=AudioSystem.getClip();
	    	   clip.open(myInputStream);
	    	   clip.start();
	       }catch(Exception ex){
	    	   System.err.println( ex.getMessage() );
	       }
	}
	
	public static void loop(String value){
		try {
			AudioInputStream myInputStream = AudioSystem.getAudioInputStream(new File(path + value + ".wav"));
			clip = AudioSystem.getClip();
			clip.open(myInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void stop(){
		clip.stop();
	}
	
	public static void setLevelSuffix(int levelNumber){
		levelSuffix = "_level" + levelNumber;
	}

}