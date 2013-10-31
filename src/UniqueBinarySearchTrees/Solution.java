package UniqueBinarySearchTrees;
/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,Given n = 3, there are a total of 5 unique BST's
 *
 */
public class Solution {
	public int numTrees(int n) {
		return bulidTree(1, n);
	}

	public int bulidTree(int left, int right) {
		if (left >= right) {
			return 1;
		}
		int treeNum = 0;
		for (int i = left; i <= right; i++) {
			treeNum += bulidTree(left, i - 1) * bulidTree(i + 1, right);
		}
		return treeNum;
	}

	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.numTrees(2));
	}

}
