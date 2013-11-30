package RegularExpressionMatching;

/**
 * 参考下面的网页：
 * http://discuss.leetcode.com/questions/175/regular-expression-matching
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		return isMatch(s, p, 0, 0);
	}

	private boolean isMatch(String s, String p, int i, int j) {
		if (j == p.length()) {
			return i == s.length();
		}
		char pchar = p.charAt(j);
		if (j + 1 < p.length() && p.charAt(j + 1) == '*') {// next char is *
			if (pchar == '.') {
				while (i < s.length()) {
					if (isMatch(s, p, i, j + 2) == true) {
						return true;
					}
					i++;
				}
				return isMatch(s, p, i, j + 2);
			} else {
				while (i < s.length() && pchar == s.charAt(i)) {
					if (isMatch(s, p, i, j + 2) == true) {
						return true;
					}
					i++;
				}
				return isMatch(s, p, i, j + 2);
			}
		} else {// next char is not *: must match current character
			if (i == s.length()) {
				return false;
			}
			if (pchar == '.') {
				return isMatch(s, p, i + 1, j + 1);
			} else {
				if (s.charAt(i) != pchar) {
					return false;
				} else {
					return isMatch(s, p, i + 1, j + 1);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isMatch("aa", "a*"));
	}

}
