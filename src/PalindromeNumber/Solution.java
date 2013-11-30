package PalindromeNumber;

public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int base = 1;
		while (x / base > 9) {
			base *= 10;
		}
		while (x > 9) {
			int low = x % 10;
			int high = x / base;
			if (low != high) {
				return false;
			}
			x -= high * base;
			x /= 10;
			base /= 100;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
