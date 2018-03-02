public void sortColors(int[] nums) {
    if (nums == null || nums.length <= 1) {
        return;
    }
    int i = 0;
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
        if (nums[l] == 0) {
            nums[l] = nums[i];
            nums[i] = 0;
            i++;
            l++;
        } else if (nums[l] == 1) {
            l++;
        } else if (nums[l] == 2) {
            nums[l] = nums[r];
            nums[r] = 2;
            r--;
        }
    }
}