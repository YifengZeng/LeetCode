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


// DFS with memoization AC.
public boolean wordBreak(String s, List<String> dict) {
    int[] memo = new int[s.length()];
    return helper(s, new HashSet<>(dict), 0, memo);
}

private boolean helper(String s, Set<String> dict, int index, int[] memo) {
    if (s.equals("") || dict.contains(s) || memo[index] == 1) {
        return true;
    }
    if (memo[index] == -1) {
        return false;
    }

    boolean res = false;
    for (int i = 0; i < s.length(); i++) {
        String substring = s.substring(0, i);
        if (dict.contains(substring)
            && helper(s.substring(i), dict, i + 1, memo)) {
            memo[index] = 1;
            return true;
        }
    }
    memo[index] = -1;
    return res;
}


// DFS with memoization AC with map, easier to understand
public boolean wordBreak(String s, List<String> dict) {
    Map<String, Boolean> map = new HashMap<>();
    return helper(s, new HashSet<>(dict), 0, map);
}

private boolean helper(String s, Set<String> dict, int index,
                       Map<String, Boolean> map) {
    if (s.equals("") || dict.contains(s)) {
        return true;
    }
    if (map.containsKey(s)) {
        return map.get(s);
    }

    boolean res = false;
    for (int i = 0; i < s.length(); i++) {
        String substring = s.substring(0, i);
        if (dict.contains(substring)
            && helper(s.substring(i), dict, i + 1, map)) {
            map.put(s, true);
            return true;
        }
    }
    map.put(s, false);
    return res;
}


// BitTiger version
public boolean wordBreak(String s, List<String> dict) {
    if (s == null || s.length() == 0) {
        return true;
    }

    int[] cache = new int[s.length()];

    boolean res = helper(s, 0, new HashSet<>(dict), cache);
    System.out.println(Arrays.toString(cache));
    return res;
}

private boolean helper(String s, int index, Set<String> dict, int[] cache) {
    if (index == s.length() || dict.contains(s.substring(index)) || cache[index] == 1) {
        return true;
    }

    if (cache[index] == -1) {
        return false;
    }

    for (int i = index + 1; i < s.length(); i++) {
        if (dict.contains(s.substring(index, i)) && helper(s, i, dict, cache)) {
            cache[index] = 1;
            return true;
        }
    }
    cache[index] = -1;
    return false;
}
