package InsertionSortList;
public class Solution {

	public ListNode insertionSortList(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null) {
			return head;
		}
		ListNode cur = head.next;
		ListNode curpre = head;
		ListNode temp = null;
		while (cur != null) {
			ListNode curNext = cur.next;
			temp = head;
			while (temp != cur) {
				if (temp.val >= cur.val) {
					int x = temp.val;
					temp.val = cur.val;
					cur.val = x;
					curpre.next = cur.next;
					cur.next = temp.next;
					temp.next = cur;
					break;
				} else {
					temp = temp.next;
				}
			}
			if (curpre.next != curNext) {
				curpre = curpre.next;
			}
			cur = curNext;
		}
		return head;
	}

	public void printlist(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
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