/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands;

import pokerhands.card.CardFactory;
import pokerhands.type.Deck;
import pokerhands.type.Value;

/**
 *
 * @author ugurdonmez
 */
public class TestCardFactory {
    
    public static void main (String [] args) {
        System.out.println(CardFactory.getCard(Deck.CLUB, Value.ACE));
        System.out.println(CardFactory.getCard(Deck.CLUB, Value.ACE));
        System.out.println(CardFactory.getCard(Deck.HEART, Value.SEVEN));
    }
    
}
