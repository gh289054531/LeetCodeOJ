package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (s == null || s.length() == 0) {
			return 0;
		}
		int max = 0;
		HashMap<Character, Integer> set = new HashMap<Character, Integer>(24 * 2);
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.containsKey(c)) {
				max = i - left > max ? i - left : max;
				int oldPos = set.get(c);
				for (int m = left; m < oldPos; m++) {
					set.remove(s.charAt(m));
				}
				left = oldPos + 1;
				set.put(c, i);
			} else {
				set.put(c, i);
			}
		}
		max = s.length() - left > max ? s.length() - left : max;
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}

}
