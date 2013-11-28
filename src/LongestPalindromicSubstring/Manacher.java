package LongestPalindromicSubstring;

/**
 * ��������Ӵ���manacher�㷨��O(N)ʱ�临�Ӷ�
 * �ο���http://www.cnblogs.com/wuyiqi/archive/2012/06/25/2561063.html
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
		int mx = -1;// mx���ʹ�������Ԫ�ص��±꣬��ο����������²�ͬ����������mxָ����Ԫ�صĺ�һ��λ���±�
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
