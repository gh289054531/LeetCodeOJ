package SearchinRotatedSortedArray;

public class Solution {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		return iterativelySearch(A, target, 0, A.length - 1);
	}

	private int iterativelySearch(int[] A, int target, int left, int right) {
		if (left > right) {// 3�ֻ������֮һ
			return -1;
		}
		if (left == right) {// 3�ֻ������֮��
			return A[left] == target ? left : -1;
		}
		if (right - left == 1) {// 3�ֻ������֮��
			if (A[left] == target) {
				return left;
			} else if (A[right] == target) {
				return right;
			} else {
				return -1;
			}
		}
		int middle = (left + right) / 2;// �ų������ֻ�������󣬱�֤middle��left��right�����
		if (A[middle] == target) {
			return middle;
		} else if (A[middle] > A[left]) {// ��ʱ��left��middle֮��������
			if (A[middle] < target) {
				return iterativelySearch(A, target, middle + 1, right);
			} else {
				if (target == A[left]) {
					return left;
				} else if (target > A[left]) {
					return iterativelySearch(A, target, left + 1, middle - 1);
				} else {
					return iterativelySearch(A, target, middle + 1, right);
				}
			}
		} else {// ��ʱ��middle��right֮��������
			if (A[middle] > target) {
				return iterativelySearch(A, target, left, middle - 1);
			} else {
				if (target == A[right]) {
					return right;
				} else if (target < A[right]) {
					return iterativelySearch(A, target, middle + 1, right - 1);
				} else {
					return iterativelySearch(A, target, left, middle - 1);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
