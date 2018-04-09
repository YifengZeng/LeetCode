class Solution {
    public int numberOfArithmeticSlices(int[] A) {

        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int j = i + 1;
            int diff = A[j] - A[i];
            for (; j + 1 < A.length; j++) {
                if (A[j + 1] - A[j] == diff) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}




class Solution {
    public int numberOfArithmeticSlices(int[] A) {

        int res = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1;
            int diff = A[j] - A[i];
            int count = 0;
            for (; j + 1 < A.length; j++) {
                if (A[j + 1] - A[j] == diff) {
                    count++;
                } else {
                    break;
                }
            }
            i = j - 1;
            count = getTotalCount(count);
            // System.out.println("count = " + count + ", i = " + i);
            res += count;
        }
        return res;
    }

    private int getTotalCount(int c) {
        if (c <= 1) {
            return c;
        }
        return (1 + c) * c / 2;
    }
}
