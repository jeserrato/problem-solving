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
public class BracketsAnalyzer {
    
    private final BracketStack stack;

    public BracketsAnalyzer() {
        stack = new BracketStack();
    }
    
    public boolean isSyntacticallyCorrect(String stringToAnalyze) throws Exception {
        if (stringToAnalyze == null || stringToAnalyze.length() <= 1)
            return false;
        
        for (char character: stringToAnalyze.toCharArray()) {
            switch (character) {
                case '{':
                case '[':
                case '(':
                    stack.push((char) character);
                    
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty())
                        return false;
                    
                    char openBracket = stack.pop();
                    char closeBracket = mapOpenBracketToCloseBracket(openBracket);
                    
                    if (closeBracket != character)
                        return false;

                    break;
                default: 
                    throw new Exception("Invalid characters");
            }
        }
        
        //If the stack is not empty then the string is not symmetric        
        return stack.isEmpty();
    }
    
    private char mapOpenBracketToCloseBracket(char openBracket) throws Exception {
        switch (openBracket) {
            case '{':
                return '}';
            case '[':
                return ']';
            case '(':
                return ')';
            default:
                throw new Exception("Invalid character");
        }
    }
    
}

//    public void generateSyncaticReport(String stringToAnalyze) {
//        stringToAnalyze.chars().forEach(
//            character -> {                                        
//                switch (character) {
//                    case '{':
//                    case '[':
//                    case '(':
//                        stack.push((char) character);
//                        break;
//                    case ')':
//                    case ']':
//                    case '}':
//                        if (character != stack.pop()) {
//
//                        }
//
//                        break;
//                    default: 
//                        //throw exception
//                }
//            }
//        );
//    }
   
