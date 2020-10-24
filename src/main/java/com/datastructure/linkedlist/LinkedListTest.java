package com.datastructure.linkedlist;

/**
 * 
 *<p>Description:数据结构-链表接口<p>	
 * @author Administrator
 * @version 2020-10-17
 *
 */
public class LinkedListTest {
	
	public static void main(String[] args) {
			
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		for(int i = 0; i < 5; i++) {
			myLinkedList.addFirst(i);
			System.out.println(myLinkedList);
		}
		myLinkedList.add(2, 666);
		System.out.println(myLinkedList);
		myLinkedList.set(5, 30);
		System.out.println(myLinkedList);
		myLinkedList.remove(2);
		System.out.println(myLinkedList);
		myLinkedList.removeFirst();
		System.out.println(myLinkedList);
		myLinkedList.removeLast();
		System.out.println(myLinkedList);
	}
}
