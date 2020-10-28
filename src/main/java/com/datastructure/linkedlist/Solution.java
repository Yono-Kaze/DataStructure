package com.datastructure.linkedlist;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/submissions/
 *Remove all elements from a linked list of integers that have value val.
 *Example:
 *Input:  1->2->6->3->4->5->6, val = 6
 *Output: 1->2->3->4->5
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode removeElements(ListNode head, int val) {

		ListNode deleNode = null;

	
		while(head != null &&head.val == val) {
			deleNode = head;
			head = head.next;
			deleNode = null;
		}

		if(head == null) {return null;}
		
		ListNode prev = head;

		while( prev.next != null) {
			if(prev.next.val == val) {
				deleNode = prev.next;
				prev.next = deleNode.next;
				deleNode = null;
			}else {prev = prev.next;}
		}
		return head;
	}
	
}