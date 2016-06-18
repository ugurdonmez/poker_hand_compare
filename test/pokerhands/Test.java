/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands;

import java.util.Arrays;
import java.util.Scanner;
import pokerhands.hands.Hand;
import pokerhands.hands.HandFactory;

/**
 *
 * Input
The input file contains several lines, each containing the designation of ten cards: the first five cards are the hand for the player named “Black” and the next five cards are the hand for the player named “White”.
Output
For each line of input, print a line containing one of the following:
Black wins.
White wins.
Tie.
Sample Input
2H 3D 5S 9C KD 2C 3H 4S 8C AH
2H 4S 4C 2D 4H 2S 8S AS QS 3S
2H 3D 5S 9C KD 2C 3H 4S 8C KH
2H 3D 5S 9C KD 2D 3H 5C 9S KH
Sample Output
White wins.
Black wins.
Black wins.
Tie.
 * 
 * @author ugurdonmez
 */
public class Test {
    
    public static void main (String [] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String inputString = scanner.nextLine();
            String [] inputArray = inputString.split(" ");
            Hand hand1 = HandFactory.getHand(Arrays.copyOfRange(inputArray, 0, 5));
            Hand hand2 = HandFactory.getHand(Arrays.copyOfRange(inputArray, 5, 10));
            
            if (hand1.compareTo(hand2) > 0) {
                System.out.println("Black wins.");
            } else if (hand1.compareTo(hand2) < 0) {
                System.out.println("White wins.");
            } else {
                System.out.println("Tie.");
            }
        }
        
    }
    
}
