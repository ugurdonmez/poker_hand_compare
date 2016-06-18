/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands;

import pokerhands.card.Card;
import pokerhands.card.CardFactory;
import pokerhands.hands.FourOfaKind;
import pokerhands.hands.combinations.FourCard;
import pokerhands.type.Deck;
import pokerhands.type.Value;

/**
 *
 * @author ugurdonmez
 */
public class TestFourOfaKindEquality {
    
    public static void main (String [] args) {
        
        Card card1 = CardFactory.getCard(Deck.CLUB, Value.ACE);
        Card card2 = CardFactory.getCard(Deck.CLUB, Value.ACE);
        Card card3 = CardFactory.getCard(Deck.CLUB, Value.ACE);
        Card card4 = CardFactory.getCard(Deck.CLUB, Value.ACE);
        
        Card card5 = CardFactory.getCard(Deck.CLUB, Value.TWO);
        Card card6 = CardFactory.getCard(Deck.CLUB, Value.TWO);
        Card card7 = CardFactory.getCard(Deck.CLUB, Value.TWO);
        Card card8 = CardFactory.getCard(Deck.CLUB, Value.TWO);
        
        FourCard fc1 = new FourCard(card1, card2, card3, card4);
        FourCard fc2 = new FourCard(card1, card2, card3, card4);
        FourCard fc3 = new FourCard(card5, card6, card7, card8);
        
        FourOfaKind fok1 = new FourOfaKind(fc1, card8);
        FourOfaKind fok2 = new FourOfaKind(fc2, card8);
        FourOfaKind fok3 = new FourOfaKind(fc3, card8);
        
        System.out.println(fok1.compareTo(fok2));
        System.out.println(fok2.compareTo(fok3));
        System.out.println(fok3.compareTo(fok2));
    }
    
}
