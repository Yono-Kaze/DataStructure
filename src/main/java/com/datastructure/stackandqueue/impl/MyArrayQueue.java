package com.datastructure.stackandqueue.impl;

import com.datastructure.array.MyNewGenerics;
import com.datastructure.stackandqueue.InterfaceQueue;

/**
 * 
 *<p>Title:自定义队列<p>	
 *<p>Description:以动态数组为基础定义动态队列<p>	
 * @author Administrator
 * @version 2020-10-14
 * @param <E>
 */
public class MyArrayQueue<E> implements InterfaceQueue<E> {
	
	private MyNewGenerics<E> queue;
	
	/**
	 * <p>设置默认队列大小为10<p>
	 */
	public MyArrayQueue() {
		// TODO Auto-generated constructor stub
		this(10);
	}
	
	/**
	 * <p>根据用户输入大小创建队列<p>
	 * @param capacity
	 */
	public MyArrayQueue(int capacity) {
		queue = new MyNewGenerics<E>(capacity);
	}
	
	/**
	 * <p>返回队列总容量<p>
	 * @return
	 */
	public int getCapacity() {
		// TODO Auto-generated method stub
		return queue.getCapacity();
	}

	/**
	 * <p>从队尾将输入元素入栈<p>
	 */
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		queue.addLast(e);
	}

	/**
	 * <p>将队首元素出栈，返回出栈元素<p>
	 * @return 
	 */
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return queue.removeFirst();
	}

	/**
	 * <p>查看队首元素<p>
	 * @return
	 */
	@Override
	public E front() {
		// TODO Auto-generated method stub
		return queue.getFirst();
	}
	
	/**
	 * <p>返回队列元素数量<p>
	 * @return
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return queue.getSize();
	}

	/**
	 * <p>若队列为空返回true否则返回false<p>
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append(String.format("Stack capacity = %d, size = %d", queue.getCapacity(),queue.getSize()));
		res.append(" front ");
		res.append('[');
		for(int i = 0; i < queue.getSize(); i++) {
			res.append(queue.get(i));
			if(i != queue.getSize() - 1) {res.append(',');}
		}
		res.append(']');
		res.append(" tail");
		return res.toString();
	}
	
	

}
