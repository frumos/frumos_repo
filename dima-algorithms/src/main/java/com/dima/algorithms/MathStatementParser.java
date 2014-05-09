package com.dima.algorithms;

import java.util.Stack;

/**
 * 
 * 
 * @author kovtdm
 *
 */
public class MathStatementParser {
	
	
	private Stack<Character> operations = new Stack<Character>();
	
	private Stack<Double> operands = new Stack<Double>();
	
	private char leftBraket = '(';
	
	private char rightBraket = ')';
	
	private char plusOperation = '+';	
	private char minusOperation = '-';
	private char multOperation = '*';
	private char divOperation = '/';
	
	
	public double computeStatement(String statement) {
		for(char ch:  statement.toCharArray()) {			
			if( ch == plusOperation || 
				ch == minusOperation ||
				ch == multOperation ||
				ch == divOperation) {
				operations.push(ch);
			} else if (Character.isDigit(ch)) {
				operands.push(Double.parseDouble("" + ch));
			} else if(ch == rightBraket) {
				double rightOperand = operands.pop();
				double leftOperand = operands.pop();
				double result = 0.0;
				char operation = operations.pop();
				if(operation == plusOperation) {
					result = leftOperand + rightOperand;
				} else if(operation == minusOperation) {
					result = leftOperand - rightOperand;
				} else if(operation == multOperation) {
					result = leftOperand * rightOperand;
				} else if(operation == divOperation) {
					result = leftOperand / rightOperand;
				}
				operands.push(result);
			}
		}		
		return operands.pop();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String statement = "(2+(10+3)*(3+2))";
		MathStatementParser computer = new MathStatementParser();
		System.out.println(computer.computeStatement(statement));
	}

}
