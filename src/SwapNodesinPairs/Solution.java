package SwapNodesinPairs;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null) {
			return null;
		}
		ListNode temp = head.next;
		if (temp == null) {
			return head;
		}
		head.next = temp.next;
		temp.next = head;
		head.next = swapPairs(head.next);
		return temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
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