/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.hands.combinations;

import pokerhands.card.Card;

/**
 *
 * @author ugurdonmez
 */
public class TripleCard extends DoubleCard {
    
    private final Card card3;

    public TripleCard(Card card1, Card card2, Card card3) {
        super(card1, card2);
        this.card3 = card3;
    }

    public Card getCard3() {
        return card3;
    }
}
