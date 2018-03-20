class Solution {
    public int maxArea(int[] h) {
        int i = 0;
        int j = h.length - 1;
        int left = h[i];
        int right = h[j];
        int max = 0;

        while (i < j) {
            if (left < right) {
                max = Math.max(max, (j - i) * left);
                i++;
                left = Math.max(left, h[i]);
            } else {
                max = Math.max(max, (j - i) * right);
                j--;
                right = Math.max(right, h[j]);
            }
        }

        return max;
    }
}
