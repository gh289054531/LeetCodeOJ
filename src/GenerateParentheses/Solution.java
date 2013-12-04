package GenerateParentheses;

import java.util.ArrayList;

public class Solution {
	/**
	 * 只要保证任意时刻左括号个数比右括号多，且左括号个数不超过n，就一定是合法的
	 */
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n <= 0) {
			return result;
		}
		recursivelyGenerate(1, 0, new char[n + n], '(', n, result);
		return result;

	}

	private void recursivelyGenerate(int left, int right, char[] cur, char c, int n, ArrayList<String> result) {
		if (right > left || left > n) {// 如果右括号数目比左括号多，或者左括号数目超过n，一定不合法
			return;
		}
		cur[left + right - 1] = c;
		if (left == n && right == left) {
			result.add(new String(cur));
		}
		recursivelyGenerate(left + 1, right, cur, '(', n, result);
		recursivelyGenerate(left, right + 1, cur, ')', n, result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
