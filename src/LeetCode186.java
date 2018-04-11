public String reverseWords(String str) {
    char[] s str.toCharArray();


    if (s == null || s.length() <= 1) {
        return s;
    }

    String[] strs = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = strs.length - 1; i >= 0; i--) {
        sb.append(strs[i]);
        if (i != 0) {
            sb.append(" ");
        }
    }

    return sb.toString();
}



public String reverseWords(String str) {
    char[] s = str.toCharArray();

    if (s == null || s.length <= 1) {
        return new String(s);
    }

    reverse(s, 0, s.length - 1);
    int i = 0;
    int j = 0;
    while (j < s.length) {
        if (s[j] == ' ') {
            reverse(s, i, j-1);
            i = j+1;
        }
        j++;
    }
    reverse(s, i, j-1);

    return new String(s);
}

private void reverse(char[] s, int i, int j) {
    while (i < j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
        i++;
        j--;
    }
}



class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int i = 0;
        int j = 0;
        while (j < s.length) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(s, i, j - 1);
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}
