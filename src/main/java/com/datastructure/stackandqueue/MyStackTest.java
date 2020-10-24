package com.datastructure.stackandqueue;

import com.datastructure.stackandqueue.impl.MyArrayStack;
import com.datastructure.unit.Student;

/**
 * 
 *<p>Title:数据结构-栈部分<p>	
 *<p>Description:栈的测试<p>	
 * @author Administrator
 * @version 2020-10-13
 *
 */
public class MyStackTest {
	
	public static void main(String[] args) {
		
		MyArrayStack<Integer> stack = new MyArrayStack<Integer>();
		for(int i = 0; i < 6; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		System.out.println(stack.getSize());
		
		System.out.println("----------------------------------------------------------------------------");
		
		MyArrayStack<Student> stackStudent = new MyArrayStack<Student>(10);
		for(int i = 0; i < 6; i++) {
			stackStudent.push(new Student(i, String.valueOf(i), (Math.random() > 0.5 ? true : false)));
		}
		System.out.println(stackStudent);
		System.out.println(stackStudent.pop());
		System.out.println(stackStudent);
	}

}
