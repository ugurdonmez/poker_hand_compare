/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands;

import pokerhands.card.Card;
import pokerhands.card.CardFactory;
import pokerhands.hands.combinations.DoubleCard;
import pokerhands.hands.combinations.TripleCard;
import pokerhands.type.Deck;
import pokerhands.type.Value;

/**
 *
 * @author ugurdonmez
 */
public class CombinationEqualCheck {
 
    public static void main (String [] args) {
        
        Card card1 = CardFactory.getCard(Deck.CLUB, Value.ACE);
        Card card2 = CardFactory.getCard(Deck.CLUB, Value.ACE);
        Card card3 = CardFactory.getCard(Deck.CLUB, Value.ACE);
        
        Card card4 = CardFactory.getCard(Deck.CLUB, Value.KING);
        Card card5 = CardFactory.getCard(Deck.CLUB, Value.KING);
        Card card6 = CardFactory.getCard(Deck.CLUB, Value.KING);
        
        Card card7 = CardFactory.getCard(Deck.CLUB, Value.TEN);
        Card card8 = CardFactory.getCard(Deck.CLUB, Value.TEN);
        Card card9 = CardFactory.getCard(Deck.CLUB, Value.TEN);
        
        DoubleCard d1 = new DoubleCard(CardFactory.getCard(Deck.CLUB, Value.ACE), CardFactory.getCard(Deck.CLUB, Value.ACE));
        DoubleCard d2 = new DoubleCard(CardFactory.getCard(Deck.CLUB, Value.ACE), CardFactory.getCard(Deck.CLUB, Value.ACE));
        DoubleCard d3 = new DoubleCard(CardFactory.getCard(Deck.CLUB, Value.KING), CardFactory.getCard(Deck.CLUB, Value.ACE));
        
        System.out.println(d1.compareTo(d2));
        System.out.println(d3.compareTo(d2));
        System.out.println(d1.compareTo(d3));
        
        TripleCard t1 = new TripleCard(card1, card2, card3);
        TripleCard t2 = new TripleCard(card1, card2, card3);
        TripleCard t3 = new TripleCard(card4, card5, card6);
        
        System.out.println(t1.compareTo(t2));
        System.out.println(t3.compareTo(t2));
        System.out.println(t1.compareTo(t3));
    }
    
}
