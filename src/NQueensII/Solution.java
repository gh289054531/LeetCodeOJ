package NQueensII;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	private int count = 0;
	private final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int totalNQueens(int n) {
		if (n < 1) {
			return 0;
		}
		search(n, 0);
		return count;
	}

	private void search(int n, int depth) {
		for (int i = 0; i < n; i++) {
			boolean flag = check(i, n, depth);
			if (flag == true) {
				if (depth == n - 1) {
					count++;
					return;
				} else {
					map.put(depth, i);
					search(n, depth + 1);
					map.remove(depth);
				}
			}
		}
	}

	private boolean check(int col, int n, int depth) {
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == col)
				return false;
			double k = (entry.getKey() - depth + 0.0) / (entry.getValue() - col + 0.0);
			if (k == 1 || k == -1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.totalNQueens(1));
		s = new Solution();
		System.out.println(s.totalNQueens(2));
		s = new Solution();
		System.out.println(s.totalNQueens(3));
		s = new Solution();
		System.out.println(s.totalNQueens(4));
		s = new Solution();
		System.out.println(s.totalNQueens(5));
	}
}