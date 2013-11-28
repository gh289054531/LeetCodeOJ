package LongestPalindromicSubstring;

/**
 * ������Ӵ���O(N^2)
 * ���Ĵ���2�У��������Ⱥ�ż�����ȡ��������������ÿ��λ�÷ֱ��������������������������ͬʱ����������ƶ����Ƚϣ���¼���λ�á�
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
		for (int i = 0; i < s.length() - 1; i++) {// ע������i����<s.length����<s.length-1,˼��Ϊʲô
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
