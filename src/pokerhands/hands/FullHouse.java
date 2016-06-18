/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.hands;

import pokerhands.hands.combinations.DoubleCard;
import pokerhands.hands.combinations.TripleCard;

/**
 * Three cards of the same value, with the remaining two cards forming a pair. 
 * Ranked by the value of the three cards.
 * @author ugurdonmez
 */
public class FullHouse extends Hand {
    
    private final TripleCard tripleCard;
    private final DoubleCard doubleCard;

    public FullHouse(TripleCard tripleCard, DoubleCard doubleCard) {
        super(CardLevel.FULL_HOUSE_LEVEL);
        this.tripleCard = tripleCard;
        this.doubleCard = doubleCard;
    }

    public TripleCard getTripleCard() {
        return tripleCard;
    }

    public DoubleCard getDoubleCard() {
        return doubleCard;
    }

    @Override
    public int compareTo(Object o) {
        
        if (o == null) {
            throw new NullPointerException("FullHouse should not be compared by null.");
        }
        
        if (!(o instanceof Hand)) {
            throw new RuntimeException("FullHouse should be compared by instance of Hand.");
        }
        
        Hand hand = (Hand) o;
        
        if (this.getLevel() > hand.getLevel()) {
            return 1;
        } else if (this.getLevel() < hand.getLevel()) {
            return -1;
        }
        
        FullHouse fullHouse = (FullHouse) o;
        
        // triples can not be equal
        return this.getTripleCard().compareTo(fullHouse.getTripleCard());       
    }
}
