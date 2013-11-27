package MedianofTwoSortedArrays;

/**
 * ��һ������£�ÿ�ζ���kһ���Ԫ�ر�ɾ���������㷨���Ӷ�Ϊlogk����������λ��ʱkΪ��m+n��/2�������㷨���Ӷ�Ϊlog(m+n)��
 * �������������£��ɾ��ǵ�k / 2 > A.length - startA��ʱ���㷨������һ��ݹ����������������һ�������ͬ��
 */
public class Solution {
	private double findKth(int[] A, int startA, int[] B, int startB, int k) {
		// always assume that A is equal or smaller than B
		if (A.length - startA > B.length - startB) {
			return findKth(B, startB, A, startA, k);
		}
		if (startA == A.length) {
			return B[k - 1];
		}
		if (k == 1) {
			return Math.min(A[startA], B[startB]);
		}
		/*
		 * divide k into two parts,think the difference when k is odd/even Try
		 * to understand the fact that:the k-th elem is either A[startA + passA
		 * - 1] or B[startB + passB - 1]
		 */
		int passA = Math.min(k / 2, A.length - startA);
		int passB = k - passA;
		if (A[startA + passA - 1] < B[startB + passB - 1]) {
			return findKth(A, startA + passA, B, startB, k - passA);
		} else if (A[startA + passA - 1] > B[startB + passB - 1]) {
			return findKth(A, startA, B, startB + passB, k - passB);
		} else {
			return A[startA + passA - 1];
		}
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int len = A.length + B.length;
		if (len % 2 == 1) {
			return findKth(A, 0, B, 0, len / 2 + 1);
		} else {
			double left = findKth(A, 0, B, 0, len / 2);
			double right = findKth(A, 0, B, 0, len / 2 + 1);
			return (left + right) / 2;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = new int[] { 4, 8, 9 };
		int[] B = new int[] { 1, 2, 3, 5, 6, 7, 10 };
		System.out.println(s.findMedianSortedArrays(A, B));
	}

}
