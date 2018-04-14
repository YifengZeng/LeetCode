public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<>();

    int i = 0;
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
        result.add(intervals.get(i));
        i++;
    }
    if (i < intervals.size()) {
        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
    }
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
        newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        i++;
    }
    result.add(newInterval);
    while (i < intervals.size()) {
        result.add(intervals.get(i));
        i++;
    }
    return result;
}



class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new ArrayList<>();

    int i = 0;
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
        res.add(intervals.get(i++));
    }

    while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        i++;
    }

    res.add(newInterval);

    while (i < intervals.size()) {
        res.add(intervals.get(i++));
    }
    return res;
  }
}
