class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int len = 0;
        while (j < s.length() && map.size() < k) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            j++;
            len = Math.max(len, j - i);
        }

        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
                len = Math.max(len, j - i + 1);
            } else {
                map.put(ch, 1);
            }
            j++;
            while (map.size() > k) {
                char remove = s.charAt(i);
                map.put(remove, map.get(remove) - 1);
                if (map.get(remove) == 0) {
                    map.remove(remove);
                }
                i++;
            }
        }
        return len;
    }
}



class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] hash = new int[256];
        int i = 0;
        int j = 0;
        int count = 0;
        int len = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            hash[ch]++;
            if (hash[ch] == 1) {
                count++;
            }
            while (count > k) {
                hash[s.charAt(i)]--;
                if (hash[s.charAt(i)] == 0) {
                    count--;
                }
                i++;
            }
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }
}




class Solution {
    // BitTiger version, need to handle k == 0 seperately
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int len = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.size() < k || map.size() == k && map.containsKey(ch)) {
                map.put(ch, j);
            } else {
                int index = j;
                for (int idx : map.values()) {
                    index = Math.min(index, idx);
                }
                i = index + 1;
                map.remove(s.charAt(index));
                map.put(ch, j);
            }
            len = Math.max(len, j - i + 1);
            j++;
        }

        return len;
    }
}
