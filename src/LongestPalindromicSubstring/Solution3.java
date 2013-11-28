package LongestPalindromicSubstring;

/**
 * 最长回文子串，O(N^2)
 * 回文串有2中，奇数长度和偶数长度。这里对于输入中每个位置分别检测上述两种情况，具体做法是同时向左和向右移动并比较，记录最长的位置。
 */
public class Solution3 {
	public String longestPalindrome(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (s == null || s.length() == 0) {
			return s;
		}
		int maxleft = 0, maxright = 0;
		int left = 0, right = 0;
		for (int i = 0; i < s.length() - 1; i++) {// 注意这里i不是<s.length而是<s.length-1,思考为什么
			left = i;
			right = i;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			left++;
			right--;
			if (maxright - maxleft < right - left) {
				maxright = right;
				maxleft = left;
			}
			left = i;
			right = i + 1;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			left++;
			right--;
			if (maxright - maxleft < right - left) {
				maxright = right;
				maxleft = left;
			}
		}
		return s.substring(maxleft, maxright + 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 s = new Solution3();
		System.out.println(s.longestPalindrome("ccc"));
	}

}
