class Solution {
    // BFS AC
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = initMap(edges, n);
        Set<Integer> visited = new HashSet<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                Deque<Integer> q = new LinkedList<>();
                q.offer(i);
                visited.add(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int nei : map.get(cur)) {
                        if (!visited.contains(nei)) {
                            q.offer(nei);
                            visited.add(nei);
                        }
                    }
                }
                count++;
            }
        }

        return count;
    }

    private Map<Integer, Set<Integer>> initMap(int[][] edges, int n) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
}



class Solution {
    // DFS AC
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = initMap(edges, n);
        Set<Integer> visited = new HashSet<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfsHelper(map, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfsHelper(Map<Integer, Set<Integer>> map, Set<Integer> visited, int cur) {
        for (int nei : map.get(cur)) {
            if (!visited.contains(nei)) {
                visited.add(nei);
                dfsHelper(map, visited, nei);
            }
        }
    }

    private Map<Integer, Set<Integer>> initMap(int[][] edges, int n) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
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
