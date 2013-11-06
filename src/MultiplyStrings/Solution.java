package MultiplyStrings;

import java.math.BigInteger;

public class Solution {
	public String multiply(String num1, String num2) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		BigInteger i1 = new BigInteger(num1);
		BigInteger i2 = new BigInteger(num2);
		return i1.multiply(i2).toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
