package com.datastructure.linkedlist;

import com.datastructure.stackandqueue.InterfaceQueue;
import com.datastructure.stackandqueue.impl.MyArrayQueue;

/**
 * 
 *<p>Description:使用链表实现队列<p>	
 * @author Administrator
 * @version 2020-10-24
 *
 */
public class LinkedListQueue<E> implements InterfaceQueue<E> {

	private class Node{
		public E e;
		public Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this.e = e;
			this.next = null;
		}

		public Node() {
			this.e = null;
			this.next = null;
		}

		@Override
		public String toString() {
			return e.toString();
		}

	}

	private Node head, tail;
	private int size;

	@Override
	public void enqueue(E e) {
		if(tail == null) {
			tail = new Node(e);
			head = tail;
		}else {
			tail.next = new Node(e);
			tail = tail.next;
		}
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()) {throw new IllegalArgumentException("dequeue failed, is Empty");}

		Node retNode = head;
		head = head.next;
		if(head == null) {tail = null;}
		size--;
		return retNode.e;
	}

	@Override
	public E front() {
		if(isEmpty()) {throw new IllegalArgumentException("dequeue failed, is Empty");}
		return head.e;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {

		StringBuffer res = new StringBuffer();
		res.append("Queue: front ");
		Node cur = head;
		while(cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("NULL tail");
		return res.toString();
	}

	public static void main(String[] args) {
		
		LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
		for(int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < 5; i++) {
			if(i % 2 == 0) {
				queue.dequeue();
			}
			System.out.println(queue);
		}
	}
}
