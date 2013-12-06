package ImplementstrStr;

/**
 * KMP算法实现,原始串长N，匹配串长M，时间复杂度O(M+N),空间复杂度O(M). 注意原始串不回溯！
 */
public class Solution {
	/**
	 * 时间复杂度O(N),注意原始串不回溯！
	 */
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) {
			return null;
		}
		if (needle.equals("")) {
			return haystack;
		}
		int[] next = this.getNext(needle);
		int i = 0, j = 0;
		while (i < haystack.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
				if (j == needle.length()) {
					return haystack.substring(i - needle.length());
				}
			} else {
				if (next[j] == -1) {
					i++;
					j = 0;
				} else {
					j = next[j];
				}
			}
		}
		return null;
	}

	/**
	 * 计算next数组，时间复杂度O(M)
	 */
	private int[] getNext(String needle) {
		char[] p = needle.toCharArray();
		int i = 0;
		int k = -1;
		int[] next = new int[p.length];
		next[0] = -1;
		while (i < p.length - 1) {
			// 如果p[i]==p[k]，表明前缀与后缀长度都加了1并且依然相等，那么next[i+1]=k+1
			if (k == -1 || p[i] == p[k]) {
				next[++i] = ++k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
