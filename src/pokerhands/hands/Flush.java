/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.hands;

import java.util.List;
import pokerhands.card.Card;


/**
 * Hand contains five cards of the same suit. 
 * Hands which are both flushes are ranked using the rules for High Card.
 * @author ugurdonmez
 */
public class Flush extends Hand {
    
    private final Card first;
    private final Card second;
    private final Card third;
    private final Card forth;
    private final Card fifth;
    
    public Flush(Card first, Card second, Card third, Card forth, Card fifth) {
        super(CardLevel.FLUSH_LEVEL);
        this.first = first;
        this.second = second;
        this.third = third;
        this.forth = forth;
        this.fifth = fifth;
    }

    Flush(List<Card> cards) {
        this(cards.get(0), cards.get(1), cards.get(2), cards.get(3), cards.get(4));
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

    public Card getForth() {
        return forth;
    }

    public Card getFifth() {
        return fifth;
    }
    
    @Override
    public int compareTo(Object o) {
        if (o == null) {
            throw new NullPointerException("Flush should not be compared by null.");
        }
        
        if (!(o instanceof Hand)) {
            throw new RuntimeException("Flush should be compared by instance of Hand.");
        }
        
        Hand hand = (Hand) o;
        
        if (this.getLevel() > hand.getLevel()) {
            return 1;
        } else if (this.getLevel() < hand.getLevel()) {
            return -1;
        }
        
        Flush flush = (Flush) o;
        
        if (!this.getFirst().equals(flush.getFirst())) {
            return this.getFirst().compareTo(flush.getFirst());
        } else if (!this.getSecond().equals(flush.getSecond())) {
            return this.getSecond().compareTo(flush.getSecond());
        } else if (!this.getThird().equals(flush.getThird())) {
            return this.getThird().compareTo(flush.getThird());
        } else if (!this.getForth().equals(flush.getForth())) {
            return this.getForth().compareTo(flush.getForth());
        } else {
            return this.getFifth().compareTo(flush.getFifth());
        }
    }
    
}
