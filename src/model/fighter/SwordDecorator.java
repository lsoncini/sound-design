package model.fighter;

public class SwordDecorator extends Hero{
	
		private int swordStrenght;
	
		public SwordDecorator(Fighter fighter,int swordStrenght){
			super(fighter);
			this.swordStrenght = swordStrenght;
		}
		
		@Override
		public int getStrength() {
			return super.getStrength() + this.swordStrenght;
		}		
}
