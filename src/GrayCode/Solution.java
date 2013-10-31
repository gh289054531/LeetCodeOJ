package GrayCode;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> grayCode(int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(0);
			return result;
		}
		for (int i = 0; i < Math.pow(2, n); i++) {
			String binaryCode = Integer.toBinaryString(i);
			for (int l = binaryCode.length(); l <n; l++) {
				binaryCode = "0" + binaryCode;
			}
			StringBuilder grayCode = new StringBuilder();
			grayCode.append((binaryCode.charAt(0) - '0') ^ 0);
			for (int j = 1; j < n; j++) {
				grayCode.append((binaryCode.charAt(j) - '0') ^ (binaryCode.charAt(j - 1) - '0'));
			}
			result.add(Integer.parseInt(grayCode.toString(), 2));
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ArrayList<Integer> list=s.grayCode(11);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}

}
