package AddTwoNumbers;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode result = new ListNode(0);
		ListNode head = result;
		int jinwei = 0;
		while (result != null) {
			if (l1 == null && l2 != null) {
				result.val = l2.val + jinwei;
				jinwei = result.val / 10;
				result.val %= 10;
				if (l2.next != null || jinwei != 0) {
					result.next = new ListNode(0);
				}
				l2 = l2.next;
			} else if (l1 != null && l2 == null) {
				result.val = l1.val + jinwei;
				jinwei = result.val / 10;
				result.val %= 10;
				if (l1.next != null || jinwei != 0) {
					result.next = new ListNode(0);
				}
				l1 = l1.next;
			} else if (l1 != null && l2 != null) {
				result.val = l1.val + l2.val + jinwei;
				jinwei = result.val / 10;
				result.val %= 10;
				if (l1.next != null || l2.next != null || jinwei != 0) {
					result.next = new ListNode(0);
				}
				l1 = l1.next;
				l2 = l2.next;
			} else {
				if (jinwei != 0) {
					result.val = jinwei;
				}
			}
			result = result.next;
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode result = new ListNode(1);
		ListNode head = result;
		result.next = new ListNode(2);
		result = result.next;
		result = null;
		System.out.println(head.val);
		System.out.println(head.next.val);
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