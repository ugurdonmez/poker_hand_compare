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
public class FourCard extends TripleCard {
    
    private final Card card4;

    public FourCard(Card card1, Card card2, Card card3, Card card4) {
        super(card1, card2, card3);
        this.card4 = card4;
    }

    public Card getCard4() {
        return card4;
    }
}
