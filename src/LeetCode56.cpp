class Solution {
public:
    vector<Interval> merge(vector<Interval>& intervals) {
        if (intervals.empty()) {
            return intervals;
        }
        vector<Interval> res;
        sort(intervals.begin(), intervals.end(),
             [](Interval a, Interval b){return a.start < b.start;});
        Interval pre = intervals[0];
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals[i];
            if (cur.start > pre.end) {
                res.push_back(pre);
                pre = cur;
            } else {
                pre.end = max(pre.end, cur.end);
            }
        }
        res.push_back(pre);

        return res;
    }
};
