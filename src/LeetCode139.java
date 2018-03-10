public class Solution {

    public boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (f[j] && dict.contains(substring)) {
                    f[i] = true;
                }
            }
        }

        return f[s.length()];
    }
}



public class Solution {
    // TLE
    public boolean wordBreak(String s, List<String> dict) {
        return helper(s, dict);
    }

    private boolean helper(String s, List<String> dict) {
        if (s.equals("") || dict.contains(s)) {
            return true;
        }

        boolean res = false;
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(0, i);
            if (dict.contains(substring) && helper(s.substring(i), dict)) {
                return true;
            }
        }

        return res;
    }
}
