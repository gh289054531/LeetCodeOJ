package WordLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
	// Note that find operation of HashSet is O(1),so when word length is
	// small,this method has good perfomance
	private HashSet<String> checkDist(String a, HashSet<String> dict) {
		HashSet<String> result = new HashSet<String>();
		for (int i = 0; i < a.length(); i++) {
			StringBuilder sb = new StringBuilder(a);
			for (char c = 'a'; c <= 'z'; c++) {
				sb.setCharAt(i, c);
				String t = sb.toString();
				if (dict.contains(t) && !t.equals(a)) {
					result.add(t);
				}
			}
		}
		return result;
	}

	public int ladderLength(String start, String end, HashSet<String> dict) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();
		dict.add(start);
		dict.add(end);
		Iterator<String> iter = dict.iterator();
		while (iter.hasNext()) {
			String cur = iter.next();
			HashSet<String> adjcent = checkDist(cur, dict);
			graph.put(cur, adjcent);
		}
		HashSet<String> prelevel = new HashSet<String>();
		HashSet<String> postlevel = new HashSet<String>();
		HashSet<String> visit = new HashSet<String>();
		prelevel.add(start);
		visit.add(start);
		int depth = 0;
		while (prelevel.isEmpty() == false) {
			for (String curV : prelevel) {
				if (curV.equals(end)) {
					return depth + 1;
				}
				for (String v : graph.get(curV)) {
					if (visit.contains(v) == false) {
						postlevel.add(v);
						visit.add(v);
					}
				}

			}
			depth++;
			prelevel = postlevel;
			postlevel = new HashSet<String>();
		}
		return 0;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		HashSet<String> dict = new HashSet<>();
		/*
		 * dict.add("a"); dict.add("b"); dict.add("c");
		 * System.out.println(s.ladderLength("a", "c", dict));
		 */

		dict.add("miss");
		dict.add("dusk");
		dict.add("kiss");
		dict.add("musk");
		dict.add("tusk");
		dict.add("diss");
		dict.add("disk");
		dict.add("sang");
		dict.add("ties");
		dict.add("muss");
		System.out.println(s.ladderLength("kiss", "tusk", dict));

	}
}
