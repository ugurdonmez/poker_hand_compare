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
public class TestTwoStraighFlush {

    public static void main (String [] args) {
        
        Hand hand1 = HandFactory.getHand("QH KH 10H JH AH");
        Hand hand2 = HandFactory.getHand("2H 3H 4H 6H 5H");
        Hand hand3 = HandFactory.getHand("2H 3H 4H 6H 5H");
        
        System.out.println(hand1.compareTo(hand2));
        System.out.println(hand2.compareTo(hand1));
        System.out.println(hand2.compareTo(hand3));
        
    }
    
}
