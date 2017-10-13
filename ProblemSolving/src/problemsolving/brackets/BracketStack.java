/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving.brackets;

import java.util.LinkedList;

/**
 *
 * @author Jesus_Serrato
 */
public class BracketStack extends LinkedList<Character> {
    
    @Override
    public Character pop() {
        return removeFirst();
    }
    
    @Override
    public void push(Character character) {
        addFirst(character);
    }
    
}
