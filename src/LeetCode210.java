public class Solution {
    // BFS AC
    public int[] findOrder(int n, int[][] pre) {
        List<Integer>[] map = new List[n];
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] p : pre) {
            map[p[1]].add(p[0]);
            indegree[p[0]]++;
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
            for (int next : map[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return index == n ? res : new int[0];
    }
}




public class Solution {
    // DFS with pruning, AC
    public int[] findOrder(int n, int[][] pre) {
        List<Integer>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] p : pre) {
            map[p[1]].add(p[0]);
        }

        int[] visited = new int[n];
        int[] res = new int[n];
        int[] index = new int[1];
        index[0] = n - 1;
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                continue;
            }
            if (findCircle(map, i, visited, res, index)) {
                return new int[0];
            }
        }

        return index[0] == -1 ? res : new int[0];
    }

    private boolean findCircle(List<Integer>[] map, int cur, int[] visited,
                               int[] res, int[] index) {
        if (visited[cur] == 1) {
            return true;
        }
        if (visited[cur] == -1) {
            return false;
        }

        visited[cur] = 1;
        for (int next : map[cur]) {
            if (visited[next] == -1) {
                continue;
            }
            if (findCircle(map, next, visited, res, index)) {
                return true;
            }
        }
        visited[cur] = -1;
        res[index[0]--] = cur;
        return false;
    }
}
