package SumRoottoLeafNumbers;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return sumNumbers1(root, 0);
	}

	private int sumNumbers1(TreeNode root, int curSum) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return curSum * 10 + root.val;
		}
		return sumNumbers1(root.left, curSum * 10 + root.val) + sumNumbers1(root.right, curSum * 10 + root.val);
	}

}