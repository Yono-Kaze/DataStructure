package com.datastructure.stackandqueue.impl;

import com.datastructure.array.MyNewGenerics;
import com.datastructure.stackandqueue.InterfaceStack;

/**
 * 
 *<p>Title:�Զ���ջ<p>	
 *<p>Description:�Զ�̬��������Ϊ�������嶯̬����ջ<p>	
 * @author Administrator
 * @version 2020-10-13
 *
 */
public class MyArrayStack<E> implements InterfaceStack<E> {
	
	private MyNewGenerics<E> stack;
	
	/**
	 * <p>����Ĭ��ջ��СΪ10<p>
	 */
	public MyArrayStack() {
		this(10);
	}
	
	/**
	 * <p>�����û������С����ջ<p>
	 * @param capacity
	 */
	public MyArrayStack(int capacity) {
		stack = new MyNewGenerics<E>(capacity);
	}
	
	/**
	 * <p>����ջ��������<p>
	 * @return
	 */
	public int getCapacity() {
		return stack.getCapacity();
	}
	
	/**
	 * <p>��ջ����<p>
	 * @param e
	 */
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		stack.addLast(e);
	}

	/**
	 * <p>��ջ�����������س�ջԪ��<p>
	 * @return 
	 */
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return stack.removeLast();
	}

	/**
	 * <p>�鿴ջ��Ԫ��<p>
	 */
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return stack.getLast();
	}

	/**
	 * <p>�ж�ջ�Ƿ�Ϊ�գ���Ϊ�շ���true�����򷵻�false<p>
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack.isEmpty();
	}

	/**
	 * <p>����ջ��Ԫ������<p>
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
