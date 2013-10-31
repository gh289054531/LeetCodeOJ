package BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		preOrderTraverse(root, result, 0);
		for (int i = 0, j = result.size() - 1; i < j; i++, j--) {
			ArrayList<Integer> temp = result.get(i);
			result.set(i, result.get(j));
			result.set(j, temp);
		}
		return result;
	}

	private void preOrderTraverse(TreeNode node, ArrayList<ArrayList<Integer>> result, int level) {
		if (node == null) {
			return;
		}
		if (result.size() < level + 1) {
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