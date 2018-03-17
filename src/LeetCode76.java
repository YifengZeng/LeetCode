public class Solution {
  public String minWindow(String s, String t) {
      if (s == null || t == null || s.length() == 0 || t.length() == 0) {
          return "";
      }

      int[] hash = new int[256];
      int[] base = new int[256];
      int i = 0;
      int j = 0;
      int len = Integer.MAX_VALUE;
      String res = "";
      for (; i < t.length(); i++) {
          base[t.charAt(i)]++;
      }

      for (i = 0; i < s.length(); i++) {
          while (j < s.length() && !isSubstring(hash, base)) {
              hash[s.charAt(j)]++;
              j++;
          }
          if (isSubstring(hash,base) && len > j - i) {
              len = j - i;
              res = s.substring(i, j);
          }
          hash[s.charAt(i)]--;
      }

      return res;
  }

  private boolean isSubstring(int[] hash, int[] base) {
      for (int i = 0; i < hash.length; i++) {
          if (hash[i] < base[i]) {
              return false;
          }
      }
      return true;
  }
}


class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for (char ch : t.toCharArray()) {
            hash[ch]++;
        }
        int count = t.length();
        int len = s.length();
        String res = "";
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            hash[ch]--;
            if (hash[ch] >= 0) {
                count--;
            }

            while (count == 0) {
                hash[s.charAt(i)]++;
                if (hash[s.charAt(i)] > 0) {
                    count++;
                }
                if (len >= j - i + 1) {
                    len = j - i + 1;
                    res = s.substring(i, j + 1);
                }
                i++;
            }
            j++;
        }

        return res;
    }
}
