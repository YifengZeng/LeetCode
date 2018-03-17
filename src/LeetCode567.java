class Solution {
    // primtive idea TLE
    public boolean checkInclusion(String s1, String s2) {
        s1 = getStr(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String substring = getStr(s2.substring(i, i + s1.length()));
            if (s1.equals(substring)) {
                return true;
            }
        }
        return false;
    }

    String getStr(String s1) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}


class Solution {
    // two hash to compare permutation AC, O(256n)
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] base = new int[256];
        int[] hash = new int[256];
        for (char ch : s1.toCharArray()) {
            base[ch]++;
        }
        int count = s1.length();
        int i = 0;
        int j = 0;

        for (; j < s1.length() - 1; j++) {
            hash[s2.charAt(j)]++;
        }

        while (j < s2.length()) {
            hash[s2.charAt(j)]++;
            if (isPermute(base, hash)) {
                return true;
            }
            hash[s2.charAt(i)]--;
            i++;
            j++;
        }

        return false;
    }

    private boolean isPermute(int[] base, int[] hash) {
        for (int i = 0; i < base.length; i++) {
            if (base[i] != hash[i]) {
                return false;
            }
        }
        return true;
    }
}



class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] hash = new int[128];
        for (char ch : s1.toCharArray()) {
            hash[ch]++;
        }

        int count = s1.length();
        int j = 0;
        while (j < s2.length()) {
            char ch = s2.charAt(j);
            // System.out.println(ch + "," + j + "," + count + "," + Arrays.toString(hash));
            hash[ch]--;
            if (hash[ch] >= 0) {
                count--;
            }
            if (count == 0) {
                return true;
            }
            int i = j - s1.length() + 1;
            if (i >= 0) {
                if (hash[s2.charAt(i)] >= 0) {
                    count++;
                }
                hash[s2.charAt(i)]++;
            }
            j++;
        }

        return false;
    }
}
