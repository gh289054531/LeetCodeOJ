package Subsets;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0) {
			return subsets;
		}
		BigInteger i = BigInteger.ZERO;
		for (; i.doubleValue() < Math.pow(2, S.length) - 0.5; i = i.add(BigInteger.ONE)) {
			String byteI = i.toString(2);
			byteI = new StringBuilder(byteI).reverse().toString();
			ArrayList<Integer> cur = new ArrayList<Integer>();
			for (int j = 0; j < byteI.length(); j++) {
				if (byteI.charAt(j) == '1') {
					cur.add(S[j]);
				}
			}
			Collections.sort(cur);
			subsets.add(cur);
		}
		return subsets;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ArrayList<ArrayList<Integer>> subsets = s.subsets(new int[] { 1, 2, 3 });
		for (ArrayList<Integer> l : subsets) {
			for (Integer i : l) {
				System.out.print(i + "    ");
			}
			System.out.println();
		}
	}

}
