package ConvertSortedArraytoBinarySearchTree;

public class Solution {
	public TreeNode sortedArrayToBST(int[] num) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (num == null || num.length == 0) {
			return null;
		}
		TreeNode root = binarySearch(num, 0, num.length - 1);
		return root;
	}

	private TreeNode binarySearch(int[] num, int left, int right) {
		if (left == right) {
			return new TreeNode(num[left]);
		} else if (left > right) {
			return null;
		} else {
			int middle = (left + right) / 2;
			TreeNode node = new TreeNode(num[middle]);
			node.left = binarySearch(num, left, middle - 1);
			node.right = binarySearch(num, middle + 1, right);
			return node;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = new int[] { 1, 3, 4, 5, 5, 7, 7, 8 };
		Solution s = new Solution();
		TreeNode root = s.sortedArrayToBST(test1);
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