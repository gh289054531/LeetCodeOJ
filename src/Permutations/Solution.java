package Permutations;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			numList.add(num[i]);
		}
		permute(numList, num.length, result);
		return result;
	}

	private void permute(ArrayList<Integer> num, int length, ArrayList<ArrayList<Integer>> result) {
		if (length == 0) {
			return;
		}
		for (int i = 0; i < length; i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>(num);
			int temp = cur.get(length - 1);
			cur.set(length - 1, cur.get(i));
			cur.set(i, temp);
			if (result.contains(cur) == false) {
				result.add(cur);
			}
			permute(cur, length - 1, result);
		}
	}
}