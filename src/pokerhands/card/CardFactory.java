/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.card;

import java.util.HashMap;
import pokerhands.type.Deck;
import pokerhands.type.Value;

/**
 *
 * @author ugurdonmez
 */
public class CardFactory {
    
    private static HashMap<Integer, Card> cards = new HashMap<>();
    
    public static Card getCard(Deck deck, Value value) {
        
        int code = 13 * deck.code + value.code;
        if (cards.containsKey(code)) {
            return cards.get(code);
        } else {
            Card card = new Card(deck, value);
            cards.put(code, card);
            return card;
        }
    }
    
}
