package BalancedBinaryTree;

public class Solution {
	public boolean isBalanced(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (root == null) {
			return true;
		}
		if (traverse(root, 0) != -1) {
			return true;
		}
		return false;
	}

	private int traverse(TreeNode node, int curDepth) {
		if (node == null) {
			return curDepth;
		}
		int leftHeight = traverse(node.left, curDepth + 1);
		int rightHeight = traverse(node.right, curDepth + 1);
		if (leftHeight == -1 || rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		if (leftHeight < rightHeight) {
			return rightHeight;
		} else {
			return leftHeight;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}