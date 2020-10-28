package com.datastructure.linkedlist;



/**
 * 
 *<p>Description:使用递归解决<p>	
 * @author Administrator
 * @version 2020-10-28
 *
 */
public class Solution2 {

	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;

		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
		
	}


}
