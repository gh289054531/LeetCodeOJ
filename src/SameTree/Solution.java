package SameTree;


/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val == q.val) {
			boolean same = true;
			same = same & isSameTree(p.left, q.left);
			same = same & isSameTree(p.right, q.right);
			return same;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(0);
		root.left=new TreeNode(1);
		root.right=new TreeNode(1);
		root.right.right=new TreeNode(2);
		
		TreeNode root1=new TreeNode(0);
		root1.left=new TreeNode(1);
		root1.right=new TreeNode(1);
		root1.right.right=new TreeNode(1);
		Solution s=new Solution();
		System.out.println(s.isSameTree(root,root1));
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