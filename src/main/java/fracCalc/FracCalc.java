
package fracCalc;

import java.util.Scanner;

public class FracCalc {

	private static int whole1;
	private static int numerator1;
	private static int denominator1;

	private static int whole2;
	private static int numerator2;
	private static int denominator2;	
	
	// private static int whole3;
	private static int numerator3;
	private static int denominator3;
    public static void main(String[] args) {
    	
    Scanner fractions = new Scanner(System.in);
    System.out.println("Enter Your Fraction Equation: ");
    String input = fractions.nextLine();
    
    while (!input.equals("quit")) {
    	char operator = findOperator(input);
   
    	if (operator == ' ')
    	{
    		System.out.println("Invalid expression!");
        	System.out.println("Enter Your Fraction Equation: ");  
        	input = fractions.nextLine();
    		continue;
    	}
    	int opIndex = input.indexOf(operator);
    	
    	String operand1 = produceAnswer(input.substring(0, opIndex-1), true);
    	String operand2 = produceAnswer(input.substring(opIndex+1), false);
    	//System.out.println(operand1);
    	//System.out.println(operand2);
    	String result = calculate(operator);
    	System.out.println("Result = " + result);
    	System.out.println("Enter Your Fraction Equation: ");
    	input = fractions.nextLine();
    }
    fractions.close();
    
    }

    public static char findOperator(String input)
    {
    	int opIndex = input.indexOf('+');
    	if (opIndex >= 0)
    	{
    		return '+';
    	}
    	opIndex = input.indexOf('-');
    	if (opIndex >= 0)
    	{
    		return '-';
    	}   
    	opIndex = input.indexOf('*');
    	if (opIndex >= 0)
    	{
    		return '*';
    	}
    	opIndex = input.indexOf(" /");
    	if (opIndex >= 0)
    	{
    		return '/';
    	}	
    	return ' ';
    }
    public static String produceAnswer(String input, Boolean isFirst) {
    	String math = input;
    	
    	String fraction = math;
    	String whole = whole1(fraction);
    	String numerator = numerator1(fraction);
    	String denominator = denominator1(fraction);
    	if (isFirst)
    	{
    		whole1 = Integer.parseInt(whole.trim());
    		numerator1 = Integer.parseInt(numerator.trim());	
    		denominator1 = Integer.parseInt(denominator.trim());	
    	}
    	else
    	{
    		whole2 = Integer.parseInt(whole.trim());
    		numerator2 = Integer.parseInt(numerator.trim());	
    		denominator2 = Integer.parseInt(denominator.trim());    		
    	}
    	String fractionAnswer = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
      
    return fractionAnswer;
    }
    

    
    public static String whole1(String input) {
    	if(input.contains("_")) {
    		return input.substring(0, input.indexOf('_'));
    	}
    	else if(input.contains("/")) {
    		return "0";
    	}
    	else return input;
    	}
   
    
    public static String numerator1(String input) {
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
   
    public static String denominator1(String input) {
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
    public static String calculate(char operator) {
    	int n1 = whole1 * denominator1 + numerator1;
    	int n2 = whole2 * denominator2 + numerator2;
    	
    	if(operator == '+') {
    		numerator3 = (n1 * denominator2) + (n2 * denominator1);
    		denominator3 = (denominator1 * denominator2);
    	}
    	else if(operator == '-') {
    		numerator3 = (n1 * denominator2) - (n2 * denominator1);
    		denominator3 = (denominator1 * denominator2);
    	}
    
    	else if(operator == '*') {
    		numerator3 = (n1 * n2);
    		denominator3 = (denominator1 * denominator2);
    	}
    	else if(operator == '/') {
    		numerator3 = (n1 * denominator2);
    		denominator3 = (n2 * denominator1);
    	}
    	else {
    		return "Expression has invalid operator";
    	}
    	return numerator3 + "/" + denominator3;
    }
   
}

 