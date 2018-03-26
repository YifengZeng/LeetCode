class Solution {
    // AC
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> q = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            q.offerLast(cur.val);
            if (q.size() > k) {
                int first = q.peekFirst();
                int last = q.peekLast();
                if (Math.abs((double) (first) - target)
                    > Math.abs((double) (last) - target)) {
                    q.pollFirst();
                } else {
                    q.pollLast();
                }
            }
            cur = cur.right;
        }

        List<Integer> list = new ArrayList<Integer>();
        list.addAll(q);
        return list;
    }
}




class Solution {
    // AC
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<TreeNode> nextStack = createNextStack(root, target);
        Deque<TreeNode> prevStack = createPrevStack(root, target);
        List<Integer> res = new ArrayList<>();

        while (res.size() < k) {
            if (nextStack.isEmpty()) {
                res.add(getPrevNode(prevStack));
            } else if (prevStack.isEmpty()) {
                res.add(getNextNode(nextStack));
            } else {
                double next = Math.abs(nextStack.peek().val - target);
                double prev = Math.abs(prevStack.peek().val - target);
                if (next < prev) {
                    res.add(getNextNode(nextStack));
                } else {
                    res.add(getPrevNode(prevStack));
                }
            }
        }
        return res;
    }

    private int getNextNode(Deque<TreeNode> nextStack) {
        TreeNode cur = nextStack.pop();
        int res = cur.val;
        cur = cur.right;
        while (cur != null) {
            nextStack.push(cur);
            cur = cur.left;
        }
        return res;
    }

    private int getPrevNode(Deque<TreeNode> prevStack) {
        TreeNode cur = prevStack.pop();
        int res = cur.val;
        cur = cur.left;
        while (cur != null) {
            prevStack.push(cur);
            cur = cur.right;
        }
        return res;
    }

    private Deque<TreeNode> createNextStack(TreeNode root, double target) {
        Deque<TreeNode> nextStack = new ArrayDeque<>();
        while (root != null) {
            if (root.val == target) {
                nextStack.push(root);
                return nextStack;
            }
            if (root.val < target) {
                root = root.right;
            } else {
                nextStack.push(root);
                root = root.left;
            }
        }
        return nextStack;
    }

    private Deque<TreeNode> createPrevStack(TreeNode root, double target) {
        Deque<TreeNode> prevStack = new ArrayDeque<>();
        while (root != null) {
            if (root.val < target) {
                prevStack.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return prevStack;
    }
}
