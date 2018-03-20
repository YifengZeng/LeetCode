class Solution {
    public int largestRectangleArea(int[] h) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= h.length; i++) {
            int cur = -1;
            if (i != h.length) {
                cur = h[i];
            }
            while (!stack.isEmpty() && h[stack.peek()] >= cur) {
                int height = h[stack.pop()];
                int index = stack.isEmpty() ? -1 : stack.peek();
                int width = i - index - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}
