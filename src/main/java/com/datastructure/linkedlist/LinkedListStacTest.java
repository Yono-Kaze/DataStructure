package com.datastructure.linkedlist;

/**
 * 
 *<p>Description:使用链表实现的栈<p>	
 * @author Administrator
 * @version 2020-10-24
 *
 */
public class LinkedListStacTest {
	
	public static void main(String[] args) {
		
		LinkedListStack<Integer> myLinkedList = new LinkedListStack<Integer>();
		for(int i = 0; i < 5; i++) {
			myLinkedList.push(i);
			System.out.println(myLinkedList);
		}
		System.out.println(myLinkedList.pop());
		System.out.println(myLinkedList);
		System.out.println(myLinkedList.peek());
	}

}
