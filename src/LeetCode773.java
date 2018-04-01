class Solution {
    // BFS AC
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] b : board) {
            for (int num : b) {
                start.append(num + "");
            }
        }

        Deque<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(start.toString());
        visited.add(start.toString());

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return dist;
                }
                offerNext(q, visited, cur);
            }
            dist++;
        }

        return -1;
    }

    private void offerNext(Deque<String> q, Set<String> visited, String cur) {
        char[] chars = cur.toCharArray();
        int index = cur.indexOf('0');
        // move: +-1, +-3
        int[] dx = {1, -1, 3, -3};
        for (int i = 0; i < dx.length; i++) {
            int nextIndex = index + dx[i];
            if (nextIndex < 0 || nextIndex >= cur.length()
                || index == 2 && nextIndex == 3
                || index == 3 && nextIndex == 2) {
                continue;
            }

            swap(chars, index, nextIndex);
            String next = new String(chars);
            if (!visited.contains(next)) {
                visited.add(next);
                q.offer(next);
            }
            swap(chars, index, nextIndex);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
}



class Solution {
    // AC
    class State {
        private int[][] board;
        private int x;
        private int y;
        private int moves;
        private final int[] dx = {0, 0, 1, -1};
        private final int[] dy = {1, -1, 0, 0};

        public State(int[][] board) {
            this.board = new int[board.length][board[0].length];
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    this.board[r][c] = board[r][c];
                }
            }
        }

        @Override
        public int hashCode() {
            int res = 0;
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    res = res * 10 + board[r][c];
                }
            }
            return res;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof State)){
                return false;
            }
            State s = (State) obj;
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    if (board[r][c] != s.board[r][c]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isSolved() {
            return hashCode() == 123450;
        }

        public List<State> getNextStates() {
            List<State> nextStates = new ArrayList<>();
            int[] cur = findCurrentZero();
            for (int i = 0; i < dx.length; i++) {
                int r = cur[0] + dx[i];
                int c = cur[1] + dy[i];
                if (isValid(r, c)) {
                    swap(cur[0], cur[1], r, c);
                    nextStates.add(new State(board));
                    swap(cur[0], cur[1], r, c);
                }
            }
            return nextStates;
        }

        private void swap(int r0, int c0, int r, int c) {
            int temp = board[r0][c0];
            board[r0][c0] = board[r][c];
            board[r][c] = temp;
        }

        private boolean isValid(int r, int c) {
            if (0 <= r && r < board.length && 0 <= c && c < board[0].length) {
                return true;
            }
            return false;
        }

        private int[] findCurrentZero() {
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    if (board[r][c] == 0) {
                        return new int[]{r, c};
                    }
                }
            }
            return null;
        }
    }

    public int slidingPuzzle(int[][] board) {
        State cur = new State(board);
        Deque<State> q = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        q.offer(cur);
        visited.add(cur);

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                cur = q.poll();
                if (cur.isSolved()) {
                    return dist;
                }
                for (State next : cur.getNextStates()) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            dist++;
        }

        return -1;
    }
}
