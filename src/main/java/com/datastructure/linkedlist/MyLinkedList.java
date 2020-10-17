package com.datastructure.linkedlist;

/**
 * 
 *<p>Description:�Զ�������<p>	
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

	private int size;//������Ԫ�ظ���
	private Node dummyHead;//����ͷ���

	public MyLinkedList() {
		dummyHead = new Node(null,null);
		size = 0;
	}

	/**
	 * <p>����������Ԫ�ظ���<p>
	 * @return 
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <p>����Ϊ�շ���true�����򷵻�false<p>
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * <p>������ͷ�����һ��Ԫ��<p>
	 */
	public void addFirst(E e) {
		//		Node node = new Node(e);
		//		node.next = head;
		//		head = node;
		add(0, e);

	}

	/**
	 * <p>���ض�index����0��ʼ��λ�����Ԫ��e<p>
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
	 * <p>������β�����һ��Ԫ��<p>
	 */
	public void addLast(E e) {
		add(size, e);
	}


}
