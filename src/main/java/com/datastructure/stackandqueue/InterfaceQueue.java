package com.datastructure.stackandqueue;

/**
 * 
 *<p>Title:队列的接口<p>	
 *<p>Description:自定义队列的接口部分<p>	
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
