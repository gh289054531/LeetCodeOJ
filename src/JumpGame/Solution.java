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
			if (A[i] >= index - i) {
				boolean temp = canJump(A, i, falseIndex);
				if (temp == false) {
					falseIndex[i] = true;
				} else {
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

}
