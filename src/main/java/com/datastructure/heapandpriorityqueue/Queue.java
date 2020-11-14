package com.datastructure.heapandpriorityqueue;

/**
 * 
 *<p>Description:队列的接口<p>	
 * @author Administrator
 * @version 2020-11-11
 *
 * @param <E>
 */
public interface Queue<E> {
	
	void enqueue(E e);
	
	E dequeue();
	
	E getFront();
	
	int getSize();
	
	boolean isEmpty();

}
