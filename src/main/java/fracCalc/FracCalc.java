
package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Your Fraction: ");
    String userInput = s.nextLine();
    
    System.out.println(produceAnswer(userInput));
    
    }
        // TODO: Read the input from the user and call produceAnswer with an equation
    
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
    	Scanner s = new Scanner(input);
    	String fraction1 = s.next();
    	String operator = s.next();
    	String fraction2 = s.next();
    	
    	return fraction2;
       }
    
}

    // TODO: Fill in the space below with any helper methods that you think you will need


