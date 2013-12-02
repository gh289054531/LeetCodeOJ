package MinimumPathSum;

public class Solution {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] pathNum = new int[m][n];
		pathNum[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			pathNum[i][0] = pathNum[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < n; j++) {
			pathNum[0][j] = pathNum[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				pathNum[i][j] = grid[i][j] + Math.min(pathNum[i - 1][j], pathNum[i][j - 1]);
			}
		}
		return pathNum[m - 1][n - 1];
	}
}
