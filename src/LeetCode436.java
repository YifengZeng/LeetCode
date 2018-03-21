class Solution {
    class Point {
        int i;
        int isStart;
        int intervalIndex;
        public Point(int i, int isStart, int intervalIndex) {
            this.i = i;
            this.isStart = isStart; // 1 is true, 0 is false
            this.intervalIndex = intervalIndex;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        List<Point> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Point(intervals[i].start, 1, i));
            list.add(new Point(intervals[i].end, 0, i));
            min = Math.min(min, intervals[i].start);
            max = Math.max(max, intervals[i].end);
        }

        Collections.sort(list, (a, b) -> (a.i == b.i) ?
                         a.isStart - b.isStart : a.i - b.i);

        int[] res = new int[intervals.length];
        int rightInterval = -1;
        for (int i = list.size() - 1; i >= 0; i--) {
            Point cur = list.get(i);
            if (cur.isStart == 0) {
                res[cur.intervalIndex] = rightInterval;
            } else {
                rightInterval = cur.intervalIndex;
            }
        }
        return res;
    }
}




class Solution {
    // AC
    class Point {
        int i;
        int intervalIndex;
        public Point(int i, int index) {
            this.i = i;
            this.intervalIndex = index;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        List<Point> start = new ArrayList<>();
        List<Point> end = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            start.add(new Point(intervals[i].start, i));
            end.add(new Point(intervals[i].end, i));
        }

        Collections.sort(start, (a, b) -> a.i - b.i);
        Collections.sort(end, (a, b) -> a.i - b.i);
        int[] res = new int[intervals.length];
        Arrays.fill(res, -1);
        int j = 0;
        for (int i = 0; i < end.size(); i++) {
            Point pointEnd = end.get(i);
            while (j < start.size() && pointEnd.i > start.get(j).i) {
                j++;
            }
            if (j >= start.size()) {
                break;
            }
            res[pointEnd.intervalIndex] = start.get(j).intervalIndex;
        }
        return res;
    }
}




class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> relationships = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            relationships.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry =
                relationships.ceilingEntry(intervals[i].end);
            res[i] = entry == null ? -1 : entry.getValue();
        }

        return res;
    }
}





class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i].start);
            max = Math.max(max, intervals[i].end);
        }

        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, -1);
        for (int i = 0; i < intervals.length; i++) {
            bucket[intervals[i].start - min] = i;
        }

        for (int i = bucket.length - 2; i >= 0; i--) {
            if (bucket[i] == -1) {
                bucket[i] = bucket[i + 1];
            }
        }

        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            res[i] = bucket[intervals[i].end - min];
        }

        return res;
    }
}
