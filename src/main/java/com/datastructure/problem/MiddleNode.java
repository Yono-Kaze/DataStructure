package com.datastructure.problem;

/**
 * <p>Description:Middle of the Linked List <p>
 * Given a non-empty, singly linked list with head node head, return a middle
 * node of linked list.
 * If there are two middle nodes, return the second middle node.
 * The number of nodes in the given list will be between 1 and 100.
 * @author Administrator
 * @version 2020-11-9
 *
 */
public class MiddleNode {
	public static ListNode middleNode(ListNode head) {

		ListNode cur = head;
		int size = 0;	
		
		while (cur != null) {
			size++;
			cur = cur.next;
		}
		
		int minddle = size / 2 ;
		
		for (int i = 0; i < minddle; i++) {
			head = head.next;
		}
		return head;
	}

}
