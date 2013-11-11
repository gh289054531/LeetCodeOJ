package DecodeWays;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public int numDecodings(String s) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s == null || s.length() == 0) {
			return 0;
		}
		Pattern p = Pattern.compile("^[1-9][0-9]*$");
		Matcher m = p.matcher(s);
		if (m.matches() == false) {
			return 0;
		}
		int last = 1;
		int lastlast = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') {
					return 0;
				} else {
					int temp = last;
					last = lastlast;
					lastlast = temp;
				}
			} else {
				if (s.charAt(i - 1) == '0') {
					lastlast = last;
					continue;
				}
				if (s.charAt(i - 1) > '2') {
					lastlast = last;
					continue;
				}
				if (s.charAt(i - 1) < '2') {
					int temp = lastlast;
					lastlast = last;
					last += temp;
					continue;
				}
				if (s.charAt(i - 1) == '2') {
					if (s.charAt(i) <= '6') {
						int temp = lastlast;
						lastlast = last;
						last += temp;
					} else {
						lastlast = last;
					}
				}
			}
		}
		return last;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
