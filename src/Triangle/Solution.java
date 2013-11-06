package Triangle;

import java.util.ArrayList;

public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int[] sum = new int[triangle.size()];
		sum[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			for (int j = i; j >= 0; j--) {
				if (j > 0 && j < i) {
					sum[j] = Math.min(sum[j - 1], sum[j]) + triangle.get(i).get(j);
				} else if (j == 0) {
					sum[j] += triangle.get(i).get(j);
				} else {
					sum[j] = triangle.get(i).get(j) + sum[j - 1];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < triangle.size(); i++) {
			if (sum[i] < min) {
				min = sum[i];
			}
		}
		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
