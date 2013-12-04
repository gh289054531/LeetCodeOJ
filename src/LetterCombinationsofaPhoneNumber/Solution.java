package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;

public class Solution {
	public static String[] DigitToLetter = new String[] { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			result.add("");
			return result;
		}
		dfs(digits, 0, "", result);
		return result;
	}

	private void dfs(String digits, int index, String combination, ArrayList<String> result) {
		if (index == digits.length()) {
			result.add(combination);
			return;
		}
		for (int i = 0; i < DigitToLetter[digits.charAt(index) - '0'].length(); i++) {
			dfs(digits, index + 1, combination + DigitToLetter[digits.charAt(index) - '0'].charAt(i), result);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
