package SearchInsertPosition;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order. You may assume no duplicates in the array. Here are few examples.
 * [1,3,5,6], 5 ¡ú 2 [1,3,5,6], 2 ¡ú 1 [1,3,5,6], 7 ¡ú 4 [1,3,5,6], 0 ¡ú 0
 * 
 */
public class Solution {
	public int searchInsert(int[] A, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (A == null) {
			return -1;
		}
		return searchInsert(A, target, 0, A.length - 1);
	}

	private int searchInsert(int[] A, int target, int left, int right) {
		if (left > right) {
			return left;
		}
		int middle = (left + right) / 2;
		if (target == A[middle]) {
			return middle;
		} else if (target < A[middle]) {
			return searchInsert(A, target, left, middle - 1);
		} else {
			return searchInsert(A, target, middle + 1, right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] test1 = new int[] { 1, 3, 5, 6 };
		System.out.println(s.searchInsert(test1, 5));
		System.out.println(s.searchInsert(test1, 2));
		System.out.println(s.searchInsert(test1, 7));
		System.out.println(s.searchInsert(test1, 0));
	}

}
