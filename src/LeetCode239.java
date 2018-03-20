class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() == k) {
                res[index++] = pq.peek();
                pq.remove(nums[i - k + 1]);
            }
        }
        return res;
    }
}




class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1) {
            return nums;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i - k + 1 < 0) {
                continue;
            }
            res[index++] = nums[deque.peekFirst()];
            if (deque.peekFirst() == i - k + 1) {
                deque.removeFirst();
            }
        }

        return res;
    }
}
