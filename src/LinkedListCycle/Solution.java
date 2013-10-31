package LinkedListCycle;

public class Solution {
	public boolean hasCycle(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null) {
			return false;
		}
		ListNode p1 = head, p2 = head.next;
		while (p2 != null && p1 != p2) {
			p1 = p1.next;
			if (p2.next == null) {
				return false;
			} else {
				p2 = p2.next.next;
			}
		}
		if (p2 == null) {
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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