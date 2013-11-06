package LinkedListCycleII;
/**
 * O(N*M),N是非环的长度，M是环的长度
 *
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p2 != null && p1 != p2) {
			p1 = p1.next;
			if (p2.next == null) {
				return null;
			} else {
				p2 = p2.next.next;
			}
		}
		if (p2 == null) {
			return null;
		}
		ListNode target = head;
		while (p2 != target) {
			p2 = p2.next;
			if (p2 == p1) {
				target = target.next;
			}
		}
		return target;
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