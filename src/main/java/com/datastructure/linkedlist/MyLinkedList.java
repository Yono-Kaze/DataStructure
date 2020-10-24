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
		Node prev = dummyHead;
		for(int i = 0; i < index; i++) {
			prev = prev.next;
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

	/**
	 * 返回链表中第index个位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if(index < 0 || index > size) {throw new IllegalArgumentException("addIndex failed,index < 0 || index > size");}

		Node cur = dummyHead.next;
		for(int i = 0; i < index; i++) {cur = cur.next;}
		return cur.e;
	}

	/**
	 * 获得链表第一个元素
	 * @return
	 */
	public E getFirst() {
		return get(0);
	}

	/**
	 * 获得链表最后一个元素
	 * @return
	 */
	public E getLast() {
		return get(size - 1);
	}
	
	/**
	 * 更改链表中第index个位置的元素，以0为基础
	 * @param index
	 * @return
	 */
	public void set(int index,E e) {
		if(index < 0 || index > size) {throw new IllegalArgumentException("addIndex failed,index < 0 || index > size");}

		Node cur = dummyHead.next;
		for(int i = 0; i < index; i++) {cur = cur.next;}
		cur.e = e;
	}
	
	/**
	 * 查找链表中是否有元素e,存在返回true，否则返回false
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		while(cur != null) {
			if(cur.e.equals(e)) {return true;}
			cur = cur.next;
		}
		return false;
	}
	
	/**
	 * 删除链表中第index位置的元素，返回删除元素
	 * @return
	 */
	public E remove(int index) {
		if(index < 0 || index > size) {throw new IllegalArgumentException("addIndex failed,index < 0 || index > size");}
		
		Node prev = dummyHead;
		for(int i = 0; i < index; i++) {prev =prev.next;}
		
		Node detNode = prev.next;
		prev.next = detNode.next;
		detNode.next = null;
		size--;
		
		return detNode.e;
	}
	
	/**
	 * 删除链表第一个元素
	 * @return
	 */
	public E removeFirst() {
		return remove(0);
	}
	
	/**
	 * 删除链表最后一个元素
	 * @return
	 */
	public E removeLast() {
		return remove(size - 1);
	}

	@Override
	public String toString() {
		
		StringBuffer res = new StringBuffer();
		Node cur = dummyHead.next;
		while(cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
	
	
	
}
