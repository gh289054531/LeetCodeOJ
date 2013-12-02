package _3SumClosest;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int result = Integer.MAX_VALUE;
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < num.length - 2; i++) {
			int k = i + 1;
			int l = num.length - 1;
			while (k < l) {
				int a = num[i];
				int b = num[k];
				int c = num[l];
				int sum = a + b + c;
				int tempDist = Math.abs(sum - target);
				if (tempDist < minDist) {
					minDist = tempDist;
					result = sum;
				}
				if (sum > target) {
					l--;
				} else if (sum < target) {
					k++;
				} else {
					return sum;
				}
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
