package LongestValidParentheses;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

public class Solution {
	public int longestValidParentheses(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int max = 0;
		int maxleft = -1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty() == true) {
					for (Entry<Integer, Integer> entry : map.entrySet()) {
						if (entry.getValue() - entry.getKey() + 1 > max) {
							max = entry.getValue() - entry.getKey() + 1;
						}
					}
					map.clear();
				} else {
					int left = stack.pop();
					if (left > maxleft) {
						maxleft = left;
						boolean hasAdj = false;
						for (Entry<Integer, Integer> entry : map.entrySet()) {
							if (entry.getValue() + 1 == left) {
								entry.setValue(i);
								hasAdj = true;
								max = max < i - entry.getKey() + 1 ? i - entry.getKey() + 1 : max;
							}
						}
						if (hasAdj == false) {
							map.put(left, i);
							max = max < i - left + 1 ? i - left + 1 : max;
						}
					} else {
						boolean hasAdj = false;
						Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
						while (iter.hasNext()) {
							Entry<Integer, Integer> entry = iter.next();
							if (entry.getKey() > left) {
								iter.remove();
							}
							if (entry.getValue() + 1 == left) {
								entry.setValue(i);
								hasAdj = true;
								max = max < i - entry.getKey() + 1 ? i - entry.getKey() + 1 : max;
							}
						}
						if (hasAdj == false) {
							map.put(left, i);
							max = max < i - left + 1 ? i - left + 1 : max;
						}
					}
				}
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.longestValidParentheses("()(())"));
	}

}
