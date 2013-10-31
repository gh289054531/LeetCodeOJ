package BinaryTreeInorderTraversal;

import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		inorderTraversal(root, inorder);
		return inorder;
	}

	private void inorderTraversal(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left,list);
		list.add(root.val);
		inorderTraversal(root.right,list);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = null;
		root.left.left = null;
		root.left.right = null;
		ArrayList<Integer> list=s.inorderTraversal(root);
		System.out.println();
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