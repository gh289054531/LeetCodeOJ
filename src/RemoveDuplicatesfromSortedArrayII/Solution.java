package RemoveDuplicatesfromSortedArrayII;

/**
 * 注意这题不需要额外空间！
 */
public class Solution {
	public int removeDuplicates(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (A == null || A.length == 0) {
			return 0;
		}
		int cur = Integer.MIN_VALUE;
		int occurTimes = 0;
		int j = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == cur) {
				if (occurTimes < 2) {
					occurTimes++;
					A[j++] = cur;
				}
			} else {
				cur = A[i];
				occurTimes = 1;
				A[j++] = cur;
			}
		}
		return j;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
