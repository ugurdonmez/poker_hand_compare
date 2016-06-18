/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.type;

/**
 *
 * @author ugurdonmez
 */
public enum Deck {
    
    CLUB(0), 
    DIAMOND(1),
    HEART(2),
    SPADE(3);
    
    public int code;
    
    Deck (int value) {
        this.code = value;
    }
    
    @Override
    public String toString() {
        if (this == CLUB) {
            return "CLUB";
        } else if (this == DIAMOND){
            return "DIAMOND";
        } else if (this == HEART) {
            return "HEART";
        } else if (this == SPADE) {
            return "SPADE";
        } else {
            return "UNDEFINED";
        }
    }
    
}
