package GenerateParentheses;

import java.util.ArrayList;

public class Solution {
	/**
	 * ֻҪ��֤����ʱ�������Ÿ����������Ŷ࣬�������Ÿ���������n����һ���ǺϷ���
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
		if (right > left || left > n) {// �����������Ŀ�������Ŷ࣬������������Ŀ����n��һ�����Ϸ�
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
