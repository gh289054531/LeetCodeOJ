package InsertInterval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null || newInterval == null) {
			return new ArrayList<Interval>();
		}
		if (intervals.isEmpty() == true) {
			intervals.add(newInterval);
			return intervals;
		}
		if (intervals.get(0).start > newInterval.end) {
			intervals.add(0, newInterval);
			return intervals;
		}
		Iterator<Interval> iter = intervals.iterator();
		while (iter.hasNext()) {
			Interval i = iter.next();
			if ((newInterval.start >= i.start && newInterval.start <= i.end) || (newInterval.end >= i.start && newInterval.end <= i.end) || (newInterval.start < i.start && newInterval.end > i.end)) {
				newInterval.start = Math.min(i.start, newInterval.start);
				newInterval.end = Math.max(i.end, newInterval.end);
				iter.remove();
			}
		}
		int i = 0;
		for (; i < intervals.size(); i++) {
			if (intervals.get(i).start >= newInterval.start) {
				break;
			}
		}
		intervals.add(i, newInterval);
		return intervals;
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
