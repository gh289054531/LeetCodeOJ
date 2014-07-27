package ReverseWordsinaString;

public class Solution {
	
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.reverseWords(" 1"));
	}
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		char[] result = new char[s.length() + 1];
		int i = 0;
		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		if (i == s.length()) {
			return "";
		}
		i=0;
		int j = s.length() - 1;
		while (true) {
			while (j >= 0 && s.charAt(j) == ' ') {
				j--;
			}
			if (j < 0) {
				i--;
				StringBuilder sb = new StringBuilder();
				for (j = 0; j < i; j++) {
					sb.append(result[j]);
				}
				return sb.toString();
			}
			int m = j;
			while (m >= 0 && s.charAt(m) != ' ') {
				m--;
			}
			int temp = m + 1;
			while (temp <= j) {
				result[i++] = s.charAt(temp++);
			}
			result[i++] = ' ';
			j = m;
		}
	}
}
