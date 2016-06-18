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
public enum Value {
    
    TWO(0),
    THREE(1), 
    FOUR(2), 
    FIVE(3),
    SIX(4),
    SEVEN(5),
    EIGHT(6),
    NINE(7),
    TEN(8),
    JACK(9),
    QUEEN(10),
    KING(11),
    ACE(12);
    
    public int code;
    
    Value(int value) {
        this.code = value;
    }
    
    @Override
    public String toString() {
        if (this == TWO) {
            return "TWO";
        } else if (this == THREE) {
            return "THREE";
        } else if (this == FOUR) {
            return "FOUR";
        } else if (this == FIVE) {
            return "FIVE";
        } else if (this == SIX) {
            return "SIX";
        } else if (this == SEVEN) {
            return "SEVEN";
        } else if (this == EIGHT) {
            return "EIGHT";
        } else if (this == NINE) {
            return "NINE";
        } else if (this == TEN) {
            return "TEN";
        } else if (this == JACK) {
            return "JACK";
        } else if (this == QUEEN) {
            return "QUEEN";
        } else if (this == KING) {
            return "KING";
        } else if (this == ACE) {
            return "ACE";
        } else {
            return "UNDEFINED";
        }
    }
}
