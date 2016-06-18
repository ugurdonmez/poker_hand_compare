/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.hands;

import pokerhands.card.Card;
import pokerhands.hands.combinations.DoubleCard;

/**
 *
 * @author ugurdonmez
 */
public class TwoPair extends Hand {
    
    private final DoubleCard doubleCard1;
    private final DoubleCard doubleCard2;
    private final Card card;

    public TwoPair(DoubleCard doubleCard1, DoubleCard doubleCard2, Card card) {
        super(CardLevel.TWO_PAIR_LEVEL);
        this.doubleCard1 = doubleCard1;
        this.doubleCard2 = doubleCard2;
        this.card = card;
    }

    public DoubleCard getDoubleCard1() {
        return doubleCard1;
    }

    public DoubleCard getDoubleCard2() {
        return doubleCard2;
    }

    public Card getCard() {
        return card;
    }
    
    @Override
    public int compareTo(Object o) {
        
        if (o == null) {
            throw new NullPointerException("TwoPair should not be compared by null.");
        }
        
        if (!(o instanceof Hand)) {
            throw new RuntimeException("TwoPair should be compared by instance of Hand.");
        }
        
        Hand hand = (Hand) o;
        
        if (this.getLevel() > hand.getLevel()) {
            return 1;
        } else if (this.getLevel() < hand.getLevel()) {
            return -1;
        }
        
        TwoPair twoPair = (TwoPair) o;
        
        if (!this.getDoubleCard1().equals(twoPair.getDoubleCard1())) {
            return this.getDoubleCard1().compareTo(twoPair.getDoubleCard1());
        } else if (!this.getDoubleCard2().equals(twoPair.getDoubleCard2())) {
            return this.getDoubleCard2().compareTo(twoPair.getDoubleCard2());
        } else {
            return this.getCard().compareTo(twoPair.getCard());
        }
    }
}
