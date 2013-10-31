package RomantoInteger;

public class Solution {
	public int getValue(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public int romanToInt(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int sum = 0;
		int length = s.length();
		char c, next;
		for (int i = 0; i < length; i++) {
			c = s.charAt(i);
			if (i != length - 1) {
				next = s.charAt(i + 1);
				int cValue = getValue(c);
				int nextValue = getValue(next);
				int diff = nextValue - cValue;
				if (diff <= 0) {
					sum += cValue;
				} else {
					sum += diff;
					i++;
				}

			} else {
				sum += getValue(c);
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 = "DXXIII";
		Solution s = new Solution();
		System.out.println(s.romanToInt(test1));
	}

}
