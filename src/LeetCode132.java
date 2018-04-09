class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            f[i] = i;
        }

        for (int i = 0; i < len; i++) {
            search(s, f, i, i);
            search(s, f, i, i + 1);
        }

        // System.out.println(Arrays.toString(f));
        return f[len - 1];
    }

    private void search(String s, int[] f, int left, int right) {
        while (left >= 0 && right < s.length()
               && s.charAt(left) == s.charAt(right)) {
            if (left == 0) {
                // left == 0, substring(0, right+1) is palindrom, no cut needed
                f[right] = 0;
            } else {
                f[right] = Math.min(f[right], f[left - 1] + 1);
            }
            left--;
            right++;
        }
    }
}
