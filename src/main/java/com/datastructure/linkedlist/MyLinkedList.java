package com.datastructure.linkedlist;

/**
 * 
 *<p>Description:数据结构-链表部分<p>	
 * @author Administrator
 * @version 2020-10-17
 *
 */
public class MyLinkedList<E> {

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

	private int size;//链表中元素
	private Node dummyHead;//虚拟头结点

	public MyLinkedList() {
		dummyHead = new Node(null,null);
		size = 0;
	}

	/**
	 * <p>返回链表元素个数<p>
	 * @return 
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <p>判断是否为空，空返回true，否则false<p>
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * <p>向链表头位置添加元素<p>
	 */
	public void addFirst(E e) {
		//		Node node = new Node(e);
		//		node.next = head;
		//		head = node;
		add(0, e);

	}

	/**
	 * <p>按用户输入位置添加元素，以0为开始<p>
	 * @param index
	 * @param e
	 */
	public void add(int index,E e) {

		if(index < 0 || index > size) {throw new IllegalArgumentException("addIndex failed,index < 0 || index > size");}
		if(index == 0) {addFirst(e);}
		
		Node prev = dummyHead;
		for(int i = 0; i < index; i++) {
			prev = dummyHead.next;
		}
		//			Node node = new Node(e);
		//			node.next = prev.next;
		//			prev.next = node;
		prev.next = new Node(e,prev.next);
		size ++;

	}
	
	/**
	 * <p>在链表尾添加元素<p>
	 */
	public void addLast(E e) {
		add(size, e);
	}


}
