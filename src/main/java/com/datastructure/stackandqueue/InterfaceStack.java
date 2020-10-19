package com.datastructure.stackandqueue;

/**
 * 
 *<p>Title:泛型栈的接口<p>	
 *<p>Description:自定义泛型栈的接口部分<p>	
 * @author Administrator
 * @version 2020-10-13
 *
 */
public interface InterfaceStack<E> {
	
	
	/**
	 * <p>Description:入栈<p>	
	 */
	void push(E e);

	/**
	 * <p>Description:出栈<p>	
	 */
	E pop();

	/**
	 * <p>Description:查看栈顶元素<p>	
	 */
	E peek();

	/**.
	 * <p>Description:查看栈是否为空<p>	
	 */
	boolean isEmpty();

	/**
	 * <p>Description:查看栈元素数量<p>	
	 */
	int getSize();
	
}
