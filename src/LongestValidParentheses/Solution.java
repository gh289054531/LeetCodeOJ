package LongestValidParentheses;

import java.util.Stack;

public class Solution {
	public int longestValidParentheses(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int max = 0, last = -1;
		Stack<Integer> lefts = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				lefts.push(i);
			} else {
				if (lefts.isEmpty() == true) {// no matching left
					last = i;
				} else { // find a matching pair
					lefts.pop();
					if (lefts.isEmpty() == true) {// ��һ��������valid��group�������group�ĳ���
						max = Math.max(max, i - last);
					} else {
						max = Math.max(max, i - lefts.peek());// ջ�ڻ��С�(',һ�������������group��û��ƥ����ɣ�����ͨ����ѯ��һ������ƥ�仹δƥ���"("��index������maxLen��
					}
				}
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.longestValidParentheses("()(())"));
	}

}
