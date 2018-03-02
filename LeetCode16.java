public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        throw new IllegalArgumentException("Invalid input");
    }

    Arrays.sort(nums);
    int diff = Integer.MAX_VALUE;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 2; i++) {
        int t = target - nums[i];
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right] - t;
            if (Math.abs(sum) < diff) {
                diff = Math.abs(sum);
                res = sum + target;
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
    return res;
}