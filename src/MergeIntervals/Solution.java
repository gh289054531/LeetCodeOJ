package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty() == true) {
			return result;
		}
		Collections.sort(intervals, new IntervalComparator());
		for (Interval i : intervals) {
			if (result.isEmpty() == true) {
				result.add(new Interval(i.start, i.end));
			} else {
				Interval j = result.get(result.size() - 1);
				if (j.end >= i.start) {
					if (i.end > j.end) {
						j.end = i.end;
					}
				} else {
					result.add(new Interval(i.start, i.end));
				}
			}
		}
		return result;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

class IntervalComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval a, Interval b) {
		if (a.start < b.start) {
			return -1;
		} else if (a.start > b.start) {
			return 1;
		} else {
			return 0;
		}
	}
}
