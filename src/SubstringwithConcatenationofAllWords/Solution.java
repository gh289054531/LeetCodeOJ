package SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || L == null) {
			return result;
		}
		int LWordLength = L[0].length();
		if (S.length() < L.length * LWordLength) {
			return result;
		}
		HashMap<String, Integer> LMap = new HashMap<String, Integer>();
		for (String l : L) {// ��Lת��Ϊhash��
			if (LMap.containsKey(l)) {// ����L���ظ����ֵ��ַ���
				LMap.put(l, LMap.get(l) + 1);
			} else {
				LMap.put(l, 1);
			}
		}
		for (int i = 0; i <= S.length() - LWordLength * L.length; i++) {// ��S��ͷ��ʼ����ƥ��
			for (int j = 0; j < L.length; j++) {
				String substr = S.substring(i + LWordLength * j, i + LWordLength * j + LWordLength);
				if (LMap.containsKey(substr)) {
					int count = LMap.get(substr);
					if (count > 0) {
						LMap.put(substr, count - 1);
					} else {
						for (int m = 0; m < j; m++) {// �ָ�����
							String recover = S.substring(i + LWordLength * m, i + LWordLength * m + LWordLength);
							LMap.put(recover, LMap.get(recover) + 1);
						}
						break;
					}
					if (j == L.length - 1) {
						result.add(i);// ƥ��ɹ�
						for (int m = 0; m <= j; m++) {// �ָ�����
							String recover = S.substring(i + LWordLength * m, i + LWordLength * m + LWordLength);
							LMap.put(recover, LMap.get(recover) + 1);
						}
					}
				} else {
					for (int m = 0; m < j; m++) {// �ָ�����
						String recover = S.substring(i + LWordLength * m, i + LWordLength * m + LWordLength);
						LMap.put(recover, LMap.get(recover) + 1);
					}
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
	}
}
