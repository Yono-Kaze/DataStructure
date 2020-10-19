package com.datastructure.stackandqueue.impl;

import com.datastructure.stackandqueue.InterfaceQueue;

/**
 * 
 *<p>Title:循环队列的实现<p>	
 *<p>Description:因操作与数组有所差异，需要从底部重新来实现循环队列<p>	
 * @author Administrator
 * @version 2020-10-14
 *
 * @param <E>
 */
public class MyArrayLoopQueue<E> implements InterfaceQueue<E> {

	private E[] data;
	private int front,tail;
	private int size;//数组中元素个数

	/**
	 * <p>设置初始大小为10<p>
	 */
	public MyArrayLoopQueue() {
		// TODO Auto-generated constructor stub
		this(10);
	}

	/**
	 * <p>根据用户输入大小创建循环队列<p>
	 * @param capacity
	 */
	public MyArrayLoopQueue(int capacity) {
		data = (E[]) new Object[capacity];
		front = 0;
		tail = 0;
		size = 0 ;
	}
	
	/**
	 *<p>返回循环队列总容量<p>
	 * @return 
	 */
	public int getCapacity() {
		return data.length - 1;
	}

	/**
	 * <p>返回循环队列元素数量<p>
	 * @return size
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * <p>循环队列为空返回true，否则返回false<p>
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == tail;
	}
	
	/**
	 * <p>元素从队尾入队<p>
	 */
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		if((tail + 1) % data.length == front) {reCapacity(getCapacity() * 2);}
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size ++;

	}

	/**
	 * <p>扩充容量<p>
	 * @param i
	 */
	private void reCapacity(int capacity) {
		// TODO Auto-generated method stub
		E[] newData = (E[]) new Object[capacity + 1];
		for(int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	/**
	 * <p>队首元素出队,并返回出队元素<p>
	 * @return e
	 */
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) {throw new IllegalArgumentException("dequeue failed, queue is empty");}
		E e = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size --;	
		if(size < data.length / 4) {reCapacity(data.length / 2);}
		return e;
	}

	@Override
	public E front() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(String.format("Stack: capacity = %d size = %d\n", data.length - 1, size));
		res.append("front [");
		for(int i = front; i != tail; i = (i + 1) % data.length ) {
			res.append(data[i]);
			if(i != tail) {res.append(',');}
		}
		res.append("] tail");
		return res.toString();
	}
	

}
