package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		preOrderTraverse(root, result, 0);
		return result;
	}

	private void preOrderTraverse(TreeNode node, ArrayList<ArrayList<Integer>> result, int level) {
		if (node == null) {
			return;
		}
		if (result.size() - 1 < level) {
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(node.val);
		preOrderTraverse(node.left, result, level + 1);
		preOrderTraverse(node.right, result, level + 1);
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