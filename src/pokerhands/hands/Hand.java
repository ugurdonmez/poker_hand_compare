/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerhands.hands;

/**
 *
 * @author ugurdonmez
 */
public abstract class Hand<N extends Hand> implements Comparable<N>{
    
    private final int level;

    Hand(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }    
}
