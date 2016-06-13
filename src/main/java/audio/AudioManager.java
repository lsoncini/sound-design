package audio;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioManager {

	private static Clip clip;
	private static String levelSuffix;
	private static Set<Clip> clips = new HashSet<Clip>();

	public static void play(String value){        
       try{
		   InputStream is = new BufferedInputStream(ClassLoader.getSystemResourceAsStream(value + ".wav"));
		   AudioInputStream myInputStream = AudioSystem.getAudioInputStream(is);
		   clip=AudioSystem.getClip();
    	   clip.open(myInputStream);
    	   clip.start();
    	   clips.add(clip);
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
			InputStream is = new BufferedInputStream(ClassLoader.getSystemResourceAsStream(value + ".wav"));
			AudioInputStream myInputStream = AudioSystem.getAudioInputStream(is);
			clip = AudioSystem.getClip();
			clip.open(myInputStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clips.add(clip);
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
		for(Clip c : clips){
			c.stop();
		}
	}
	
	public static void setLevelSuffix(int levelNumber){
		levelSuffix = "_level" + levelNumber;
	}

}