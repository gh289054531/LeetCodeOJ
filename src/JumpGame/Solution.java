package JumpGame;

public class Solution {

	public boolean canJump(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (A == null || A.length == 0) {
			return false;
		}
		boolean[] falseIndex = new boolean[A.length];
		return canJump(A, A.length - 1, falseIndex);
	}

	public boolean canJump(int[] A, int index, boolean[] falseIndex) {
		if (index == 0) {
			return true;
		}
		if (falseIndex[index] == true) {
			return false;
		}
		for (int i = 0; i < index; i++) {
			if (A[i] >= index - i) {// 从i可以跳到index
				boolean temp = canJump(A, i, falseIndex);// 判断是否有方法能跳到i
				if (temp == false) {// 如果没有方法从起点跳到i那么失败
					falseIndex[i] = true;
				} else {// 否则返回OK
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canJump1(int[] A) {// This method get “Time Limit Exceeded” error
		if (A == null || A.length == 0) {
			return false;
		}
		if (A.length == 1) {
			return true;
		}
		boolean[] canReach = new boolean[A.length];
		canReach[0] = true;
		for (int i = 0; i < A.length; i++) {
			if (canReach[i] == true) {
				for (int j = 1; j <= A[i]; j++) {
					if (i + j == A.length - 1) {
						return true;
					}
					canReach[i + j] = true;
				}
			} else {
				return false;
			}
		}
		return false;// don't need this line
	}
}
