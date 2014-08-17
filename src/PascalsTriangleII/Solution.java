package PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return result;
		}
		for (int i = 0; i <= rowIndex; i++) {
			for (int j = i - 1; j > 0; j--) {
				result.set(j, result.get(j - 1) + result.get(j));
			}
			result.add(1);
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
}
