public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        int i = 0;
        int j = 0;
        int len = 0;
        while (j < s.length()) {
            hash[s.charAt(j)]++;
            while (hash[s.charAt(j)] > 1) {
                hash[s.charAt(i)]--;
                i++;
            }
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }
}
