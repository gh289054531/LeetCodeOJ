package DivideTwoIntegers;

/**
 * ֱ���ó���ȥһ��һ���ӣ�ֱ���������������Ļ����ᳬʱ��
 * ����취ÿ�ν�����������1����ͬʱ��countҲ����һ������������˱���������ô�ñ�������ȥ��ǰ���ټ�����������
 */
public class Solution {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {// �жϳ���Ϊ0���쳣
			throw new ArithmeticException("/ by 0");
		}
		long a = dividend;// ������long�Ƿ�ֹMath.absʱ���
		long b = divisor;
		boolean sign = true;
		if (a > 0 && b < 0) {// �������λ
			sign = false;
			b = Math.abs(b);
		} else if (a < 0 && b > 0) {
			sign = false;
			a = Math.abs(a);
		} else {
			b = Math.abs(b);
			a = Math.abs(a);
		}
		long result = 0;
		while (a >= b) {
			long count = 1;
			long temp = b;// ��ʱ��¼����
			while (a >= temp + temp) {
				temp += temp;
				count += count;
			}
			result += count;
			a -= temp;
		}
		if (sign == true) {
			return (int) result;
		} else {
			return 0 - (int) result;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.divide(-1, 1));
	}

}
