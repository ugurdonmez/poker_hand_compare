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
public class Pair extends Hand {
    
    private final DoubleCard doubleCard;
    private final Card first;
    private final Card second;
    private final Card third;

    public Pair(DoubleCard doubleCard, Card first, Card second, Card third) {
        super(CardLevel.PAIR_LEVEL);
        this.doubleCard = doubleCard;
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public DoubleCard getDoubleCard() {
        return doubleCard;
    }

    public Card getFirst() {
        return first;
    }

    public Card getSecond() {
        return second;
    }

    public Card getThird() {
        return third;
    }
    
    @Override
    public int compareTo(Object o) {
        
        if (o == null) {
            throw new NullPointerException("Pair should not be compared by null.");
        }
        
        if (!(o instanceof Hand)) {
            throw new RuntimeException("Pair should be compared by instance of Hand.");
        }
        
        Hand hand = (Hand) o;
        
        if (this.getLevel() > hand.getLevel()) {
            return 1;
        } else if (this.getLevel() < hand.getLevel()) {
            return -1;
        }
        
        Pair pair = (Pair) o;
        
        if (!this.getDoubleCard().equals(pair.getDoubleCard())) {
            return this.getDoubleCard().compareTo(pair.getDoubleCard());
        } else if (!this.getFirst().equals(pair.getFirst())) {
            return this.getFirst().compareTo(pair.getFirst());
        } else if (!this.getSecond().equals(pair.getSecond())) {
            return this.getSecond().compareTo(pair.getSecond());
        } else {
            return this.getThird().compareTo(pair.getThird());
        }
    }
}
