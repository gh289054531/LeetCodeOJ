package TrappingRainWater;

public class Solution {
	/**
	 * ���ҳ���ߵ����ӣ�Ȼ����������������ߵ����ӿ�£
	 * @param A
	 * @return
	 */
	public int trap(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (A == null || A.length <= 2) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
				maxIndex = i;
			}
		}
		int sum = 0;
		int maxtemp = Integer.MIN_VALUE;
		for (int i = 0; i < maxIndex; i++) {
			if (A[i] >= maxtemp) {
				maxtemp = A[i];
			} else {
				sum += maxtemp - A[i];
			}
		}
		maxtemp = Integer.MIN_VALUE;
		for (int i = A.length - 1; i > maxIndex; i--) {
			if (A[i] >= maxtemp) {
				maxtemp = A[i];
			} else {
				sum += maxtemp - A[i];
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
