package PascalsTriangle;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numRows; i++) {
			nums.add(new ArrayList<Integer>(i + 1));
			if (i == 0) {
				nums.get(0).add(1);
			} else {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						nums.get(i).add(1);
						continue;
					}
					nums.get(i).add(nums.get(i - 1).get(j - 1) + nums.get(i - 1).get(j));
				}
			}
		}
		return nums;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.generate(5);
	}

}
