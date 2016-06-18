/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.card;

import pokerhands.type.Deck;
import pokerhands.type.Value;

/**
 *
 * @author ugurdonmez
 */
public class Card implements Comparable<Card>{
    
    private final Deck deck;
    private final Value value;

    Card(Deck deck, Value value) {
        this.deck = deck;
        this.value = value;
    }

    public Deck getDeck() {
        return deck;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public int compareTo(Card o) {
        if (this == o) {
            return 0;
        }
        
        if (this.value == o.value) {
            return 0;
        } else {
            return this.value.compareTo(o.value);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash = 13 * deck.code + value.code;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.deck != other.deck) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return deck.toString() + " " + value.toString();
    }
    
}
