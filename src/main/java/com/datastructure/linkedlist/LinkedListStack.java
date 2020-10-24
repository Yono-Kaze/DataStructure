package com.datastructure.linkedlist;


import com.datastructure.stackandqueue.InterfaceStack;

public class LinkedListStack<E> implements InterfaceStack<E> {

	private MyLinkedList<E> list;
	
	public LinkedListStack() {
		list = new MyLinkedList<>();
	}
	
	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return list.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("Stack: top");
		res.append(list);
		return res.toString();
	}
	
	

}
