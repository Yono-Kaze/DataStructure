package com.datastructure.stackandqueue;

/**
 * 
 *<p>Title:���еĽӿ�<p>	
 *<p>Description:�Զ�����еĽӿڲ���<p>	
 * @author Administrator
 * @version 2020-10-14
 *
 */
public interface InterfaceQueue<E> {
	
	void enqueue(E e);
	
	E dequeue();
	
	E front();
	
	int getSize();
	
	boolean isEmpty();

}
