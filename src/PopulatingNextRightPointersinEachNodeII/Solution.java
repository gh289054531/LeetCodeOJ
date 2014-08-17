package PopulatingNextRightPointersinEachNodeII;

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode p = root;
		TreeLinkNode virtualNextLevel = new TreeLinkNode(-1);
		TreeLinkNode q = virtualNextLevel;
		while (p != null) {
			if (p.left != null) {
				q.next = p.left;
				q = q.next;
			}
			if (p.right != null) {
				q.next = p.right;
				q = q.next;
			}
			p = p.next;
		}
		connect(virtualNextLevel.next);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
