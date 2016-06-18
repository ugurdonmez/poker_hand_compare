/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands;

import pokerhands.hands.HandFactory;

/**
 *
 * @author ugurdonmez
 */
public class TestHandFactory {
    
    public static void main (String [] args) {
        
        HandFactory.getHand("2H 3D 5S 9C KD");
        
        System.out.println();
        
        HandFactory.getHand("2C 3H 4S 8C AH");
        
        System.out.println();
        
        HandFactory.getHand("2H 3H 4H 8H AH");
        
        System.out.println();
        
        HandFactory.getHand("2H 3H 4H 6H 5H");
        
        System.out.println();
        
        HandFactory.getHand("QH KH 10H JH AH");
        
        System.out.println();
        
    }
    
}
