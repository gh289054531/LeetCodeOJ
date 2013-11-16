package BinaryTreePostorderTraversal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Solution {
	/**
	 * 二叉树非递归后续遍历，需用到一个栈和一个集合
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		TreeNode node = root;
		while (true) {
			while (node.left != null) {
				stack.push(node);
				node = node.left;
			}
			if (node.right != null) {
				stack.push(node);
				visited.add(node);
				node = node.right;
			} else {
				result.add(node.val);
				while (stack.isEmpty() == false) {
					node = stack.pop();
					if (visited.contains(node)) {
						result.add(node.val);
					} else {
						if (node.right == null) {
							result.add(node.val);
						} else {
							stack.push(node);
							visited.add(node);
							node = node.right;
							break;
						}
					}
				}
				if (stack.isEmpty() == true) {
					break;
				}
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