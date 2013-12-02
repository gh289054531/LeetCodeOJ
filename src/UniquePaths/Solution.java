package UniquePaths;

/**
 * 这类题目，直观解法都是递归搜索，但是要注意效率！考虑是否可以转换成DP解法收
 * @author Administrator
 *
 */
public class Solution {
	public int uniquePaths(int m, int n) {
		if (m <= 0 || n <= 0) {
			return 0;
		}
		int[][] pathNum = new int[m][n];
		for (int i = 0; i < m; i++) {
			pathNum[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			pathNum[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
			}
		}
		return pathNum[m - 1][n - 1];
	}

}
