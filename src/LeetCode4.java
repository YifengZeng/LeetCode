class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKth(nums1, nums2, 0, 0, len / 2 + 1);
        }
        return (findKth(nums1, nums2, 0, 0, len / 2)
                + findKth(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
    }

    private int findKth(int[] nums1, int[] nums2, int i, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int n1 = i + k / 2 - 1 >= nums1.length ?
                 Integer.MAX_VALUE : nums1[i + k / 2 - 1];
        int n2 = j + k / 2 - 1 >= nums2.length ?
                 Integer.MAX_VALUE : nums2[j + k / 2 - 1];
        if (n1 < n2) {
            return findKth(nums1, nums2, i + k / 2, j, k - k / 2);
        }
        return findKth(nums1, nums2, i, j + k / 2, k - k / 2);
    }
}
