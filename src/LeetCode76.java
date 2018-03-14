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
