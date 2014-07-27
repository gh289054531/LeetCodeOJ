package RotateList;

public class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n < 0) {
			return null;
		}
		ListNode p = head;
		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
		}
		n %= len;
		if (n == 0) {
			return head;
		}
		p = head;
		int i = 0;
		for (; i < n && p != null; i++) {
			p = p.next;
		}
		if (i < n || p == null) {
			return head;
		}
		ListNode q = head;
		while (p.next != null) {
			p = p.next;
			q = q.next;
		}
		ListNode newHead = q.next;
		q.next = null;
		p.next = head;
		return newHead;
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