class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        vector<Interval> res;
        int i = 0;
        while (i < intervals.size() && intervals[i].end < newInterval.start) {
            res.push_back(intervals[i++]);
        }

        while (i < intervals.size() && intervals[i].start <= newInterval.end) {
            newInterval.start = min(newInterval.start, intervals[i].start);
            newInterval.end = max(newInterval.end, intervals[i].end);
            i++;
        }

        res.push_back(newInterval);

        while (i < intervals.size()) {
            res.push_back(intervals[i++]);
        }

        return res;
    }
};
