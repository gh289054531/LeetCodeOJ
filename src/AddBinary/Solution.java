package AddBinary;

import java.math.BigInteger;

public class Solution {
	public String addBinary(String a, String b) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (a == null || b == null || a.length() == 0 || b.length() == 0) {
			return null;
		}
		BigInteger a1 = new BigInteger(a, 2);
		BigInteger a2 = new BigInteger(b, 2);
		BigInteger sum = a1.add(a2);
		return sum.toString(2);
	}

	public static void main(String[] args) {

	}

}
