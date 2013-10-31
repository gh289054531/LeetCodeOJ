package RemoveDuplicatesfromSortedArray;

public class Solution {
	public int removeDuplicates(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (A == null) {
			return -1;
		}
		int tempmax = Integer.MIN_VALUE;
		int j = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > tempmax) {
				tempmax = A[i];
				A[j++] = tempmax;
			}
		}
		return j;
	}



}
