package com.datastructure.stackandqueue;

import java.util.Stack;

import com.datastructure.stackandqueue.impl.MyArrayStack;

/**
 * 
 *<p>Title:¿®∫≈∆•≈‰<p>	
 * @author Administrator
 * @version 2020-10-13
 *
 */
/*
Given a string s containing just the 
characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
1.Open brackets must be closed by the same type of brackets.
2.Open brackets must be closed in the correct order.
 */
public class ValidParentheses {

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();

		for(char ch : s.toCharArray()) {
			if(ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}else {
				if(stack.isEmpty()) {return false;}
				char topChar = stack.peek();
				if(ch == ')' && topChar == '(') {stack.pop();}
				else if(ch == '}' && topChar == '{') {stack.pop();}
				else if(ch == ']' && topChar == '[') {stack.pop();}
				else {stack.push(ch);}
			}
		}
		return stack.isEmpty();
	}
	
	public boolean isMyValid(String s) {

		MyArrayStack<Character> stack = new MyArrayStack<Character>();

		for(char ch : s.toCharArray()) {
			if(ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}else {
				if(stack.isEmpty()) {return false;}
				char topChar = stack.pop();
				if(ch == ')' && topChar != '(') {return false;}
				else if(ch == '}' && topChar != '{') {return false;}
				else if(ch == ']' && topChar != '[') {return false;}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "{([{}])}";
		String s1 = "(){}[]}";
		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.isValid(s));
		System.out.println(validParentheses.isValid(s1));
		
		System.out.println("------------------------------------------");
		
		ValidParentheses validMyParentheses = new ValidParentheses();
		System.out.println(validMyParentheses.isMyValid(s));
		System.out.println(validMyParentheses.isMyValid(s1));
	}

}
