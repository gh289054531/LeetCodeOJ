package LongestPalindromicSubstring;

/**
 * 这里动态规划的思路是 dp[i][j] 表示的是 从i 到 j 的字串，是否是回文串。 则根据回文的规则我们可以知道： 如果s[i] == s[j]
 * 那么是否是回文决定于 dp[i+1][ j - 1] 当 s[i] != s[j] 的时候， dp[i][j] 直接就是 false。
 * 动态规划的进行是按照字符串的长度从1 到 n推进的。 代码很明晰：给出java代码，复杂度 O(n^2)
 */
public class Solution2 {
	public String longestPalindrome(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (s == null || s.length() == 0) {
			return s;
		}
		int maxleft = 0, maxright = 0;
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			isPalindrome[i][i] = true;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				isPalindrome[i][i + 1] = true;
				if (maxright - maxleft + 1 < 2) {
					maxleft = i;
					maxright = i + 1;
				}
			}
		}
		for (int k = 2; k < s.length(); k++) {
			for (int i = 0; i < s.length() - k; i++) {
				int j = i + k;
				if (s.charAt(i) == s.charAt(j)) {
					if (isPalindrome[i + 1][j - 1] == true) {
						isPalindrome[i][j] = true;
						if (maxright - maxleft + 1 < k + 1) {
							maxleft = i;
							maxright = j;
						}
					}
				}
			}
		}
		return s.substring(maxleft, maxright + 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
