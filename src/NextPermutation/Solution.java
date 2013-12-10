package NextPermutation;

import java.util.Arrays;

/**
 * http://stackoverflow.com/questions/11483060/stdnext-permutation-
 * implementation-explanation
 */
public class Solution {
	public void nextPermutation(int[] num) {
		if (num == null || num.length < 2) {
			return;
		}
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				reverse(num, i, num.length - 1);
				for (int j = i; j < num.length; j++) {
					if (num[i - 1] < num[j]) {
						swap(num, i - 1, j);
						return;
					}
				}
			}
		}
		reverse(num, 0, num.length - 1);
	}

	private void reverse(int[] num, int i, int j) {
		while (i < j) {
			swap(num, i++, j--);
		}
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
