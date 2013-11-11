package WordSearch;

public class Solution {

	public boolean exist(char[][] board, String word) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (word == null || word.equals("")) {
			return true;
		}
		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (judge(word, 0, board, i, j, used) == true) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean judge(String word, int wordIndex, char[][] board, int row, int col, boolean[][] used) {
		if (wordIndex >= word.length()) {
			return true;
		}
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || used[row][col] == true) {
			return false;
		}
		char c = board[row][col];
		if (c == word.charAt(wordIndex)) {
			used[row][col] = true;
			boolean flag = false;
			flag = flag | judge(word, wordIndex + 1, board, row + 1, col, used);
			if (flag == true) {
				return true;
			}
			flag = flag | judge(word, wordIndex + 1, board, row, col + 1, used);
			if (flag == true) {
				return true;
			}
			flag = flag | judge(word, wordIndex + 1, board, row - 1, col, used);
			if (flag == true) {
				return true;
			}
			flag = flag | judge(word, wordIndex + 1, board, row, col - 1, used);
			if (flag == false) {
				used[row][col] = false;
			}
			return flag;
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
