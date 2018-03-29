class Solution {
    // BFS AC
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] map = initMap(edges, n);
        int[] visited = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                bfsHelper(map, visited, i);
                count++;
            }
        }

        return count;
    }

    private void bfsHelper(List<Integer>[] map, int[] visited, int i) {
        Deque<Integer> q = new LinkedList<>();
        visited[i] = 1;
        q.offer(i);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : map[cur]) {
                if (visited[nei] == 0) {
                    visited[nei] = 1;
                    q.offer(nei);
                }
            }
        }
    }

    private List<Integer>[] initMap(int[][] edges, int n) {
        List<Integer>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        return map;
    }
}



class Solution {
    // DFS AC
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] map = initMap(edges, n);
        int[] visited = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfsHelper(map, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfsHelper(List<Integer>[] map, int[] visited, int cur) {
        for (int nei : map[cur]) {
            if (visited[nei] == 0) {
                visited[nei] = 1;
                dfsHelper(map, visited, nei);
            }
        }
    }

    private List<Integer>[] initMap(int[][] edges, int n) {
        List<Integer>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        return map;
    }
}



class Solution {
    // union find AC
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int pa = find(parents, edge[0]);
            int pb = find(parents, edge[1]);
            if (pa != pb) {
                parents[pa] = pb;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                count++;
            }
        }
        return count;
    }

    private int find(int[] parents, int i) {
        while (parents[i] != i) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}
