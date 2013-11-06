package SearchforaRange;

public class Solution {
	public int[] searchRange(int[] A, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (A == null || A.length == 0) {
			return new int[] { -1, -1 };
		}
		int left = binarysearch(A, target - 0.1, 0, A.length - 1);
		int right = binarysearch(A, target + 0.1, 0, A.length - 1) - 1;
		if (left > right) {
			return new int[] { -1, -1 };
		} else {
			return new int[] { left, right };
		}
	}

	private int binarysearch(int[] A, double target, int left, int right) {
		if (left > right) {
			return left;
		}
		int middle = (left + right) / 2;
		if (A[middle] > target) {
			return binarysearch(A, target, left, middle - 1);
		} else if (A[middle] < target) {
			return binarysearch(A, target, middle + 1, right);
		} else {
			return middle; // this line won't be visited
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
