package MergekSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 利用堆实现，假定有k个链表，总共有n个节点，时间复杂度为O(n*logk)，空间复杂度为O(k)
 */
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		int size = lists.size();
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(size, new ListNodeCmp());
		for (int i = 0; i < size; i++) {
			if (lists.get(i) != null) {
				pq.add(lists.get(i));
			}
		}
		ListNode resultHead = new ListNode(-1);
		ListNode resultTail = resultHead;
		while (pq.isEmpty() == false) {
			ListNode min = pq.poll();
			resultTail.next = new ListNode(min.val);
			resultTail = resultTail.next;
			if (min.next != null) {
				pq.offer(min.next);
			}
		}
		return resultHead.next;
	}

	public static void main(String[] args) {

	}

}

class ListNodeCmp implements Comparator<ListNode> {
	@Override
	public int compare(ListNode o1, ListNode o2) {
		if (o1.val < o2.val) {
			return -1;
		} else if (o1.val > o2.val) {
			return 1;
		} else {
			return 0;
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