package com.datastructure.linkedlist;

/**
 * 
 *<p>Description:使用虚拟头结点的处理方法<p>	
 * @author Administrator
 * @version 2020-10-28
 *
 */
public class Solution1 {
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode removeElements(ListNode head, int val) {

		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;

		ListNode prev = dummyHead;
		ListNode deleNode = null;
		while(prev != null && prev.next != null) {
			if(prev.next.val == val) {
				deleNode = prev.next;
				prev.next = deleNode.next;
				deleNode = null;
			}else {prev = prev.next;}
		}
		return dummyHead.next;
	}
}