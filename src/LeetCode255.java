class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1,
                      Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(int[] pre, int start, int end, int min, int max) {
        if (start > end) {
            return true;
        }

        int root = pre[start];
        if (root <= min || root >= max) {
            return false;
        }

        int mid = start; // why mid = start + 1 will cause stack overflow?
        while (mid <= end && pre[mid] <= root) {
            mid++;
        }

        return helper(pre, start + 1, mid - 1, min, root)
            && helper(pre, mid, end, root, max);
    }
}




class Solution {
    // Qinyuan version
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int low = Integer.MIN_VALUE;
        for (int val : preorder) {
            if (val < low) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < val) {
                low = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }
}
