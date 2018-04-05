class Solution {
    // DP AC
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int K) {
        K++;
        int[][] prices = new int[n][K + 1];
        for (int[] price : prices) {
            Arrays.fill(price, Integer.MAX_VALUE);
        }

        prices[src][0] = 0;
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < n; j++) {
                prices[j][i] = prices[j][i - 1];
                for (int[] flight : flights) {
                    if (prices[flight[0]][i - 1] != Integer.MAX_VALUE) {
                        prices[flight[1]][i] = Math.min(prices[flight[1]][i],
                                                        prices[flight[0]][i - 1]
                                                        + flight[2]);
                    }
                }
            }
        }

        // for (int[] p : prices) {
        //     System.out.println(Arrays.toString(p));
        // }

        return prices[dst][K] == Integer.MAX_VALUE ? -1 : prices[dst][K];
    }
}




class Solution {
    // DFS time limit exceeded
    public int findCheapestPrice(int n, int[][] flights, int src, int dst,
                                 int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        // map from, to, price
        for (int[] flight : flights) {
            if (map.containsKey(flight[0])) {
                map.get(flight[0]).put(flight[1], flight[2]);
            } else {
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(flight[1], flight[2]);
                map.put(flight[0], temp);
            }
        }

        int[] cheapest = new int[]{Integer.MAX_VALUE};
        helper(n, flights, src, dst, K, cheapest, map, 0);

        return cheapest[0] == Integer.MAX_VALUE ? -1 : cheapest[0];
    }

    private void helper(int n, int[][] flights, int cur, int dst,
                        int k, int[] cheapest,
                        Map<Integer, Map<Integer, Integer>> map, int cost) {
        if (cur == dst) {
            cheapest[0] = Math.min(cheapest[0], cost);
            return;
        }
        if (k < 0) {
            return;
        }

        Map<Integer, Integer> nei = map.getOrDefault(cur, new HashMap<>());
        for (Map.Entry<Integer, Integer> entry : nei.entrySet()) {
            helper(n, flights, entry.getKey(), dst, k - 1, cheapest, map,
                   cost + entry.getValue());
        }
    }
}



class Solution {
    // BFS AC
    public int findCheapestPrice(int n, int[][] flights, int src, int dst,
                                 int K) {
        int[] next = new int[n];
        int[] prev = new int[n];
        Arrays.fill(next, -1);
        Arrays.fill(prev, -1);
        prev[src] = 0;
        next[src] = 0;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        // map from, to, price
        for (int[] flight : flights) {
            if (map.containsKey(flight[0])) {
                map.get(flight[0]).put(flight[1], flight[2]);
            } else {
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(flight[1], flight[2]);
                map.put(flight[0], temp);
            }
        }


        Deque<Integer> q = new LinkedList<>();
        q.offer(src);
        int level = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                Map<Integer, Integer> nei = map.get(cur);
                if (nei == null) {
                    continue;
                }
                for (int to : nei.keySet()) {
                    if (next[to] == -1 || nei.get(to) + prev[cur] < next[to]) {
                        next[to] = nei.get(to) + prev[cur];
                        q.offer(to);
                    }
                }
            }
            System.arraycopy(next, 0, prev, 0, n);
            level++;
            if (level == K) {
                break;
            }
        }

        return prev[dst];
    }
}
