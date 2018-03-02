public class Solution {

    public int[] findOrder(int n, int[][] pre) {
        List<Integer>[] neis = new List[n];
        for (int i = 0; i < n; i++) {
            neis[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for (int[] p : pre) {
            indegree[p[0]]++;
            neis[p[1]].add(p[0]);
        }

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[n];
        int index = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[index++] = cur;
            for (int nei : neis[cur]) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return index == n ? res : new int[0];
    }
}