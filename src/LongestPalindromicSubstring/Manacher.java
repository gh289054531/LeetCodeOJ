package LongestPalindromicSubstring;

/**
 * 求最长回文子串，manacher算法，O(N)时间复杂度
 * 参考：http://www.cnblogs.com/wuyiqi/archive/2012/06/25/2561063.html
 */
public class Manacher {
	public String longestPalindrome(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i) + "#");
		}
		s = sb.toString();
		int[] p = new int[s.length()];
		int i = 0;
		int mx = -1;// mx访问过的最右元素的下标，与参考的网上文章不同，网上文章mx指最右元素的后一个位置下标
		int id = 0;
		for (i = 0; i < s.length(); i++) {
			if (mx > i) {
				p[i] = Math.min(p[2 * id - i], mx - i + 1);
			} else {
				p[i] = 1;
			}
			while (i + p[i] < s.length() && i - p[i] >= 0 && s.charAt(i + p[i]) == s.charAt(i - p[i])) {
				p[i] += 1;
			}
			if (p[i] + i - 1 > mx) {
				mx = p[i] + i - 1;
				id = i;
			}
		}
		int max = 0;
		int maxIndex = 0;
		for (i = 0; i < p.length; i++) {
			if (p[i] > max) {
				max = p[i];
				maxIndex = i;
			}
		}
		String temp = s.substring(maxIndex - p[maxIndex] + 1, maxIndex + p[maxIndex]);
		sb = new StringBuilder();
		for (i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) != '#') {
				sb.append(temp.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manacher s = new Manacher();
		System.out.println(s.longestPalindrome("waabwswfd"));
	}

}
