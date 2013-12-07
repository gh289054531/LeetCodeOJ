package DivideTwoIntegers;

/**
 * 直接用除数去一个一个加，直到被除数被超过的话，会超时。
 * 解决办法每次将被除数增加1倍，同时将count也增加一倍，如果超过了被除数，那么用被除数减去当前和再继续本操作。
 */
public class Solution {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {// 判断除数为0抛异常
			throw new ArithmeticException("/ by 0");
		}
		long a = dividend;// 这里用long是防止Math.abs时溢出
		long b = divisor;
		boolean sign = true;
		if (a > 0 && b < 0) {// 处理符号位
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
			long temp = b;// 暂时记录除数
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
