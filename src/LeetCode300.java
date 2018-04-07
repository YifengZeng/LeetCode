class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length];
        Arrays.fill(f, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                    max = Math.max(max, f[i]);
                }
            }
        }

        return max;
    }
}



class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] arr = new int[nums.length];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = nums[0];
        int res = 1;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            index = binarySearch(arr, nums[i]);
            arr[index] = nums[i];
            res = Math.max(res, index + 1);
        }

        return res;
    }

    // find the first number that is larger or equal to target
    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] >= target) {
            return start;
        }
        return end;
    }
}
