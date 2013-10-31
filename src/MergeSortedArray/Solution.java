package MergeSortedArray;

public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			A[k--] = A[i] > B[j] ? A[i] : B[j];
			i--;
			j--;
		}
		while (j >= 0) {
			A[k--] = A[j--];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
