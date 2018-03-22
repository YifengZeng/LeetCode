class Solution {
    // AC
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(); // min heap
        for (int n : nums) {
            if (pq.size() < k) {
                pq.offer(n);
            } else {
                if (pq.peek() < n) {
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        return pq.peek();
    }
}



class Solution {
    // AC
    public int findKthLargest(int[] nums, int k) {
        // k is the index now.
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int left = start;
        int right = end;
        int mid = (end - start) / 2 + start;
        int pivot = nums[mid];

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (start <= k && k <= right) {
            return quickSelect(nums, start, right, k);
        } else if (left <= k && k <= end) {
            return quickSelect(nums, left, end, k);
        }
        return nums[right + 1];
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
