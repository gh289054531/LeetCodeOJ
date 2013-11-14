package EditDistance;

public class Solution {
	/**
	 * 动态规划，用d[i][j]表示把word1前面长度为i的子串变成word2前面长度为j的子串需要的步骤,明显有d[0][j]=j,d[i][0]=
	 * i。 对于d[i][j]有几种情况: 如果word1[i]==word2[j]那么不需要任何步骤，也就是d[i][j]=d[i-1][j-1]；
	 * 如果word1[i]！=word2[j]，对word1有三种方式： 1.替换操作，d[i][j]=d[i-1][j-1]+1;
	 * 2.插入操作，d[i][j]=d[i][j-1]+1; 3.删除操作，d[i][j]=d[i-1][j]+1;
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (word1 == null || word2 == null) {
			return 0;
		}
		if (word1.length() == 0) {
			return word2.length();
		}
		if (word2.length() == 0) {
			return word1.length();
		}
		int[][] d = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			d[i][0] = i;
		}
		for (int i = 0; i <= word2.length(); i++) {
			d[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					int temp1 = d[i - 1][j - 1] + 1;
					int temp2 = d[i - 1][j] + 1;
					int temp3 = d[i][j - 1] + 1;
					d[i][j] = Math.min(Math.min(temp1, temp2), temp3);
				}
			}
		}
		return d[word1.length()][word2.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
