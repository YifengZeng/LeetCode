class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> res = new ArrayList<>();
        Interval prev = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start > prev.end) {
                res.add(prev);
                prev = cur;
            } else {
                prev.end = Math.max(prev.end, cur.end);
            }
        }
        res.add(prev);
        return res;
    }
}
