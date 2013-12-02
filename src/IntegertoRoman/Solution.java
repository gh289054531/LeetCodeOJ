package IntegertoRoman;

public class Solution {
	public String intToRoman(int num) {
		int i = 1;
		String result = "";
		while (num != 0) {
			result = choose(i, num % 10) + result;
			i++;
			num /= 10;
		}
		return result;
	}

	private String choose(int weishu, int value) {
		String[] roma10Num = new String[] { "I", "X", "C", "M" };
		String[] roma5Num = new String[] { "V", "L", "D" };
		String retVal = "";
		if (value < 4) {
			for (int i = 0; i < value; i++) {
				retVal += roma10Num[weishu - 1];
			}
		} else if (value == 4) {
			retVal = roma10Num[weishu - 1] + roma5Num[weishu - 1];
		} else if (value < 9) {
			retVal = roma5Num[weishu - 1];
			for (int i = 0; i < value - 5; i++) {
				retVal += roma10Num[weishu - 1];
			}
		} else {
			retVal = roma10Num[weishu - 1] + roma10Num[weishu];
		}
		return retVal;
	}
}
