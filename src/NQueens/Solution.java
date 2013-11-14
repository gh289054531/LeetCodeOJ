package NQueens;

import java.util.ArrayList;

public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<String[]> result = new ArrayList<String[]>();
		if (n < 1) {
			return result;
		}
		boolean[][] status = new boolean[n][n];
		solve(status, 0, n, result);
		return result;
	}

	private void solve(boolean[][] status, int i, int n, ArrayList<String[]> result) {
		if (i == n) {
			return;
		}
		for (int j = 0; j < n; j++) {
			if (check(status, i, j, n)) {
				status[i][j] = true;
				if (i == n - 1) {
					result.add(convert(status));
				}
				solve(status, i + 1, n, result);
				status[i][j] = false;
			}
		}
	}

	private String[] convert(boolean[][] status) {
		String[] ss = new String[status.length];
		for (int i = 0; i < status.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < status.length; j++) {
				if (status[i][j] == true) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			ss[i] = sb.toString();
		}
		return ss;
	}

	private boolean check(boolean[][] status, int i, int j, int n) {
		for (int row = 0; row < i; row++) {
			if (status[row][j] == true) {
				return false;
			}
		}
		int i1 = i;
		int j1 = j;
		while ((--i1) >= 0 && (--j1) >= 0) {
			if (status[i1][j1] == true) {
				return false;
			}
		}
		i1 = i;
		j1 = j;
		while ((++j1) < n && (--i1) >= 0) {
			if (status[i1][j1] == true) {
				return false;
			}
		}
		return true;
	}
}
