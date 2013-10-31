package RemoveDuplicatesfromSortedList;

/**
 * 
Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 * 
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ListNode temp = head;
		if (temp == null) {
			return head;
		}
		while (temp != null) {
			while (temp.next != null && temp.next.val == temp.val) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}