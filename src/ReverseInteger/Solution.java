package ReverseInteger;

/*
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Have you thought about this?
 Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 */
public class Solution {
	public int reverse(int x) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (x == 0) {
			return 0;
		}
		String flag = "+";
		if (x < 0) {
			flag = "-";
			x = 0 - x;
		}
		StringBuilder s = new StringBuilder(String.valueOf(x));
		s = s.reverse();
		while (s.charAt(0) == '0') {
			s.deleteCharAt(0);
		}
		if (flag.equals("-")) {
			return Integer.parseInt(flag + s.toString());
		} else {
			return Integer.parseInt(s.toString());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x1 = 123;
		int x2 = -321;
		int x3 = 0;
		int x4 = 110;
		int x5 = -100;
		int x6 = 1;
		Solution s = new Solution();
		System.out.println(s.reverse(x1));
		System.out.println(s.reverse(x2));
		System.out.println(s.reverse(x3));
		System.out.println(s.reverse(x4));
		System.out.println(s.reverse(x5));
		System.out.println(s.reverse(x6));
	}

}
