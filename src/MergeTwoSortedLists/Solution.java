package MergeTwoSortedLists;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ListNode i = l1, j = l2;
		ListNode newList = new ListNode(-1);
		ListNode temp = newList;
		while (i != null && j != null) {
			if (i.val < j.val) {
				newList.next = i;
				i = i.next;
				newList = newList.next;
			} else if (i.val == j.val) {
				newList.next = i;
				i = i.next;
				newList = newList.next;
				newList.next = j;
				j = j.next;
				newList = newList.next;
			} else {
				newList.next = j;
				j = j.next;
				newList = newList.next;
			}
		}
		while (i != null) {
			newList.next = i;
			i = i.next;
			newList = newList.next;
		}
		while (j != null) {
			newList.next = j;
			j = j.next;
			newList = newList.next;
		}
		return temp.next;
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