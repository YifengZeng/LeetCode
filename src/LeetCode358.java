class Solution {

    class Pair {
        char ch;
        int n;
        public Pair(char ch, int n) {
            this.ch = ch;
            this.n = n;
        }
    }

    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }

        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.n - a.n);
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                pq.offer(new Pair((char) (i + 'a'), hash[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        Deque<Pair> q = new LinkedList<>();
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            sb.append(cur.ch);
            cur.n = cur.n - 1;
            q.offer(cur);
            if (q.size() < k) {
                continue;
            }
            Pair next = q.poll();
            if (next.n > 0) {
                pq.offer(next);
            }
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}




class Solution {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        int[] valid = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = findIndex(count, valid, i);
            if (index == -1) {
                return "";
            }
            count[index]--;
            valid[index] = i + k;
            sb.append((char) (index + 'a'));
        }

        return sb.toString();
    }

    private int findIndex(int[] count, int[] valid, int index) {
        int nextIndex = -1;
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && index >= valid[i]) {
                max = count[i];
                nextIndex = i;
            }
        }
        return nextIndex;
    }
}
