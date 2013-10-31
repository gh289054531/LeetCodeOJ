package SymmetricTree;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	public boolean isSymmetric2(TreeNode root) {
		if(root==null){
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		stack.push(root);
		TreeNode curNode = null;
		while (stack.isEmpty() == false) {
			curNode = stack.pop();
			while (curNode.left != null) {
				stack.push(curNode);
				curNode = curNode.left;
			}
			list.add(curNode.val);
			if (curNode.right != null) {
				stack.push(curNode.right);
			} else {
				while (curNode.right == null && stack.isEmpty() == false) {
					curNode = stack.pop();
					list.add(curNode.val);
				}
				if (curNode.right != null) {
					stack.push(curNode.right);
				}
			}
		}
		int i = 0, j = list.size() - 1;
		while (true) {
			if (i > j) {
				break;
			} else {
				if (list.get(i++).equals(list.get(j--)) == false) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isSymmetric1(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<Integer> list = new ArrayList<Integer>();
		inOrderTraverse(root, list);
		int i = 0, j = list.size() - 1;
		while (true) {
			if (i > j) {
				break;
			} else {
				if (list.get(i++).equals(list.get(j--)) == false) {
					return false;
				}
			}
		}
		return true;
	}

	private void inOrderTraverse(TreeNode node, ArrayList<Integer> l) {
		if (node == null) {
			return;
		}
		inOrderTraverse(node.left, l);
		l.add(node.val);
		inOrderTraverse(node.right, l);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(-57);
		root.right = new TreeNode(-57);
		root.left.right = new TreeNode(67);
		root.right.left = new TreeNode(67);
		root.left.right.right = new TreeNode(-97);
		root.right.left.left = new TreeNode(-97);

		Solution s = new Solution();
		System.out.println(s.isSymmetric2(root));
	}

}

class TreeNode {
	int val;
	TreeNode left = null;
	TreeNode right = null;

	TreeNode(int x) {
		val = x;
	}

	public String toString() {
		return String.valueOf(val);
	}
}