/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.hands;

import pokerhands.card.Card;
import pokerhands.hands.combinations.FourCard;

/**
 * Four cards with the same value. 
 * Ranked by the value of the four cards.
 * @author ugurdonmez
 */
public class FourOfaKind extends Hand {
    
    private final FourCard fourCard;
    private final Card card;

    public FourOfaKind(FourCard fourCard, Card card) {
        super(CardLevel.FOUR_OF_A_KIND_LEVEL);
        this.fourCard = fourCard;
        this.card = card;
    }

    public FourCard getFourCard() {
        return fourCard;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public int compareTo(Object o) {
        
        if (o == null) {
            throw new NullPointerException("FourOfaKind should not be compared by null");
        }
        
        if (!(o instanceof Hand)) {
            throw new RuntimeException("FourOfaKind should be compared by instance of Hand.");
        }
        
        if (this == o) {
            return 0;
        }
        
        Hand hand = (Hand) o;
        
        if (this.getLevel() < hand.getLevel()) {
            return -1;
        } else if (this.getLevel() > hand.getLevel()) {
            return 1;
        }
        
        FourOfaKind fourOfaKind = (FourOfaKind) o;
        
        return this.getFourCard().compareTo(fourOfaKind.getFourCard());
    }

}
