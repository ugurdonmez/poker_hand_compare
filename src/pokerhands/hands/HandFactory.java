package pokerhands.hands;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import pokerhands.card.Card;
import pokerhands.card.CardFactory;
import pokerhands.hands.combinations.DoubleCard;
import pokerhands.hands.combinations.FourCard;
import pokerhands.hands.combinations.TripleCard;
import pokerhands.type.Deck;
import pokerhands.type.Value;

/**
 *
 * @author ugurdonmez
 */
public class HandFactory {
    
    private static HashMap<Character, Deck> decks = new HashMap<>();
    private static HashMap<String, Value> values = new HashMap<>();
    
    static {
        decks.put('H', Deck.HEART);
        decks.put('D', Deck.DIAMOND);
        decks.put('C', Deck.CLUB);
        decks.put('S', Deck.SPADE);
        
        values.put("2", Value.TWO);
        values.put("3", Value.THREE);
        values.put("4", Value.FOUR);
        values.put("5", Value.FIVE);
        values.put("6", Value.SIX);
        values.put("7", Value.SEVEN);
        values.put("8", Value.EIGHT);
        values.put("9", Value.NINE);
        values.put("10", Value.TEN);
        values.put("J", Value.JACK);
        values.put("Q", Value.QUEEN);
        values.put("K", Value.KING);
        values.put("A", Value.ACE);
    }
    
    public static Hand getHand(String [] strArray) {
        
        List<Card> cards = Arrays.asList(strArray).stream()
                .map(HandFactory::getCardFromInput)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        // straight flush
        if (isStraight(cards) && isFlush(cards)) {
            return getStraightFlush(cards);
        }
        
        // four of a kind
        if (isFourOfaKind(cards)) {
            return getFourOfaKind(cards);
        }
        
        // full house
        if (isFullHouse(cards)) {
            return getFullHouse(cards);
        }
        
        // flush
        if (isFlush(cards)) {
            return getFlush(cards);
        }
        
        // straight
        if (isStraight(cards)) {
            return getStraight(cards);
        }
        
        // three of a kind
        if (isThreeOfaKind(cards)) {
            return getThreeOfaKind(cards);
        }
        
        // two pair
        if (isTwoPair(cards)) {
            return getTwoPair(cards);
        }
        
        // pair
        if (isPair(cards)) {
            return getPair(cards);
        }
        
        // highest card
        return getHighCard(cards);
    }
    
    /**
     * 
     * @param input 2H 3D 5S 9C KD
     * @return 
     */
    public static Hand getHand(String input) {
        return HandFactory.getHand(input.split(" "));
    }
    
    private static Card getCardFromInput (String str) {
        
        char deckChar = str.charAt(str.length()-1);
        
        int valuesFirst = 0;
        int valuesLast = str.length() - 1;
        
        String valuesString = str.substring(valuesFirst, valuesLast);
        
        return CardFactory.getCard(decks.get(deckChar), values.get(valuesString));
    }
    
    private static boolean isStraight (List<Card> cards) {
        for (int i = 1; i < 5; i++) {
            if ( cards.get(i).getValue().code + 1 != cards.get(i-1).getValue().code) {
                return false;
            }
        }
        
        return true;
    }
    
    private static Straight getStraight (List<Card> cards) {
        return new Straight(cards.get(0));
    }
    
    private static boolean isFlush (List<Card> cards) {
        Deck firstDeck = cards.get(0).getDeck();
        
        for (Card c : cards) {
            if (c.getDeck() != firstDeck) {
                return false;
            }
        }
        
        return true;
    }
    
    private static Flush getFlush (List<Card> cards) {
        return new Flush(cards);
    }
    
    private static StraightFlush getStraightFlush (List<Card> cards) {
        return new StraightFlush(cards.get(0));
    }
    
