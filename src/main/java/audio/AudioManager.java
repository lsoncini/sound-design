package audio;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioManager {

	 private static Clip clip;
	 private static String path= "src/main/resources/";
	 private static String levelSuffix;
	 private static Set<Clip> loopingClips = new HashSet<Clip>();

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
		play(levelValue);
	}
	
	public static void loop(String value){
		try {
			AudioInputStream myInputStream = AudioSystem.getAudioInputStream(new File(path + value + ".wav"));
			clip = AudioSystem.getClip();
			clip.open(myInputStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			loopingClips.add(clip);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void loopForLevel(String value){
		String levelValue = value + levelSuffix;
		loop(levelValue);
	}
	
	public static void stop(){
		if(clip == null)
			return;
		clip.stop();
		for(Clip c : loopingClips){
			c.stop();
		}
	}
	
	public static void setLevelSuffix(int levelNumber){
		levelSuffix = "_level" + levelNumber;
	}

}