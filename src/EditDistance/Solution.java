package EditDistance;

public class Solution {
	/**
	 * ��̬�滮����d[i][j]��ʾ��word1ǰ�泤��Ϊi���Ӵ����word2ǰ�泤��Ϊj���Ӵ���Ҫ�Ĳ���,������d[0][j]=j,d[i][0]=
	 * i�� ����d[i][j]�м������: ���word1[i]==word2[j]��ô����Ҫ�κβ��裬Ҳ����d[i][j]=d[i-1][j-1]��
	 * ���word1[i]��=word2[j]����word1�����ַ�ʽ�� 1.�滻������d[i][j]=d[i-1][j-1]+1;
	 * 2.���������d[i][j]=d[i][j-1]+1; 3.ɾ��������d[i][j]=d[i-1][j]+1;
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
