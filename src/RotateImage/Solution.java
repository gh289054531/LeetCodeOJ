package RotateImage;

/**
 * ��ͼƬ��ת90�ȣ�ʵ���Ͼ��ǰ�ԭ����[i][j]�ŵ���[j][n-1-i] ��������ʱ���󣬿���������Ȧ������Ȧ�ݹ���ת��
 * ����ÿ���㣬һ����Ҫ������ת4�Ρ�
 * ���¹�ʽ�ǣ�[i][j]=[n-1-j][i],�������СnΪ5��matrix[2][3]=matrix[1][2],����ԭ��
 * [1][2]λ�õ�Ԫ�طŵ�[2][3]λ�á�
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
		for (int i = left; i < right; i++) {// ���¹�ʽmatrix[i][j]=maxtrix[right-j+left][i]
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
