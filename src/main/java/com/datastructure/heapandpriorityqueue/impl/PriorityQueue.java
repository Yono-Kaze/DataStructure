package com.datastructure.heapandpriorityqueue.impl;

import com.datastructure.heapandpriorityqueue.MaxHeap;
import com.datastructure.heapandpriorityqueue.Queue;

/**
 * 
 *<p>Description:优先队列(底层为最大堆)<p>	
 * @author Administrator
 * @version 2020-11-13
 *
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	
	private MaxHeap<E> maxHeap;
	
	public PriorityQueue() {
		maxHeap = new MaxHeap<E>();
	}

	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
	}

	@Override
	public E dequeue() {
		return maxHeap.extractMax();
	}

	@Override
	public E getFront() {
		return maxHeap.findMax();
	}

	@Override
	public int getSize() {
		return maxHeap.size();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

}
