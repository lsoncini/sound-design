package model.element;

import audio.AudioManager;
import model.board.Content;
import model.fighter.Fighter;

/**
 * Created by Tomi on 6/12/16.
 */
public class Morty implements Content {

    private boolean found = false;

    @Override
    public boolean canWalkOver() {
        return false;
    }

    @Override
    public Content interact(Fighter hero) {
        this.found = true;
        AudioManager.play("wubba");
        return this;
    }

    public boolean isFound() {
        return found;
    }

}
