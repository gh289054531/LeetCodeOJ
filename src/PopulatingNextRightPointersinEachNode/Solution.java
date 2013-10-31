package PopulatingNextRightPointersinEachNode;

public class Solution {
	public void connect(TreeLinkNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (root == null) {
			return;
		}
		TreeLinkNode[] lastNodeInEveryDepth = new TreeLinkNode[100];
		for (int i = 0; i < 100; i++) {
			lastNodeInEveryDepth[i] = null;
		}
		preOrderTraverse(root, 0, lastNodeInEveryDepth);
	}

	private void preOrderTraverse(TreeLinkNode root, int depth, TreeLinkNode[] lastNodeInEveryDepth) {
		if (root == null) {
			return;
		}
		root.next = null;
		if (lastNodeInEveryDepth[depth] == null) {
			lastNodeInEveryDepth[depth] = root;
		} else {
			lastNodeInEveryDepth[depth].next = root;
			lastNodeInEveryDepth[depth] = root;
		}
		preOrderTraverse(root.left, depth + 1, lastNodeInEveryDepth);
		preOrderTraverse(root.right, depth + 1, lastNodeInEveryDepth);
	}
	
	public static void main(String[] args) {
		TreeLinkNode root=new TreeLinkNode(1);
		root.left=new TreeLinkNode(2);
		root.right=new TreeLinkNode(3);
		Solution s=new Solution();
		s.connect(root);
		System.out.println();
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}