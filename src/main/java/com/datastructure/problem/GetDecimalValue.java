package com.datastructure.problem;
/**
 * 
 *<p>Convert Binary Number in a Linked List to Integer<p>
 *Given head which is a reference node to a singly-linked list. 
 *The value of each node in the linked list is either 0 or 1. 
 *The linked list holds the binary representation of a number.
 *Return the decimal value of the number in the linked list.
 * @author Administrator
 * @version 2020-11-8
 *
 */
public class GetDecimalValue {

	public static int getDecimalValue(ListNode head) {
		int size = 0;
		ListNode cur = head;
		while(cur != null) {
			cur = cur.next;
			size ++;
		}
		int num = getNum(head, size);
		return num;
	}

	private static int getNum(ListNode head, int size) {
		if(size == 1) {
			return (int) (head.val * 1);
		}
		double num = head.val * Math.pow(2, size - 1) + getNum(head.next, size - 1);
		return (int) num;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(0);
		ListNode node = new ListNode(1,n1);
		System.out.println(getDecimalValue(node));
	}

}
