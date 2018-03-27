class Solution {
    // BFS AC
    public void wallsAndGates(int[][] rooms) {
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < dx.length; j++) {
                    int r = cur[0] + dx[j];
                    int c = cur[1] + dy[j];
                    if (isValid(rooms, r, c) && rooms[r][c] > dist) {
                        rooms[r][c] = dist;
                        q.offer(new int[]{r, c});
                    }
                }
            }
            dist++;
        }
    }

    private boolean isValid(int[][] rooms, int r, int c) {
        if (0 <= r && r < rooms.length && 0 <= c && c < rooms[0].length) {
            return rooms[r][c] != -1;
        }
        return false;
    }
}




class Solution {
    // BFS AC
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfsHelper(rooms, i, j);
                }
            }
        }
    }

    private void bfsHelper(int[][] rooms, int r0, int c0) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Deque<int[]> q = new LinkedList<>();
        int dist = 0;
        q.offer(new int[]{r0, c0});
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                for (int d = 0; d < dx.length; d++) {
                    int r = cur[0] + dx[d];
                    int c = cur[1] + dy[d];
                    if (isValid(rooms, r, c, dist)) {
                        q.offer(new int[]{r, c});
                        rooms[r][c] = dist;
                    }
                }
            }
        }
    }


    private boolean isValid(int[][] rooms, int r, int c, int dist) {
        if (0 <= r && r < rooms.length && 0 <= c && c < rooms[0].length) {
            return rooms[r][c] > dist;
        }
        return false;
    }
}



class Solution {
    // DFS AC
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfsHelper(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfsHelper(int[][] rooms, int r, int c, int dist) {
        if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length) {
            return;
        }
        if (dist != 0 && rooms[r][c] <= dist) {
            return;
        }

        rooms[r][c] = dist++;

        dfsHelper(rooms, r + 1, c, dist);
        dfsHelper(rooms, r - 1, c, dist);
        dfsHelper(rooms, r, c + 1, dist);
        dfsHelper(rooms, r, c - 1, dist);
    }
}
