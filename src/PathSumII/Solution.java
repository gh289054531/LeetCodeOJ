package PathSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		search(root, 0, sum, new ArrayList<Integer>(), result);
		return result;
	}

	private void search(TreeNode root, int curSum, int sum, List<Integer> cur, List<List<Integer>> result) {
		if (root != null && root.left == null && root.right == null) {
			if (root.val + curSum == sum) {
				cur.add(root.val);
				result.add(new ArrayList<Integer>(cur));
				cur.remove(cur.size() - 1);
			}
		}
		if (root.left != null) {
			cur.add(root.val);
			search(root.left, curSum + root.val, sum, cur, result);
			cur.remove(cur.size() - 1);
		}
		if (root.right != null) {
			cur.add(root.val);
			search(root.right, curSum + root.val, sum, cur, result);
			cur.remove(cur.size() - 1);
		}
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