    private static boolean isFourOfaKind (List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(1).getValue() == cards.get(2).getValue() &&
                cards.get(2).getValue() == cards.get(3).getValue()) {
            return true;
        } else if (cards.get(1).getValue() == cards.get(2).getValue() &&
                cards.get(2).getValue() == cards.get(3).getValue() &&
                cards.get(3).getValue() == cards.get(4).getValue()) {
            return true;
        } else {
            return false;
        }        
    }
    
    private static FourOfaKind getFourOfaKind (List<Card> cards) {
        return cards.get(0).getValue().code > cards.get(4).getValue().code ?
                    new FourOfaKind(new FourCard(cards.get(0), 
                            cards.get(1), cards.get(2), cards.get(3)), 
                            cards.get(4)) :
                    new FourOfaKind(new FourCard(cards.get(1), 
                            cards.get(2), cards.get(3), cards.get(4)), 
                            cards.get(0));
    }
    
    private static boolean isFullHouse (List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(1).getValue() == cards.get(2).getValue() &&
                cards.get(2).getValue() != cards.get(3).getValue() &&
                cards.get(3).getValue() == cards.get(4).getValue() ) {
            return true;
        } else if (cards.get(2).getValue() == cards.get(3).getValue() &&
                cards.get(3).getValue() == cards.get(4).getValue() &&
                cards.get(4).getValue() == cards.get(0).getValue() &&
                cards.get(0).getValue() == cards.get(1).getValue() ) {
            return true;
        } else {
            return false;
        }
    }
    
    private static FullHouse getFullHouse (List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(1).getValue() == cards.get(2).getValue() &&
                cards.get(2).getValue() != cards.get(3).getValue() &&
                cards.get(3).getValue() == cards.get(4).getValue() ) {
            return new FullHouse(new TripleCard(cards.get(0), cards.get(1), 
                    cards.get(2)), 
                    new DoubleCard(cards.get(3), cards.get(4)));
        }  else {
            return new FullHouse(new TripleCard(cards.get(2), cards.get(3), 
                    cards.get(4)), 
                    new DoubleCard(cards.get(0), cards.get(1)));
        }
    }

    private static boolean isThreeOfaKind (List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(1).getValue() == cards.get(2).getValue()) {
            return true;
        } else if (cards.get(1).getValue() == cards.get(2).getValue() &&
                cards.get(2).getValue() == cards.get(3).getValue()) {
            return true;
        } else if (cards.get(2).getValue() == cards.get(3).getValue() &&
                cards.get(3).getValue() == cards.get(4).getValue()) {
            return true;
        } else {
            return false;
        }
    }
    
    private static ThreeOfaKind getThreeOfaKind (List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(1).getValue() == cards.get(2).getValue()) {
            return new ThreeOfaKind(new TripleCard(cards.get(0), cards.get(1), 
                    cards.get(2)), 
                    cards.get(3), cards.get(4));
        } else if (cards.get(1).getValue() == cards.get(2).getValue() &&
                cards.get(2).getValue() == cards.get(3).getValue()) {
            return new ThreeOfaKind(new TripleCard(cards.get(1), cards.get(2), 
                    cards.get(3)), 
                    cards.get(0), cards.get(4));
        } else {
            return new ThreeOfaKind(new TripleCard(cards.get(2), cards.get(3), 
                    cards.get(4)), 
                    cards.get(0), cards.get(1));
        }
    }

    private static boolean isTwoPair (List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(2).getValue() == cards.get(3).getValue()) {
            return true;
        } else if (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(3).getValue() == cards.get(4).getValue()) {
            return true;
        } else if (cards.get(1).getValue() == cards.get(2).getValue() &&
                cards.get(3).getValue() == cards.get(4).getValue()) {
            return true;
        } else {
            return false;
        }
    }
    
    private static TwoPair getTwoPair (List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(2).getValue() == cards.get(3).getValue()) {
            return new TwoPair(new DoubleCard(cards.get(0), cards.get(1)), 
                    new DoubleCard(cards.get(2), cards.get(3)), 
                    cards.get(4));
        } else if (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(3).getValue() == cards.get(4).getValue()) {
            return new TwoPair(new DoubleCard(cards.get(0), cards.get(1)), 
                    new DoubleCard(cards.get(3), cards.get(4)), 
                    cards.get(2));
        } else {
            return new TwoPair(new DoubleCard(cards.get(1), cards.get(2)), 
                    new DoubleCard(cards.get(3), cards.get(4)), 
                    cards.get(0));
        }
    }
    
    private static boolean isPair (List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(1).getValue()) {
            return true;
        } else if (cards.get(1).getValue() == cards.get(2).getValue()) {
            return true;
        } else if (cards.get(2).getValue() == cards.get(3).getValue()) {
            return true;
        } else if (cards.get(3).getValue() == cards.get(4).getValue()) {
            return true;
        } else {
            return false;
        }
    }
    
    private static Pair getPair (List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(1).getValue()) {
            return new Pair(new DoubleCard(cards.get(0), cards.get(1)), 
                    cards.get(2), cards.get(3), cards.get(4));
        } else if (cards.get(1).getValue() == cards.get(2).getValue()) {
            return new Pair(new DoubleCard(cards.get(1), cards.get(2)), 
                    cards.get(0), cards.get(3), cards.get(4));
        } else if (cards.get(2).getValue() == cards.get(3).getValue()) {
            return new Pair(new DoubleCard(cards.get(2), cards.get(3)), 
                    cards.get(0), cards.get(1), cards.get(4));
        } else {
            return new Pair(new DoubleCard(cards.get(3), cards.get(4)), 
                    cards.get(0), cards.get(1), cards.get(2));
        }
    }
    
    private static HighCard getHighCard (List<Card> cards) {
        return new HighCard(cards);
    }
    
}
