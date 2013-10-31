package MaximumDepthofBinaryTree;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node. 
 * 
 * Definition for binary tree public class
 * TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x;
 * } }
 */
public class Solution {
	public int maxDepth(TreeNode root) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if(root==null){
			return 0;
		}
		return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(0);
		root.left=new TreeNode(1);
		root.right=new TreeNode(1);
		root.right.right=new TreeNode(2);
		Solution s=new Solution();
		System.out.println(s.maxDepth(root));
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