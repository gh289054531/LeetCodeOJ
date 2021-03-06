package SingleNumber;
/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {
	public int singleNumber(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			result = result ^ A[i];
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
