/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.hands;

import pokerhands.card.Card;

/**
 *
 * @author ugurdonmez
 */
public class Straight extends Hand {

    private final Card highest;

    public Straight(Card highest) {
        super(CardLevel.STRAIGHT_LEVEL);
        this.highest = highest;
    }
    
    public Card getHighest() {
        return highest;
    }
    
    @Override
    public int compareTo(Object o) {
        
        if (o == null) {
            throw new NullPointerException("Straight should not be compared by null.");
        }
        
        if (!(o instanceof Hand)) {
            throw new RuntimeException("Straight should be compared by instance of Hand.");
        }
        
        Hand hand = (Hand) o;
        
        if (this.getLevel() > hand.getLevel()) {
            return 1;
        } else if (this.getLevel() < hand.getLevel()) {
            return -1;
        }
        
        Straight straight = (Straight) o;
        
        return this.getHighest().compareTo(straight.getHighest());
    }
}
