/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.hands;

import java.util.List;
import pokerhands.card.Card;

/**
 *
 * @author ugurdonmez
 */
public class HighCard extends Hand {
    
    private final Card first;
    private final Card second;
    private final Card third;
    private final Card forth;
    private final Card fifth;

    public HighCard (Card first, Card second, Card third, Card forth, Card fifth) {
        super(CardLevel.HIGH_CARD_LEVEL);
        this.first = first;
        this.second = second;
        this.third = third;
        this.forth = forth;
        this.fifth = fifth;
    }

    public HighCard (List<Card> cards ) {
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
            throw new NullPointerException("HighCard should not be compared by null.");
        }
        
        if (!(o instanceof Hand)) {
            throw new RuntimeException("HighCard should be compared by instance of Hand.");
        }
        
        Hand hand = (Hand) o;
        
        if (this.getLevel() > hand.getLevel()) {
            return 1;
        } else if (this.getLevel() < hand.getLevel()) {
            return -1;
        }
        
        HighCard highCard = (HighCard) o;
        
        if (!this.getFirst().getValue().equals(highCard.getFirst().getValue())) {
            return this.getFirst().compareTo(highCard.getFirst());
        } else if (!this.getSecond().getValue().equals(highCard.getSecond().getValue())) {
            return this.getSecond().compareTo(highCard.getSecond());
        } else if (!this.getThird().getValue().equals(highCard.getThird().getValue())) {
            return this.getThird().compareTo(highCard.getThird());
        } else if (!this.getForth().getValue().equals(highCard.getForth().getValue())) {
            return this.getForth().compareTo(highCard.getForth());
        } else {
            return this.getFifth().getValue().compareTo(highCard.getFifth().getValue());
        }
    }
}
