package LongestPalindromicSubstring;

/**
 * ���ﶯ̬�滮��˼·�� dp[i][j] ��ʾ���� ��i �� j ���ִ����Ƿ��ǻ��Ĵ��� ����ݻ��ĵĹ������ǿ���֪���� ���s[i] == s[j]
 * ��ô�Ƿ��ǻ��ľ����� dp[i+1][ j - 1] �� s[i] != s[j] ��ʱ�� dp[i][j] ֱ�Ӿ��� false��
 * ��̬�滮�Ľ����ǰ����ַ����ĳ��ȴ�1 �� n�ƽ��ġ� ���������������java���룬���Ӷ� O(n^2)
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
