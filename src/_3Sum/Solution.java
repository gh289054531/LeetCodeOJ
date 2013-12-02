package _3Sum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * http://en.wikipedia.org/wiki/3SUM
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 3) {
			return result;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2;) {
			int k = i + 1, l = num.length - 1;
			while (k < l) {
				int a = num[i];
				int b = num[k];
				int c = num[l];
				if (a + b + c == 0) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(a);
					temp.add(b);
					temp.add(c);
					result.add(temp);
					while (k < l && num[k + 1] == num[k]) {
						k++;
					}
					while (k < l && num[l - 1] == num[l]) {
						l--;
					}
					k++;
					l--;
				} else if (a + b + c > 0) {
					l--;
				} else {
					k++;
				}
			}
			while (i + 1 < num.length - 2 && num[i] == num[i + 1]) {
				i++;
			}
			i++;
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
