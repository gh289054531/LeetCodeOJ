package LongestCommonPrefix;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int i = 0;
		while (true) {
			char curChar = 0;
			if (i < strs[0].length()) {
				curChar = strs[0].charAt(i);
			} else {
				return new String(strs[0]);
			}
			for (String s : strs) {
				if (s.length() == i) {
					return new String(s);
				}
				if (s.charAt(i) != curChar) {
					return s.substring(0, i);
				}
			}
			i++;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
