package LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			map.put(num[i], 1);
		}
		int maxLen = 0;
		while (map.isEmpty() == false) {
			Integer cur = null;
			for (Integer i : map.keySet()) {
				cur = i;
				break;
			}
			map.remove(cur);
			int curLen = 1;
			Integer temp = cur;
			while (map.containsKey(temp + 1)) {
				curLen++;
				temp = temp + 1;
				map.remove(temp);
			}
			temp = cur;
			while (map.containsKey(temp - 1)) {
				curLen++;
				temp = temp - 1;
				map.remove(temp);
			}
			if (curLen > maxLen) {
				maxLen = curLen;
			}
		}
		return maxLen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
