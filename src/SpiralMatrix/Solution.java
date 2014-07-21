package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int m = matrix.length, n = matrix[0].length;
		int i = 0, j = 0;
		while (i < (m + 1) / 2 && j < (n + 1) / 2) {
			for (int col = j; col < n - j; col++) {
				result.add(matrix[i][col]);
			}
			result.remove(result.size() - 1);
			for (int row = i; row < m - i; row++) {
				result.add(matrix[row][n - j - 1]);
			}
			if (m - i - 1 > i && n - j - 1 > j) {
				result.remove(result.size() - 1);
				for (int col = n - j - 1; col >= j; col--) {
					result.add(matrix[m - i - 1][col]);
				}
				result.remove(result.size() - 1);
				for (int row = m - i - 1; row > i; row--) {
					result.add(matrix[row][j]);
				}
			}
			i++;
			j++;
		}
		return result;
	}
}