package ClimbingStairs;

public class Solution {

	public int climbStairs(int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (n <= 2) {
			return n;
		}
		int[] ways = new int[n];
		ways[0] = 1;
		ways[1] = 2;
		for (int i = 2; i < n; i++) {
			ways[i] = ways[i - 2] + ways[i - 1];
		}
		return ways[n-1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.climbStairs(1));
		System.out.println(s.climbStairs(2));
		System.out.println(s.climbStairs(3));
		System.out.println(s.climbStairs(4));
		System.out.println(s.climbStairs(38));
	}

}
