package view;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import model.board.cell.*;
import model.board.Content;
import model.element.*;
import model.fighter.*;

public class ImageManager {
	
	private Map<String, Image> images = new HashMap<String, Image>();
	
	public ImageManager() {
		initImages();
	}

	public void initImages() {
		try{
			images.put(Rick.class.getName(), ImageUtils.loadImage("rick.png"));
			images.put(Morty.class.getName(), ImageUtils.loadImage("morty.png"));
			images.put(SwordDecorator.class.getName(), ImageUtils.loadImage("heroBase.png"));
			images.put(ShieldDecorator.class.getName(), ImageUtils.loadImage("heroBase.png"));
			images.put(Cell.class.getName(), ImageUtils.loadImage("floor.png"));
			images.put(OrangeGrass.class.getName(), ImageUtils.loadImage("orange_grass.png"));
			images.put(RedGrass.class.getName(), ImageUtils.loadImage("red_grass.png"));
			images.put(GreenGrass.class.getName(), ImageUtils.loadImage("green_grass.png"));
			images.put(YellowGrass.class.getName(), ImageUtils.loadImage("yellow_grass.png"));
			images.put(Cactus.class.getName(), ImageUtils.loadImage("cactus.png"));
			images.put(Bush.class.getName(), ImageUtils.loadImage("bush.png"));
			images.put("FOG", ImageUtils.loadImage("fog.png"));
			images.put(Wall.class.getName(), ImageUtils.loadImage("wall.png"));
			images.put(Blood.class.getName(), ImageUtils.loadImage("blood.png"));
			images.put(Enemy1.class.getName(), ImageUtils.loadImage("enemy1.png"));
			images.put(EvilRick.class.getName(), ImageUtils.loadImage("evil_rick.png"));
			images.put(Enemy2.class.getName(), ImageUtils.loadImage("enemy2.png"));
			images.put(Enemy3.class.getName(), ImageUtils.loadImage("enemy3.png"));
			images.put(Enemy4.class.getName(), ImageUtils.loadImage("enemy4.png"));
			images.put(Enemy5.class.getName(), ImageUtils.loadImage("enemy5.png"));
			images.put(HealthBonus.class.getName(), ImageUtils.loadImage("healthbonus.png"));
			images.put(Sword.class.getName(), ImageUtils.loadImage("sword.png"));
			images.put(Shield.class.getName(), ImageUtils.loadImage("armor.png"));
			images.put(AttackBonus.class.getName(), ImageUtils.loadImage("attackbonus.png"));
			images.put(HealthPotion.class.getName(), ImageUtils.loadImage("healthPotion.png"));
						
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Image get(Cell cell) {
		if (cell.hasContent()) {
			Content content = cell.getContent();
			if (content instanceof Fighter) {
				Fighter fighter = (Fighter) content;
				Image image = ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(fighter.getClass().getName()));
				return ImageUtils.drawString(image, String.valueOf(fighter.getLevel().getValue()), Color.YELLOW);
			} else if(content instanceof Valuable){
				Image image = ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(content.getClass().getName()));
				return ImageUtils.drawString(image, String.valueOf(((Valuable) content).getValue()), Color.YELLOW);
			}
			else {
				return ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(cell.getContent().getClass().getName()));
			}
		} else {
			return images.get(cell.getClass().getName());
		}
		
	}
	
	public Image get(String key) {
		return images.get(key);
	}
}
