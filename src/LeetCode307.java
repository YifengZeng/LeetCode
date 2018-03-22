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

    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        int oldVal = query(root, i, i);
        modify(root, i, val, oldVal);
    }

    public int sumRange(int i, int j) {
        return query(root, i, j);
    }

    class Node {
        int start;
        int end;
        int sum;
        Node left;
        Node right;
        public Node(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    Node root;

    private Node build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        Node node = new Node(start, end, 0);

        if (start == end) {
            node.sum = nums[start];
            return node;
        }

        int mid = (end - start) / 2 + start;
        node.left = build(nums, start, mid);
        node.right = build(nums, mid + 1, end);
        if (node.left != null) {
            node.sum += node.left.sum;
        }
        if (node.right != null) {
            node.sum += node.right.sum;
        }
        return node;
    }

    private int query(Node root, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start <= root.start && root.end <= end) {
            return root.sum;
        }
        int rootMid = (root.end - root.start) / 2 + root.start;
        if (end <= rootMid) {
            return query(root.left, start, end);
        } else if (rootMid < start) {
            return query(root.right, start, end);
        }
        return query(root.left, start, rootMid) + query(root.right, rootMid + 1, end);
    }

    private void modify(Node root, int i, int val, int oldVal) {
        if (root == null) {
            return;
        }
        root.sum = root.sum - oldVal + val;
        if (root.start == i && root.end == i) {
            return;
        }

        int rootMid = (root.end - root.start) / 2 + root.start;
        if (i <= rootMid) {
            modify(root.left, i, val, oldVal);
        } else {
            modify(root.right, i, val, oldVal);
        }
    }
}
