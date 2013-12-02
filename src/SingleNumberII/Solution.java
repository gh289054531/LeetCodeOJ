package SingleNumberII;

/**
 * ���ڳ�����һ��֮������е�������������Ʊ�ʾ��ÿһλ1���ֵĴ�����3������������������Щ1���㣬ʣ�µľ������յ�����
 * ��ones��¼����ǰ����ı���Ϊֹ��������1���֡�1�Ρ���mod 3 ֮��� 1������λ��
 * ��twos��¼����ǰ����ı���Ϊֹ��������1���֡�2�Ρ���mod 3 ֮��� 2������λ��
 * ��ones��twos�е�ĳһλͬʱΪ1ʱ��ʾ������1����3�Σ���ʱ��Ҫ���㡣�� �ö�����ģ�������Ƽ��㡣
 * ����ones��¼�������ս���� ʱ�临�Ӷȣ� O��n��
 */
public class Solution {
	public int singleNumber(int[] A) {
		int ones = 0;
		int twos = 0;
		int xthrees = 0;
		for (int i = 0; i < A.length; i++) {
			twos |= ones & A[i];
			ones ^= A[i];
			xthrees = ~(ones & twos);
			ones &= xthrees;
			twos &= xthrees;
		}
		return ones;
	}
}
