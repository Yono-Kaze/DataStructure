package com.datastructure.stackandqueue;

/**
 * 
 *<p>Title:����ջ�Ľӿ�<p>	
 *<p>Description:�Զ��巺��ջ�Ľӿڲ���<p>	
 * @author Administrator
 * @version 2020-10-13
 *
 */
public interface InterfaceStack<E> {
	
	/**
	 * <p>Description:��ջ<p>	
	 */
	void push(E e);

	/**
	 * <p>Description:��ջ<p>	
	 */
	E pop();

	/**
	 * <p>Description:�鿴ջ��Ԫ��<p>	
	 */
	E peek();

	/**.
	 * <p>Description:�鿴ջ�Ƿ�Ϊ��<p>	
	 */
	boolean isEmpty();

	/**
	 * <p>Description:�鿴ջԪ������<p>	
	 */
	int getSize();
	
}
