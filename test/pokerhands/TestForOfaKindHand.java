/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands;

import pokerhands.hands.Hand;
import pokerhands.hands.HandFactory;

/**
 *
 * @author ugurdonmez
 */
public class TestForOfaKindHand {
    
    public static void main (String [] args) {
        
        Hand hand1 = HandFactory.getHand("QH KH 10H JH AH");
        Hand hand2 = HandFactory.getHand("2C 2H 2S 2D 5H");
        Hand hand3 = HandFactory.getHand("7C 7H 7S 7D 5H");
        
        System.out.println(hand1.compareTo(hand2));
        System.out.println(hand2.compareTo(hand1));
        System.out.println(hand2.compareTo(hand3));
        System.out.println(hand3.compareTo(hand2));
        
    }
    
}
