/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.hands;

import pokerhands.card.Card;
import pokerhands.hands.combinations.TripleCard;

/**
 * Three of the cards in the hand have the same value. 
 * Hands which both contain three of a kind are ranked by the value of the three cards.
 * @author ugurdonmez
 */
public class ThreeOfaKind extends Hand {
    
    private final TripleCard tripleCard;
    private final Card card1;
    private final Card card2;

    public ThreeOfaKind(TripleCard tripleCard, Card card1, Card card2) {
        super(CardLevel.THREE_OF_A_KIND_LEVEL);
        this.tripleCard = tripleCard;
        this.card1 = card1;
        this.card2 = card2;
    }

    public TripleCard getTripleCard() {
        return tripleCard;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }
    
    /**
     * TODO: same as full house. Should reuse the same code.
     * Try to figure out.
     */
    @Override
    public int compareTo(Object o) {
        
        if (o == null) {
            throw new NullPointerException("ThreeOfaKind should not be compared by null.");
        }
        
        if (!(o instanceof Hand)) {
            throw new RuntimeException("ThreeOfaKind should be compared by instance of Hand.");
        }
        
        Hand hand = (Hand) o;
        
        if (this.getLevel() > hand.getLevel()) {
            return 1;
        } else if (this.getLevel() < hand.getLevel()) {
            return -1;
        }
        
        ThreeOfaKind threeOfaKind = (ThreeOfaKind) o;
        
        // triples can not be equal
        return this.getTripleCard().compareTo(threeOfaKind.getTripleCard());       
    }
    
}
