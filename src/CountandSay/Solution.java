package CountandSay;

public class Solution {
	public String countAndSay(int n) {
		if (n < 1) {
			return "";
		}
		String ns = "1";

		int iter = 0;
		while (iter++ < n - 1) {
			StringBuilder sb = new StringBuilder();
			int i = 0;
			int count = 1;
			while (i < ns.length() - 1) {
				if (ns.charAt(i) == ns.charAt(i + 1)) {
					count++;
				} else {
					sb.append(count + "" + ns.charAt(i));
					count = 1;
				}
				i++;
			}
			sb.append(count + "" + ns.charAt(i));
			ns = sb.toString();
		}
		return ns;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.countAndSay(1));
		System.out.println(s.countAndSay(2));
		System.out.println(s.countAndSay(3));
		System.out.println(s.countAndSay(4));
		System.out.println(s.countAndSay(5));
		System.out.println(s.countAndSay(6));
		System.out.println(s.countAndSay(7));
	}

}
