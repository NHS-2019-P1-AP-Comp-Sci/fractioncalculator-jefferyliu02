
package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	
    Scanner fractions = new Scanner(System.in);
    System.out.println("Enter Your Fraction Equation: ");
    String input = fractions.nextLine();
    
    while (!input.equals("quit")) {
    	System.out.println(produceAnswer(input));
    	System.out.println("Enter Your Fraction Equation: ");
    	input = fractions.nextLine();
    }
    fractions.close();
    }
        
    public static String produceAnswer(String input) {
    	
    	String math = input;
    	String fraction1 = math.substring(0, math.indexOf(' '));
    	math = math.substring(math.indexOf(' ') + 1);
    	String mathSymbol = math.substring(0, math.indexOf(' '));
    	math = math.substring(math.indexOf(' ') + 1);
    	String fraction2 = math;
    	
    	String whole2 = whole2(fraction2);
    	String numerator2 = numerator2(fraction2);
    	String denominator2 = denominator2(fraction2);
    	
    	String fractionsFor2 = "whole:" + whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;
    	
      
    return fractionsFor2;
    }
   
	public static String whole2(String input) {
    	if(input.contains("_")) {
    		return input.substring(0, input.indexOf('_'));
    	}
    	else if(input.contains("/")) {
    		return "0";
    	}
    	else return input;
    	}
   
    
    public static String numerator2(String input) {
    	if(input.contains("_")) {
    		return input.substring(input.indexOf('_') + 1, input.indexOf('/'));
    	}
    	else if(input.contains("/")) {
    		return input.substring(0, input.indexOf('/'));
    	}
    	else {
    		return "0";
    	}
    }
   
    public static String denominator2(String input) {
    	if(input.contains("_")) {
    		return input.substring(input.indexOf("/") + 1);
    	}
    	else if(input.contains("/")) {
    		return input.substring(input.indexOf('/') + 1);
    	}
    	else {
    		return "1";
    	}
    }
    }

 