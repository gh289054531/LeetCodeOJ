package RotateImage;

/**
 * 把图片旋转90度，实际上就是把原来的[i][j]放到了[j][n-1-i] 而且输入时方阵，可以有最外圈向最内圈递归旋转。
 * 对于每个点，一共需要级联旋转4次。
 * 更新公式是：[i][j]=[n-1-j][i],比如设大小n为5，matrix[2][3]=matrix[1][2],即把原来
 * [1][2]位置的元素放到[2][3]位置。
 */
public class Solution {
	public void rotate(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int left = 0, right = matrix[0].length - 1;
		rotate(matrix, left, right);
	}

	private void rotate(int[][] matrix, int left, int right) {
		if (left >= right) {
			return;
		}
		for (int i = left; i < right; i++) {// 更新公式matrix[i][j]=maxtrix[right-j+left][i]
			int temp = matrix[left][i];
			matrix[left][i] = matrix[right - i + left][left];
			matrix[right - i + left][left] = matrix[right][right - i + left];
			matrix[right][right - i + left] = matrix[i][right];
			matrix[i][right] = temp;
		}
		rotate(matrix, left + 1, right - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] test = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		s.rotate(test);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(test[i][j] + " ");
			}
			System.out.println();
		}
	}
}
