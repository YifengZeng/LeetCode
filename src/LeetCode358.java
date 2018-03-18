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
