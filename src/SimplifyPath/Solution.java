package SimplifyPath;

import java.util.ArrayList;

public class Solution {
	public String simplifyPath(String path) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (path == null) {
			return null;
		}
		String[] paths = path.split("/");
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < paths.length; i++) {
			String cur = paths[i];
			if (cur.equals(".") || cur.equals("")) {
				// donothing
			} else if (cur.equals("..")) {
				if (result.size() > 0) {
					result.remove(result.size() - 1);
				}
			} else {
				result.add(cur);
			}
		}
		if (result.size() == 0) {
			return "/";
		} else {
			StringBuilder s = new StringBuilder();
			for (String p : result) {
				s.append("/" + p);
			}
			return s.toString();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.simplifyPath("/a/./b/../../c/"));

	}

}
