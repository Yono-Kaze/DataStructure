package com.datastructure.stackandqueue.impl;

import com.datastructure.array.MyNewGenerics;
import com.datastructure.stackandqueue.InterfaceStack;

/**
 * 
 *<p>Title:自定义栈<p>	
 *<p>Description:以动态泛型数组为基础定义动态泛型栈<p>	
 * @author Administrator
 * @version 2020-10-13
 *
 */
public class MyArrayStack<E> implements InterfaceStack<E> {
	
	private MyNewGenerics<E> stack;
	
	/**
	 * <p>设置默认栈大小为10<p>
	 */
	public MyArrayStack() {
		this(10);
	}
	
	/**
	 * <p>根据用户输入大小创建栈<p>
	 * @param capacity
	 */
	public MyArrayStack(int capacity) {
		stack = new MyNewGenerics<E>(capacity);
	}
	
	/**
	 * <p>返回栈的总容量<p>
	 * @return
	 */
	public int getCapacity() {
		return stack.getCapacity();
	}
	
	/**
	 * <p>入栈操作<p>
	 * @param e
	 */
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		stack.addLast(e);
	}

	/**
	 * <p>出栈操作，并返回出栈元素<p>
	 * @return 
	 */
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return stack.removeLast();
	}

	/**
	 * <p>查看栈顶元素<p>
	 */
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return stack.getLast();
	}

	/**
	 * <p>判断栈是否为空，若为空返回true，否则返回false<p>
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack.isEmpty();
	}

	/**
	 * <p>返回栈的元素数量<p>
	 * @return
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return stack.getSize();
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(String.format("Stack capacity = %d\n", stack.getCapacity()));
		res.append('[');
		for(int i = 0; i < stack.getSize(); i++) {
			res.append(stack.get(i));
			if(i != stack.getSize() - 1) {res.append(',');}
		}
		res.append(']');
		res.append(" top");
		return res.toString();
	}
	
	

}
