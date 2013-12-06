package ImplementstrStr;

/**
 * KMP�㷨ʵ��,ԭʼ����N��ƥ�䴮��M��ʱ�临�Ӷ�O(M+N),�ռ临�Ӷ�O(M). ע��ԭʼ�������ݣ�
 */
public class Solution {
	/**
	 * ʱ�临�Ӷ�O(N),ע��ԭʼ�������ݣ�
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
	 * ����next���飬ʱ�临�Ӷ�O(M)
	 */
	private int[] getNext(String needle) {
		char[] p = needle.toCharArray();
		int i = 0;
		int k = -1;
		int[] next = new int[p.length];
		next[0] = -1;
		while (i < p.length - 1) {
			// ���p[i]==p[k]������ǰ׺���׺���ȶ�����1������Ȼ��ȣ���ônext[i+1]=k+1
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
