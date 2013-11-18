package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (true) {
			while (root != null) {
				result.add(root.val);
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty() == false) {
				root = stack.pop().right;
			} else {
				break;
			}
		}
		return result;
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