package TextJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		String[] test = new String[] { "This", "is", "an", "example", "of", "text", "justification." };
		Solution s = new Solution();
		System.out.println(s.fullJustify(test, 16));
	}

	public List<String> fullJustify(String[] words, int L) {
		List<String> result = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return result;
		}
		int len = words.length;
		int index = 0;
		int preIndex = 0;
		int lenSum = 0;
		while (index < len) {
			if (lenSum + words[index].length() > L) {
				index--;
				int wordNum = index - preIndex + 1;
				lenSum -= wordNum;
				if (wordNum == 1) {
					int spaceNum = L - words[preIndex].length();
					StringBuilder sb = new StringBuilder();
					sb.append(words[preIndex]);
					for (int i = 0; i < spaceNum; i++) {
						sb.append(" ");
					}
					result.add(sb.toString());
				} else {
					int spaceNum = (L - lenSum) / (wordNum - 1);
					int extraSpaceNum = (L - lenSum) % (wordNum - 1);
					StringBuilder sb = new StringBuilder();
					for (int i = preIndex; i < index; i++) {
						sb.append(words[i]);
						for (int j = 0; j < spaceNum; j++) {
							sb.append(" ");
						}
						if (extraSpaceNum > 0) {
							sb.append(" ");
							extraSpaceNum--;
						}
					}
					sb.append(words[index]);
					result.add(sb.toString());
				}
				lenSum = 0;
				index++;
				preIndex = index;
			} else {
				lenSum += words[index].length() + 1;
				index++;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (preIndex < len) {
			if (preIndex != len - 1) {
				sb.append(words[preIndex] + " ");
			} else {
				sb.append(words[preIndex]);
			}
			preIndex++;
		}
		String temp = sb.toString();
		sb = new StringBuilder();
		for (int i = temp.length(); i < L; i++) {
			sb.append(" ");
		}
		result.add(temp + sb.toString());
		return result;
	}
}