package RemoveNthNodeFromEndofList;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null || n <= 0) {
			return null;
		}
		ListNode pre = head;
		ListNode after = head;
		for (int i = 0; i < n; i++) {
			if (pre == null) {
				return head;
			}
			pre = pre.next;
		}
		if (pre == null) {
			return head.next;
		}
		while (pre.next != null) {
			pre = pre.next;
			after = after.next;
		}
		after.next = after.next.next;
		return head;
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