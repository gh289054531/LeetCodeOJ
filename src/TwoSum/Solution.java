package TwoSum;

import java.util.HashMap;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length * 2);
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i + 1);
		}
		for (int i = 0; i < numbers.length; i++) {
			int another = target - numbers[i];
			if (map.containsKey(another)) {
				return new int[] { i + 1, map.get(another) };
			}
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
