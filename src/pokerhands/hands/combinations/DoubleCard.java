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
public class DoubleCard<N extends DoubleCard> implements Comparable<N> {
    
    private final Card card1;
    private final Card card2;

    public DoubleCard(Card card1, Card card2) {
        this.card1 = card1;
        this.card2 = card2;
    }
    
    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    @Override
    public int compareTo(N o) {
        if (this == o) {
            return 0;
        }
        
        return this.getCard1().compareTo(o.getCard1());
    }
}
