// Author: Jeffery Liu
package fracCalc;

import java.util.Scanner;
import java.lang.Math;

public class FracCalc { // sets variables
	private static int sign1;
	private static int whole1;
	private static int numerator1;
	private static int denominator1;

	private static int sign2;
	private static int whole2;
	private static int numerator2;
	private static int denominator2;	
	
	//private static int whole3;
	private static int numerator3;
	private static int denominator3;
	
    public static void main(String[] args) {
    	
    Scanner fractions = new Scanner(System.in); //Takes user input with ability to quit program
    System.out.println("Enter Your Fraction Equation: ");
    String input = fractions.nextLine();
    
    while (!input.equals("quit")) {
    	String result = produceAnswer(input);
   
    	if (result.isEmpty())
    	{
    		System.out.println("Invalid expression!");
        	System.out.println("Enter Your Fraction Equation: ");  
        	input = fractions.nextLine();
    		continue;
    	}
   	
    	System.out.println("Result = " + result);
    	System.out.println("Enter Your Fraction Equation: ");
    	input = fractions.nextLine();
    }
    fractions.close();
    
    }

    
    public static String produceAnswer(String input) // Parses through user input to find num, denom, op
    {                                                // Performs arithmetic on isolated numerator, denominator
    	char operator = findOperator(input);
    	   
    	if (operator == ' ')
    	{
    		return "";
    	}
    	int opIndex = input.indexOf(" " + operator + " ");
    	
    	setOperand(input.substring(0, opIndex), true);
    	setOperand(input.substring(opIndex+3), false);
    	return calculate(operator);    	
    }
    
    public static char findOperator(String input)
    {
    	int opIndex = input.indexOf(" + ");
    	if (opIndex > 0)
    	{
    		return '+';
    	}
    	opIndex = input.indexOf(" - ");
    	if (opIndex > 0)
    	{
    		return '-';
    	}   
    	opIndex = input.indexOf(" * ");
    	if (opIndex >= 0)
    	{
    		return '*';
    	}
    	opIndex = input.indexOf(" / ");
    	if (opIndex >= 0)
    	{
    		return '/';
    	}	
    	return ' ';
    }
    
    public static String setOperand(String operand, Boolean isFirst) {
   	
    	System.out.println("operand = " + operand);
    	int sign = 1;
    	if (operand.startsWith("-"))
    	{
    		sign = -1;
    		operand = operand.substring(1);
    	}
    	String whole = whole1(operand);
    	String numerator = numerator1(operand);
    	String denominator = denominator1(operand);
    	System.out.println("Sign:" +  sign + " whole:" + whole + " numerator:" + numerator + " denominator:" + denominator);    	
    	if (isFirst)
    	{
    		sign1 = sign;
    		whole1 = Integer.parseInt(whole.trim());
    		numerator1 = Integer.parseInt(numerator.trim());	
    		denominator1 = Integer.parseInt(denominator.trim());	
    	}
    	else
    	{
    		sign2 = sign;
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
    	else 
    		return input;
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
    	int n1 = sign1 * (whole1 * denominator1 + numerator1);
    	int n2 = sign2 * (whole2 * denominator2 + numerator2);
    	
    	if(operator == '+') {
    		numerator3 = (n1 * denominator2) + (n2 * denominator1);
    		denominator3 = (denominator1 * denominator2);
    		//System.out.println("numerator3 = " + numerator3 + "denominator3=" + denominator3); // use for troubleshooting
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
    		if (numerator3 < 0 && denominator3 < 0)
    		{
    			numerator3 = Math.abs(numerator3);
    			denominator3 = Math.abs(denominator3);	
    		}
    		else if (numerator3 > 0 && denominator3 < 0)
    		{
    			numerator3 = -1 *numerator3;
    			denominator3 = Math.abs(denominator3);	    			
    		}
    	}
    	else {
    		return "Expression has invalid operator";
    	}
    	// turns fraction into reduced format
    	int i = 2;
    	while(i <= Math.min(Math.abs(numerator3), Math.abs(denominator3))) {
    		if((numerator3 % i == 0 && denominator3 % i == 0)) {
    			numerator3 = numerator3 / i;
    			denominator3 = denominator3 /i;
    			i = 2;
    		}
    		else {
    			i++;
    		}
    	}
    	if(numerator3 == denominator3) { // turns answer back into mixed number or other proper format
    		return "1";
    	}
    	else if(numerator3 == 0) {
    		return "0";
    	}
    	else if(Math.abs(numerator3) > Math.abs(denominator3)) {
    		if (numerator3 % denominator3 == 0)
    		{
    			return "" + numerator3 / denominator3;
    		}
    		else if (numerator3 / denominator3 < 0)
    		{
    			return (numerator3 / denominator3) + "_" + -1*(numerator3 % denominator3) + "/" + denominator3;
    		}
    		else
    		{
    			return (numerator3 / denominator3) + "_" + (numerator3 % denominator3) + "/" + denominator3;   			
    		}
    	} 
    	else if(Math.abs(numerator3) < Math.abs(denominator3)) {
    		return numerator3 + "/" + denominator3;
    	}
    	return "";
    }
}
    



 