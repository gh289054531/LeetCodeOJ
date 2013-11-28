package LongestPalindromicSubstring;

/**
 * ������Ӵ����ⷨ���������ķ�����������Ӵ���ʱ�临�Ӷ�O(N^2) ��������ʱ������
 */
public class Solution1 {
	public String longestPalindrome(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s);
		String rs = sb.reverse().toString();
		return longestCommonSubString(s, rs);
	}

	/**
	 * ����DP��˼�룬���str1[i] = str2[j]����ô�˴��İ���str1[i] ��
	 * str2[j]�����Ӵ��ĳ��ȱ�Ȼ�ǰ���str1[i-1]��str2
	 * [j-1]�Ĺ����Ӵ��ĳ��ȼ�1����ô�������ǿ������¶���lcs(i,j)������lcs(i,j) = lcs(i-1,j-1) +
	 * 1����֮��lcs(i,j) = 0��
	 * 
	 * @param s
	 * @param rs
	 * @return
	 */
	private String longestCommonSubString(String s, String rs) {
		int[][] len = new int[s.length() + 1][s.length() + 1];
		int max = 0;
		int maxi = 0;
		int maxj = 0;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (s.charAt(i - 1) == rs.charAt(j - 1)) {
					len[i][j] = len[i - 1][j - 1] + 1;
					if (len[i][j] > max) {
						max = len[i][j];
						maxi = i;
						maxj = j;
					}
				} else {
					len[i][j] = 0;
				}
			}
		}
		StringBuilder result = new StringBuilder();
		while (len[maxi][maxj] != 0) {
			result.append(s.charAt(maxi - 1));
			maxi--;
			maxj--;
		}
		return result.reverse().toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		System.out.println(s.longestPalindrome("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"));
	}

}
