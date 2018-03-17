class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 0;
        int j = 0;
        int k = 2;
        while (j < nums.length) {
            if (i - k < 0 || nums[i - k] < nums[j]) {
                nums[i++] = nums[j];
            }
            j++;
        }

        return i;
    }
}
