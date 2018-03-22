class Solution {
    class TreeNode {
        int val;
        int count;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.count = 1;
            this.left = null;
            this.right = null;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            res.add(countWithInsert(root, nums[i]));
        }
        Collections.reverse(res);
        return res;
    }

    private int countWithInsert(TreeNode node, int value) {
        int sum = 0;
        while (node != null) {
            if (value <= node.val) {
                node.count += 1;
                if (node.left == null) {
                    node.left = new TreeNode(value);
                    break;
                }
                node = node.left;
            } else {
                sum += node.count;
                if (node.right == null) {
                    node.right = new TreeNode(value);
                    break;
                }
                node = node.right;
            }
        }
        return sum;
    }
}



// segment tree
class Solution {

    class Node {
        int start;
        int end;
        Node left;
        Node right;
        int count;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.count = 0;
        }
    }


    private Node build(int start, int end) {
        Node root = new Node(start, end);
        if (start == end) {
            return root;
        }
        int mid = (end - start) / 2 + start;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        return root;
    }


    private void update(Node root, int i) {
        root.count++;
        if (root.start == i && root.end == i) {
            return;
        }

        int rootMid = (root.end - root.start) / 2 + root.start;
        if (i <= rootMid) {
            update(root.left, i);
        } else {
            update(root.right, i);
        }
    }

    private int query(Node root, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.count;
        }
        int rootMid = (root.end - root.start) / 2 + root.start;
        if (end <= rootMid) {
            return query(root.left, start, end);
        } else if (rootMid < start) {
            return query(root.right, start, end);
        }
        return query(root.left, start, rootMid) + query(root.right, rootMid + 1, end);
    }

    public List<Integer> countSmaller(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        Node root = build(min, max);
        List<Integer> res= new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(query(root, min, nums[i] - 1));
            update(root, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
