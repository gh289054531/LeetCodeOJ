package ValidParentheses;

import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		if (s == null || s.length() % 2 == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					char top = stack.pop();
					if ((top == '(' && s.charAt(i) != ')') || (top == '[' && s.charAt(i) != ']') || (top == '{' && s.charAt(i) != '}')) {
						return false;
					}
				}
			}
		}
		return stack.isEmpty() ? true : false; // 注意这里还要判断下栈是否空！
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isValid("()"));
	}

}
