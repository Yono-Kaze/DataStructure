package com.datastructure.stackandqueue.impl;

import com.datastructure.array.MyNewGenerics;
import com.datastructure.stackandqueue.InterfaceQueue;

/**
 * 
 *<p>Title:�Զ������<p>	
 *<p>Description:�Զ�̬����Ϊ�������嶯̬����<p>	
 * @author Administrator
 * @version 2020-10-14
 * @param <E>
 */
public class MyArrayQueue<E> implements InterfaceQueue<E> {
	
	private MyNewGenerics<E> queue;
	
	/**
	 * <p>����Ĭ�϶��д�СΪ10<p>
	 */
	public MyArrayQueue() {
		// TODO Auto-generated constructor stub
		this(10);
	}
	
	/**
	 * <p>�����û������С��������<p>
	 * @param capacity
	 */
	public MyArrayQueue(int capacity) {
		queue = new MyNewGenerics<E>(capacity);
	}
	
	/**
	 * <p>���ض���������<p>
	 * @return
	 */
	public int getCapacity() {
		// TODO Auto-generated method stub
		return queue.getCapacity();
	}

	/**
	 * <p>�Ӷ�β������Ԫ����ջ<p>
	 */
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		queue.addLast(e);
	}

	/**
	 * <p>������Ԫ�س�ջ�����س�ջԪ��<p>
	 * @return 
	 */
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return queue.removeFirst();
	}

	/**
	 * <p>�鿴����Ԫ��<p>
	 * @return
	 */
	@Override
	public E front() {
		// TODO Auto-generated method stub
		return queue.getFirst();
	}
	
	/**
	 * <p>���ض���Ԫ������<p>
	 * @return
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return queue.getSize();
	}

	/**
	 * <p>������Ϊ�շ���true���򷵻�false<p>
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
