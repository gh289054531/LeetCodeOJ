package ValidSudoku;

import java.util.HashMap;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>(20);
		resume(map);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				Integer count = map.get(board[i][j]);
				if (count == 1) {
					map.put(board[i][j], 0);
				} else {
					return false;
				}
			}
			resume(map);
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[j][i] == '.') {
					continue;
				}
				Integer count = map.get(board[j][i]);
				if (count == 1) {
					map.put(board[j][i], 0);
				} else {
					return false;
				}
			}
			resume(map);
		}
		for (int i = 1; i <= 7; i += 3) {
			for (int j = 1; j <= 7; j += 3) {
				for (int m = i - 1; m <= i + 1; m++) {
					for (int n = j - 1; n <= j + 1; n++) {
						if (board[m][n] == '.') {
							continue;
						}
						Integer count = map.get(board[m][n]);
						if (count == 1) {
							map.put(board[m][n], 0);
						} else {
							return false;
						}
					}
				}
				resume(map);
			}
		}
		return true;
	}

	private void resume(HashMap<Character, Integer> map) {
		map.put('1', 1);
		map.put('2', 1);
		map.put('3', 1);
		map.put('4', 1);
		map.put('5', 1);
		map.put('6', 1);
		map.put('7', 1);
		map.put('8', 1);
		map.put('9', 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		solution.isValidSudoku(new char[][] { { '.', '.', '5', '.', '.', '.', '.', '.', '6' }, { '.', '.', '5', '.', '.', '.', '.', '.', '6' }, { '.', '.', '5', '.', '.', '.', '.', '.', '6' }, { '.', '.', '5', '.', '.', '.', '.', '.', '6' }, { '.', '.', '5', '.', '.', '.', '.', '.', '6' }, { '.', '.', '5', '.', '.', '.', '.', '.', '6' }, { '.', '.', '5', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '5', '.', '.', '.', '.', '.', '6' }, { '.', '.', '5', '.', '.', '.', '.', '.', '6' }, });
	}

}
