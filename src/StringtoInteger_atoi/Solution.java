package StringtoInteger_atoi;

public class Solution {
	public int atoi(String str) {
		if (str == null) {// �ж�null
			return 0;
		}
		str = str.trim();// ȥ�����˿ո�
		if (str.length() == 0) {
			return 0;
		}
		// �жϷ���
		int sign = 1;
		if (str.charAt(0) == '-') {
			sign = -1;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			str = str.substring(1);
		}
		int numLen = 0;
		int i = 0;
		for (; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)) == false) {
				break;
			}
			numLen++;
		}
		if (numLen == 0) { // �ж���Ч����λ��
			return 0;
		}
		int result = 0;
		try {// ת��
			if (sign == -1) {
				result = Integer.parseInt("-" + str.substring(0, i));
			} else {
				result = Integer.parseInt(str.substring(0, i));
			}
		} catch (Exception e) {
			if (sign == 1) {
				result = Integer.MAX_VALUE;
			} else {
				result = Integer.MIN_VALUE;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.atoi("-1"));
	}

}
