class Solution {
public:
    void reverseWords(vector<char>& str) {
        reverse(str, 0, str.size() - 1);
        int i = 0;
        int j = 0;
        while (j < str.size()) {
            if (str[j] == ' ') {
                reverse(str, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(str, i, j - 1);
    }

    void reverse(vector<char>& str, int i, int j) {
        while (i < j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
            i++;
            j--;
        }
    }
};
