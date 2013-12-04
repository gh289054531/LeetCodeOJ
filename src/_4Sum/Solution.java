package _4Sum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 解法与3Sum类似，时间复杂度O(N^3)
 * 
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 4) {
			return result;
		}
		Arrays.sort(num);
		for (int i = 0; i <= num.length - 4; i++) {
			for (int j = i + 1; j <= num.length - 3; j++) {
				int m = j + 1;
				int n = num.length - 1;
				int curTarget = target - num[i] - num[j];
				while (m < n) {
					if (num[m] + num[n] == curTarget) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[m]);
						temp.add(num[n]);
						result.add(temp);
						while (m + 1 < n && num[m] == num[m + 1]) {
							m++;
						}
						m++;
						while (n - 1 > m && num[n] == num[n - 1]) {
							n--;
						}
						n--;
					} else if (num[m] + num[n] > curTarget) {
						while (n - 1 > m && num[n] == num[n - 1]) {
							n--;
						}
						n--;
					} else {
						while (m + 1 < n && num[m] == num[m + 1]) {
							m++;
						}
						m++;
					}
				}
				while (j + 1 <= num.length - 3 && num[j] == num[j + 1]) {
					j++;
				}
			}
			while (i + 1 <= num.length - 4 && num[i] == num[i + 1]) {
				i++;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] test = new int[] { 1, 0, -1, 0, -2, 2 };
		System.out.println(s.fourSum(test, 0));
	}

}
