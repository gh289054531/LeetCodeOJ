package SingleNumberII;

/**
 * 对于除出现一次之外的所有的整数，其二进制表示中每一位1出现的次数是3的整数倍，将所有这些1清零，剩下的就是最终的数。
 * 用ones记录到当前计算的变量为止，二进制1出现“1次”（mod 3 之后的 1）的数位。
 * 用twos记录到当前计算的变量为止，二进制1出现“2次”（mod 3 之后的 2）的数位。
 * 当ones和twos中的某一位同时为1时表示二进制1出现3次，此时需要清零。即 用二进制模拟三进制计算。
 * 最终ones记录的是最终结果。 时间复杂度： O（n）
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
