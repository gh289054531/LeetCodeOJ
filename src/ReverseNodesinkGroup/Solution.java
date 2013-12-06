package ReverseNodesinkGroup;

public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k < 2) {
			return head;
		}
		ListNode trickHead = new ListNode(-1);
		trickHead.next = head;// 为了方便放一个结点当做头，返回时去掉。
		ListNode pre = trickHead;
		ListNode end = pre;
		while (true) {
			for (int i = 0; i < k; i++) {
				if (end.next != null) {
					end = end.next;
				} else {
					return trickHead.next;
				}
			}
			ListNode nextPre = null;
			for (int i = 0; i < k - 1; i++) {
				if (i == 0) {
					nextPre = pre.next;
				}
				ListNode cur = pre.next;
				pre.next = cur.next;
				cur.next = end.next;
				end.next = cur;
			}
			pre = nextPre;
			end = pre;
		}
	}

	public static void main(String[] args) {

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