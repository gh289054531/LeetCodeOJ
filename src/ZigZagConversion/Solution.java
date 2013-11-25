package ZigZagConversion;

public class Solution {
	public String convert(String s, int nRows) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (s == null || s.length() == 0) {
			return s;
		}
		if (nRows == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int delt = nRows + nRows - 2;
		int index = 0;
		for (int i = 0; i < nRows && index < s.length(); i++) {
			if (i == 0 || i == nRows - 1) {
				int cur = i;
				while (cur < s.length()) {
					sb.append(s.charAt(cur));
					index++;
					cur += delt;
				}
			} else {
				int cur = i;
				while (cur < s.length()) {
					sb.append(s.charAt(cur));
					index++;
					int temp = (cur / delt + 1) * delt - cur % delt;
					if (temp < s.length()) {
						sb.append(s.charAt(temp));
						index++;
					}
					cur += delt;
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.convert("PAYPALISHIRING", 3));
	}

}
