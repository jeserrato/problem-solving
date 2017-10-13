/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving.brackets;

/**
 *
 * @author Jesus_Serrato
 */
public class Brackets {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String s = "{{{{{{{{{}}}}}}";
        boolean result = new BracketsAnalyzer().isSyntacticallyCorrect(s);
        System.out.println(s + " is syncatically " + (result ? "correct" : "incorrect"));
        
        s = "{[()]}";
        result = new BracketsAnalyzer().isSyntacticallyCorrect(s);
        System.out.println(s + " is syncatically " + (result ? "correct" : "incorrect"));
        
        s = "{()[]}{{{()}}}()[{}()]";
        result = new BracketsAnalyzer().isSyntacticallyCorrect(s);
        System.out.println(s + " is syncatically " + (result ? "correct" : "incorrect"));
        
        s = "{]";
        result = new BracketsAnalyzer().isSyntacticallyCorrect(s);
        System.out.println(s + " is syncatically " + (result ? "correct" : "incorrect"));
        
        s = "({]})";
        result = new BracketsAnalyzer().isSyntacticallyCorrect(s);
        System.out.println(s + " is syncatically " + (result ? "correct" : "incorrect"));
        
        s = ")";
        result = new BracketsAnalyzer().isSyntacticallyCorrect(s);
        System.out.println(s + " is syncatically " + (result ? "correct" : "incorrect"));
        
        s = null;
        result = new BracketsAnalyzer().isSyntacticallyCorrect(s);
        System.out.println(s + " is syncatically " + (result ? "correct" : "incorrect"));
        
        s = ")))))))(";
        result = new BracketsAnalyzer().isSyntacticallyCorrect(s);
        System.out.println(s + " is syncatically " + (result ? "correct" : "incorrect"));
    
        s = "()))))))(";
        result = new BracketsAnalyzer().isSyntacticallyCorrect(s);
        System.out.println(s + " is syncatically " + (result ? "correct" : "incorrect"));
    }
    
}
