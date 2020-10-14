package com.datastructure.stackandqueue.impl;

import com.datastructure.stackandqueue.InterfaceQueue;

/**
 * 
 *<p>Title:ѭ�����е�ʵ��<p>	
 *<p>Description:������������������죬��Ҫ�ӵײ�������ʵ��ѭ������<p>	
 * @author Administrator
 * @version 2020-10-14
 *
 * @param <E>
 */
public class MyArrayLoopQueue<E> implements InterfaceQueue<E> {

	private E[] data;
	private int front,tail;
	private int size;//������Ԫ�ظ���

	/**
	 * <p>���ó�ʼ��СΪ10<p>
	 */
	public MyArrayLoopQueue() {
		// TODO Auto-generated constructor stub
		this(10);
	}

	/**
	 * <p>�����û������С����ѭ������<p>
	 * @param capacity
	 */
	public MyArrayLoopQueue(int capacity) {
		data = (E[]) new Object[capacity];
		front = 0;
		tail = 0;
		size = 0 ;
	}
	
	/**
	 *<p>����ѭ������������<p>
	 * @return 
	 */
	public int getCapacity() {
		return data.length - 1;
	}

	/**
	 * <p>����ѭ������Ԫ������<p>
	 * @return size
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * <p>ѭ������Ϊ�շ���true�����򷵻�false<p>
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == tail;
	}
	
	/**
	 * <p>Ԫ�شӶ�β���<p>
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
	 * <p>��������<p>
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
	 * <p>����Ԫ�س���,�����س���Ԫ��<p>
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
