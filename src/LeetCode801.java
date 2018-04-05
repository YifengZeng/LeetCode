class Solution {
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        int[] swap = new int[len];
        int[] noswap = new int[len];
        swap[0] = 1;
        for (int i = 1; i < len; i++) {
            swap[i] = len;
            noswap[i] = len;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap[i] = swap[i - 1] + 1;
                noswap[i] = noswap[i - 1];
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                swap[i] = Math.min(noswap[i - 1] + 1, swap[i]);
                noswap[i] = Math.min(noswap[i], swap[i - 1]);
            }
        }

        return Math.min(swap[len - 1], noswap[len - 1]);
    }
}
