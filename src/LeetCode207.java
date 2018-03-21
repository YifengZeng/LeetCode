class NumArray {
    // TLE
    int[] prefixSum;
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }

    public void update(int i, int val) {
        int oldValue = sumRange(i, i);
        for (int j = i + 1; j < prefixSum.length; j++) {
            prefixSum[j] = prefixSum[j] - oldValue + val;
        }
    }

    public int sumRange(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }
}




class NumArray {

    SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length - 1);
        // print(root);
    }

    public void update(int i, int val) {
        // print(root);
        modify(root, i, val);
        // print(root);
    }

    public int sumRange(int i, int j) {
        return query(root, i, j);
    }

    class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = null;
            this.right = null;
        }
    }

    private SegmentTreeNode build(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, arr[start]);
        }

        int mid = (end - start) / 2 + start;
        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        node.left = build(arr, start, mid);
        node.right = build(arr, mid + 1, end);
        if (node.left != null) {
            node.sum += node.left.sum;
        }
        if (node.right != null) {
            node.sum += node.right.sum;
        }
        return node;
    }

    private int query(SegmentTreeNode cur, int start, int end) {
        if (cur == null || start > end) {
            return 0;
        }
        if (start <= cur.start && cur.end <= end) {
            return cur.sum;
        }

        int mid = (cur.end - cur.start) / 2 + cur.start;
        if (end <= mid) {
            return query(cur.left, start, end);
        } else if (start > mid) {
            return query(cur.right, start, end);
        }
        return query(cur.left, start, mid) + query(cur.right, mid + 1, end);
    }

    private int modify(SegmentTreeNode cur, int i, int val) {
        if (cur == null) {
            return 0;
        }
        if (i == cur.start && i == cur.end) {
            int oldValue = cur.sum;
            cur.sum = val;
            return oldValue;
        }

        int mid = (cur.end - cur.start) / 2 + cur.start;
        int oldValue = 0;
        if (cur.start <= i && i <= mid) {
            oldValue = modify(cur.left, i, val);
        } else if (mid + 1 <= i && i <= cur.end) {
            oldValue = modify(cur.right, i, val);
        }
        cur.sum = cur.sum - oldValue + val;
        return oldValue;
    }

    // private void print(SegmentTreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //
    //     System.out.println(root.start + "," + root.end + ", " + root.sum);
    //     print(root.left);
    //     print(root.right);
    // }
}
