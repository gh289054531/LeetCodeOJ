package MaximumSubarray;

public class Solution {
	//O(N)
	public int maxSubArray1(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int max = A[0], temp = A[0];
		for (int i = 1; i < A.length; i++) {
			if (temp > 0) {
				temp += A[i];
			} else {
				temp = A[i];
			}
			max = Math.max(max, temp);
		}
		return max;
	}
	
	
	//Divide and conquer, O(N*logN)
	public int maxSubArray2(int[] A) {
		return divideAndConquer(A, 0, A.length - 1);
	}

	private int divideAndConquer(int[] A, int left, int right) {
		if (right <= left) {
			return A[right];
		}
		int middle = (left + right) / 2;
		int maxleft = divideAndConquer(A, left, middle);
		int maxright = divideAndConquer(A, middle + 1, right);

		int tempLeftMax = Integer.MIN_VALUE;
		int tempRightMax = Integer.MIN_VALUE;
		int tempLeft = 0, tempRight = 0;
		for (int i = middle; i >= left; i--) {
			tempLeft += A[i];
			tempLeftMax = Math.max(tempLeftMax, tempLeft);
		}
		for (int i = middle + 1; i <= right; i++) {
			tempRight += A[i];
			tempRightMax = Math.max(tempRightMax, tempRight);
		}
		return Math.max(Math.max(maxleft, maxright), (tempLeftMax + tempRightMax));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] test1 = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(s.maxSubArray1(test1));
	}
}
