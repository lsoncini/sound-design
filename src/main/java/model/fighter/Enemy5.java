package model.fighter;

import model.board.Content;
import model.element.Blood;
import model.fighter.level.EnemyLevel;

/**
 * Created by Tomi on 6/12/16.
 */
public class Enemy5 extends Enemy {

    public Enemy5(int level){
        super(new EnemyLevel(level, 1, 1));
    }

    @Override
    public Content contentLeft() {
        return new Blood();
    }

    @Override
    public void heroMoveListener() {
    }
}

